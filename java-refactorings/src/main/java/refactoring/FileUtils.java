package refactoring;

import java.io.*;
import java.net.URL;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.parsers.FactoryConfigurationError;

import static javax.xml.XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI;

// Java Batch 实战项目源码重构
public class FileUtils {

    private final static String XSD_END_OF_FILE = ".xsd";

    private FileUtils() {

    }

    public static void validateXmlFile(String xmlFilePath, String classPathXsdFileName) throws Exception {
        File xmlfile = new File(xmlFilePath);
        validateXmlFile(xmlfile, classPathXsdFileName);
    }

    public static void validateXmlFile(File xmlfile, String classPathXsdFileName) throws Exception {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        InputStream targetStream = null;
        try {
            targetStream = new FileInputStream(xmlfile);

            //Retrieve the xsi:noNamespaceSchemaLocation of imported .xml file
            String noNamespaceSchemaLocationOfXmlFile = extractNoNamespaceSchemaLocationFromXmlFileOrNull(targetStream);

            //Validation with xsi:noNamespaceSchemaLocation if not null (i.e. WC, WC Premium, WC Premium plus .xml files)
            if (noNamespaceSchemaLocationOfXmlFile != null) {

                // Conversion of classPathXsdFileName into File in order to extract the name of the xsd
                File xsdFile = new File(classPathXsdFileName);

                //isNoNamespaceSchemaLocationOfImportedXmlMatchWithInternalXSD is at true if xsi:noNamespaceSchemaLocation match with the .xsd
                boolean isNoNamespaceSchemaLocationOfImportedXmlMatchWithInternalXSD = (xsdFile.getName()).equals(noNamespaceSchemaLocationOfXmlFile);

                //If isNoNamespaceSchemaLocationOfImportedXmlMatchWithInternalXSD is at false no validation of Xml file by .xsd
                if (!isNoNamespaceSchemaLocationOfImportedXmlMatchWithInternalXSD) {
                    throw new Exception();
                }
            }

            //Validation of .xml file with .xsd Schema
            Schema schema = factory.newSchema(getClassPathFileURL(classPathXsdFileName));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlfile));

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } finally {
            //Closes targetStream and releases any system resources associated with it
            close(targetStream);
        }
    }

    public static URL getClassPathFileURL(String fileName) {
        return FileUtils.class.getClassLoader().getResource(fileName);
    }

    //Closes stream closeableSourceOrDestination and releases any system resources associated with it
    private static void close(Closeable closeableSourceOrDestination) {
        if (closeableSourceOrDestination != null) {
            try {
                closeableSourceOrDestination.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    //Retrieve value of xsi:schemaLocation, xsi:noNamespaceSchemaLocation of .xml file : is null for Dow Jones, and are not taken into account if value doesn't finish with .xsd
    public static String extractNoNamespaceSchemaLocationFromXmlFileOrNull(InputStream xmlInput) {

        try {
            final XMLInputFactory f = XMLInputFactory.newInstance();
            f.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
            f.setProperty(XMLInputFactory.SUPPORT_DTD, false);
            final XMLStreamReader r = f.createXMLStreamReader(xmlInput);
            while (r.hasNext()) {
                final int eventType = r.next();
                if (XMLStreamReader.START_ELEMENT == eventType) {
                    for (int i = 0; i <= r.getAttributeCount(); i++) {

                        //Check if a tag xsi:schemaLocation, xsi:noNamespaceSchemaLocation ... exists in .xml file
                        final boolean foundSchemaNameSpace = W3C_XML_SCHEMA_INSTANCE_NS_URI.equals(r.getAttributeNamespace(i));

                        if (foundSchemaNameSpace) {
                            final boolean isAttributeValueAXSDFile;

                            //Check if a tag xsi:schemaLocation, xsi:noNamespaceSchemaLocation finish with .xsd
                            if (r.getAttributeValue(i) != null) {

                                isAttributeValueAXSDFile = r.getAttributeValue(i).endsWith(XSD_END_OF_FILE);
                                if (isAttributeValueAXSDFile) {
                                    return r.getAttributeValue(i);
                                }
                            }
                        }
                    }
                    return null;
                }
            }
            return null;
        } catch (FactoryConfigurationError | XMLStreamException e) {
            throw new RuntimeException(e);
        }
    }
}