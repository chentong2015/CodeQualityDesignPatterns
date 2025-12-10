import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// User Management 实战项目代码重构
public class ResourceHelper {

    private static final String DELIMITER = "/";
    private static final String MESSAGE = "cannot read the resource {} in classpath";

    public String loadResource(final String classpath) throws IOException, URISyntaxException {
        final String cleanPath = cleanAndCanonicalize(classpath);
        URL resource = this.getClass().getClassLoader().getResource(cleanPath);
        if (resource != null) {
            URI uri = resource.toURI();
            // log.debug("URI: {}", uri);

            // Load content from the specific file classpath
            try {
                return new String(Files.readAllBytes(Paths.get(uri)), StandardCharsets.UTF_8);
            } catch (Exception e) {
                // log.debug(MESSAGE, classpath, e);
            }

            // Load from the specific zip file path
            try (FileSystem zipFs = FileSystems.newFileSystem(uri, Collections.singletonMap("create", "true"))) {
                Path path = zipFs.getPath(DELIMITER + cleanPath);
                // log.debug("attempting to read {} in {}", path, zipFs);
                return new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
            } catch (Exception e) {
                // log.debug(MESSAGE, classpath, e);
            }

            // Load Content by Stream
            try (InputStream is = resource.openStream()) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                byte[] buff = new byte[1024 * 8];
                while (is.available() > 0) {
                    int read = is.read(buff);
                    out.write(buff, 0, read);
                }
                return new String(out.toByteArray(), StandardCharsets.UTF_8);
            } catch (Exception e) {
                // log.debug(MESSAGE, classpath, e);
            }
        }
        return null;
    }

    /**
     * Removes the path traversing elements from the given path (../), and gets the canonical path.
     * @param path to be cleaned and canonicalized.
     * @return clean and canonicalized path.
     * @throws IOException when system fails during canonical path construction
     *      (canonical pathname may require filesystem queries)
     */
    public static String cleanAndCanonicalize(String path) throws IOException {
        if (path == null) {
            path = "";
        }
        path = Stream.of(path.split("[/\\\\]"))
                .filter(str -> !"..".equals(str))
                .collect(Collectors.joining(File.separator));
        return new File(path).getCanonicalPath();
    }
}
