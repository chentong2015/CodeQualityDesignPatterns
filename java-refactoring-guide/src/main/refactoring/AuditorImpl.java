import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class AuditorImpl {

    private final static String DEFAULT_AUDIT_QUEUE_FILE_NAME = "./work/audit/eventqueue.json";
    private final static String ACKNOWLEDGE_STRING = ".result.OK.";
    private final static String ACKNOWLEDGE_FILE_PATTERN = ACKNOWLEDGE_STRING + "%06d.tmp";
    private final static String TO_SEND_FILE_SUFFIX = ".to_send.txt";

    private File queueFile;
    private volatile boolean overflow = false;
    private final static int MAX_LENGTH_DATA_RAW = 2000;
    private int maxQueueSize = 1000;

    private Logger logger = LoggerFactory.getLogger(AuditorImpl.class);

    private void createQueueIfNotExists() {
        this.queueFile = new File(DEFAULT_AUDIT_QUEUE_FILE_NAME);
        try {
            queueFile.getParentFile().mkdirs();
            queueFile.createNewFile();
        } catch (IOException e) {
            logger.error("Cannot create temporary audit file at location: {}" + queueFile.getAbsoluteFile());
        }
    }

    public void log(AuditEntry entry) {
        if (overflow) {
            logger.error("Audit queue overflow. Audit entry can not be send: " + entry);
            return;
        }

        queueEvent(entry);
    }

    // Return an unique audit queue copy file and reset the main audit queue
    private Path getPendingAudits() {

        synchronized (queueFile) {

            if (!isQueueEmpty() && queueFile.exists()) {

                Path pendingQueue = null;
                try {
                    pendingQueue = Paths.get(queueFile.getAbsolutePath() + "_" + UUID.randomUUID() + TO_SEND_FILE_SUFFIX).toAbsolutePath().normalize();
                    Files.move(queueFile.toPath(), pendingQueue, StandardCopyOption.ATOMIC_MOVE);
                    queueFile.createNewFile();

                    return pendingQueue;

                } catch (Exception e) {
                    logger.error("Unable to create a copy of the audit message queue from " + queueFile.getName() + " to " + pendingQueue, e);
                }

            }
            return null;
        }
    }

    // No need to be thread safe, queuePath have to be a unique temporary file
    // Return the size of the queue: the number of audit lines processed included those in error.
    private long sendQueue(Function<AuditEntry, SendingResult> sender) {
        long auditCount = 0L;

        Path queuePath = null;
        try {
            queuePath = getPendingAudits();
            if (null == queuePath) {
                return auditCount;
            }
            File queueFile = queuePath.toFile();
            if (!queueFile.exists() || queueFile.length() == 0) {
                return auditCount;
            }

            ObjectMapper mapper = new ObjectMapper();
            String line;

            File tmpFile = new File(queueFile.getAbsolutePath() + ".tmp");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(queueFile), "UTF-8"))) {

                while ((line = reader.readLine()) != null) {
                    try {
                        ++auditCount;
                        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tmpFile, false), "UTF-8"))) {
                            writer.write(line);
                            writer.newLine();
                        }
                        AuditEntry auditEntry = mapper.readValue(line, AuditEntry.class);
                        SendingResult status = SendingResult.FAILED;
                        try {
                            status = sender.apply(auditEntry);
                        } catch (Exception e) {
                            logger.error("Exception during sending audit: " + e.getMessage());
                            logger.debug("stack:", e);
                        }

                        if (!status.equals(SendingResult.OK)) {
                            tmpFile.delete();
                        } else {
                            final String finalFileName = String.format(queueFile.getAbsolutePath() + ACKNOWLEDGE_FILE_PATTERN, auditCount);
                            final Path finalStatusPath = Paths.get(finalFileName).toAbsolutePath().normalize();
                            Files.move(tmpFile.toPath(), finalStatusPath, StandardCopyOption.ATOMIC_MOVE);
                        }

                    } catch (Exception e) {
                        logger.error("Unable to map audit entry from file " + queueFile.getName() + ": " + line, e);
                    }
                }
            } catch (Exception e) {
                logger.error("Unable to read audit file " + queueFile.getName(), e);
            }
        } finally {
            requeueMissingAuditsAndDelete(queuePath);
        }

        return auditCount;
    }

    // No need to be thread safe, queuePath have to be a unique temporary file
    private void requeueMissingAuditsAndDelete(Path queuePath) {

        if (null == queuePath) {
            return;
        }

        File queueFile = queuePath.toFile();
        if (!queueFile.exists() || queueFile.length() == 0) {
            return;
        }

        File tmpFile = new File(queueFile.getAbsolutePath() + ".requeue.tmp");
        Path parentDir = null;
        try {
            parentDir = Paths.get(queueFile.getParent()).toAbsolutePath().normalize();
            Set<String> auditAlreadySent = new HashSet<>();
            applyOnFiles("retrieve audit already sent", queueFile, queuePath.getFileName() + ACKNOWLEDGE_STRING,
                    path -> auditAlreadySent.add(path.getFileName().toString()));

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(queueFile), "UTF-8"));
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tmpFile, false), "UTF-8"))) {

                long auditCounter = 0;
                String line;

                while ((line = reader.readLine()) != null) {
                    try {
                        ++auditCounter;
                        final String pattern = String.format(queuePath.getFileName() + ACKNOWLEDGE_FILE_PATTERN, auditCounter);
                        if (auditAlreadySent.contains(pattern)) {
                            continue;
                        }
                        writer.write(line);
                        writer.newLine();
                    } catch (Exception e) {
                        logger.error("Unable to requeue audit on line " + auditCounter + ": " + line);
                    }
                }
            } catch (Exception e) {
                logger.error("Unable to read audit file " + queueFile.getName(), e);
            }
        } finally {

            finalizeRequeue(tmpFile);

            if (null != parentDir) {
                applyOnFiles("delete temporary audit file", queueFile, queuePath.getFileName().toString(),
                        path -> {
                            try {
                                Files.deleteIfExists(path);
                            } catch (Exception e) {
                                logger.error("Unable to delete temporary audit file " + path);
                            }
                        });
            }
            queueFile.delete();
        }
    }

    private void finalizeRequeue(File tmpFile) {
        if (null == tmpFile || !tmpFile.exists() || tmpFile.length() == 0) {
            return;
        }
        synchronized (queueFile) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(queueFile), "UTF-8"));
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tmpFile, true), "UTF-8"))) {

                IOUtils.copyLarge(reader, writer);
            } catch (Exception e) {
                logger.error("Unable to finalize requeue of audit file " + tmpFile.getName(), e);
            }
            try {
                queueFile.delete();

                // Warning: Critical section here: delete of queueFile without move of the tmp file

                Files.move(tmpFile.toPath(), queueFile.toPath(), StandardCopyOption.ATOMIC_MOVE);

            } catch (Exception e) {
                logger.error("Unable to switch queues " + tmpFile.getName() + " and " + queueFile.getName(), e);
            }
        }
    }

    private void applyOnFiles(String actionDescription, File queueFile, String pattern, Consumer<Path> action) {

        if (null == queueFile || null == pattern || StringUtils.isEmpty(pattern) || null == action) {
            return;
        }

        try {
            Path parentDir = Paths.get(queueFile.getParent()).toAbsolutePath().normalize();
            try (Stream<Path> pathStream = Files.list(parentDir)) {
                pathStream.filter(path -> path.getFileName().toString().startsWith(pattern))
                        .forEach(path1 -> {
                            try {
                                action.accept(path1);
                            } catch (Exception e) {
                                logger.error("Unable to apply action " + actionDescription + " on file " + path1);
                            }
                        });
            }
        } catch (Exception e) {
            logger.error("unable to apply action " + actionDescription);
        }
    }

    void restoreMissingAudits() {
        applyOnFiles("Restore initial audit queue", queueFile, queueFile.getName(), path -> {
            if (path.toString().endsWith(TO_SEND_FILE_SUFFIX)) {
                requeueMissingAuditsAndDelete(path);
            }
        });
    }

    private void queueEvent(AuditEntry... entries) {

        if (null == entries || 0 == entries.length) {
            return;
        }

        synchronized (queueFile) {

            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(queueFile, true), "UTF-8"))) {

                ObjectMapper mapper = new ObjectMapper();
                for (AuditEntry entry : entries) {
                    try {
                        if (logger.isTraceEnabled()) {
                            logger.trace("Queueing audit event " + entry + " to " + queueFile.getName());
                        }
                        writer.write(mapper.writeValueAsString(entry));
                        writer.newLine();
                    } catch (Exception e) {
                        logger.error("Unable to queue audit event " + entry, e);
                    }
                }
            } catch (Exception e) {
                logger.error("Unable to queue audit event list " + entries, e);
            }
        }
    }
    public boolean isOverflow() {
        return overflow;
    }

    public void log(String businessUnitId, String operatorId, String eventId) {
        AuditEntry entry = new AuditEntry();
        entry.setBusinessUnitId(businessUnitId);
        entry.setEventId(eventId);
        entry.setOperatorId(operatorId);

        this.log(entry);
    }

    public boolean isQueueEmpty() {
        synchronized (queueFile) {
            return (queueFile.length() == 0);
        }
    }

    private enum SendingResult {OK, FAILED}

    // ------------------------------------------------------------------------------------------------------------------------
    // This task will keep trying to send unsent audit entries if found
    // ------------------------------------------------------------------------------------------------------------------------
    private class SendWaitingEventsTask implements Runnable {

        @Override
        public void run() {
            // Restore missing audit events from temporary files in case of crash
            restoreMissingAudits();

            // Normal loop
            try {
                while (true) {
                    sendWaitingEvents();
                    Thread.sleep(5000);
                }

            } catch (InterruptedException e) {
                logger.info("Send queue task stopped.");
            }
        }

        private void sendWaitingEvents() {
            if (!isQueueEmpty()) {
                // Is there a UP audit service ?
                logger.trace("Audit events not in sync, trying to send them...");

                final long nbAudits = sendQueue(entry -> {

                    if (!isValidDataRawSize(entry)) {
                        // Log error and ignore sending large payload data raw event
                        return SendingResult.OK;
                    }

                    long start = 0L;
                    if (logger.isDebugEnabled()) {
                        start = System.currentTimeMillis();
                    }

                    // TODO: Update POST to GET request
                    String url = "http://localhost:8080/v1/log";
                    RestTemplate restTemplate = new RestTemplate();
                    String response = restTemplate.getForObject(url, String.class);

                    if (logger.isDebugEnabled()) {
                        long end = System.currentTimeMillis();
                        logger.trace("Audit sent in " + (end - start) + " ms : " + entry);
                    }

                    if (response.equals("success")) {
                        return SendingResult.OK;
                    }
                    return SendingResult.FAILED;
                });

                if (nbAudits > maxQueueSize) {
                    overflow = true;
                    logger.error("The event queue size is " + nbAudits + ". Resync is disabled. Will require to restart the service with -resyncevt option.");
                } else {
                    overflow = false;
                }
            }
        }

        private boolean isValidDataRawSize(AuditEntry auditEntry) {
            ObjectMapper jsonMapper = new ObjectMapper();
            try {
                String strDataRaw = jsonMapper.writeValueAsString(auditEntry.getObjectProperties());
                if (!strDataRaw.isEmpty() && strDataRaw.getBytes(StandardCharsets.UTF_8).length > MAX_LENGTH_DATA_RAW) {
                    logger.error("Audit cannot be sent: payload size has more than {} characters: {}", MAX_LENGTH_DATA_RAW, strDataRaw);
                    return false;
                }
                return true;
            } catch (Exception exception) {
                logger.error("Unable to serialize Data into a JSON structure", exception);
                return false;
            }
        }
    }
}