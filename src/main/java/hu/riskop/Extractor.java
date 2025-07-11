package hu.riskop;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.*;

public class Extractor {

    public String extractObjectInTitleInDoc(String xml) throws Exception {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        builderFactory.setNamespaceAware(true);
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document xmlDocument = builder.parse(new ByteArrayInputStream(xml.getBytes()));
        XPath xPath = XPathFactory.newInstance().newXPath();
        String expression = "" +
                "/*[local-name()='Doc' and namespace-uri()='http://www.my.hu/somethingo']" +
                "/*[local-name()='Title' and namespace-uri()='http://www.my.hu/somethingo']" +
                "/*[local-name()='Object' and namespace-uri()='http://www.my.hu/otherthingo']" +
                "/text()" +
                "";
        String title = (String) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.STRING);

        return title;
    }
}
