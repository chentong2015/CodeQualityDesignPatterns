package design_patterns.pattern1_creation.factory.abstract_factory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

// AbstractFactory
// Factory of Factories
// Factory of related objects
// Common Interface, defer to subclass
public class BaseAbstractFactory {

    // ex: DocumentBuilder
    // 从抽象工厂中获取指定的Factory，再通过工厂构建指定的instance
    public void testJavaXmlApiAbstractFactoryExample() throws ParserConfigurationException, IOException, SAXException {
        String xml = "<document><body>abstract factory</body></document>";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xml.getBytes());

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder factory = documentBuilderFactory.newDocumentBuilder();
        Document doc = factory.parse(byteArrayInputStream);

        System.out.println(doc.getDocumentElement().getNodeName()); // ouput: document
        System.out.println(documentBuilderFactory.getClass());
        System.out.println(factory.getClass());
    }
}
