package org.mql.java.models;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class XmlDocumentBuilder {
	private File file;
	private Document doc;

	public XmlDocumentBuilder() {
		try {
			   file = new File("C:\\projects java\\xml_project_el mehdi_amarti_riffi\\resources\\etudiants.xml");
	            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	           this. doc = dBuilder.parse(file);
		} catch (Exception e) {
			System.out.println("erreur d ecriture xml " + e.getMessage());
		}
	}

	public File getFile() {
		return file;
	}

	public Document getDoc() {
		return doc;
	}
	

}
