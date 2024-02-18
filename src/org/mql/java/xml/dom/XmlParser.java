package org.mql.java.xml.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlParser {

	private Document document;
	private Element rootElement;

	public XmlParser(String source) {
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			File xmlFile = new File(source);
			this.document = builder.parse(xmlFile);
			this.rootElement = document.getDocumentElement();
		} catch (Exception e) {
			System.out.println("erreur dans parseur" + e.getMessage());
		}

	}

	public Document getDocument() {
		return document;
	}

	public Element getRootElement() {
		return rootElement;
	}
	public void writeToFile(String filePath) {
	    try {
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        DOMSource source = new DOMSource(document);
	        StreamResult result = new StreamResult(new File(filePath));
	        transformer.transform(source, result);

	        System.out.println("Modifications enregistrées avec succès dans le fichier : " + filePath);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
