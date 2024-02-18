package org.mql.java.models;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XmlFileModifier {
	XmlDocumentBuilder write;

	public XmlFileModifier(XmlDocumentBuilder write) {
		this.write = write;

	}

	public void modifierXmlFile(String filePath) {
		try {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(write.getDoc());
        StreamResult result = new StreamResult(write.getFile());
        transformer.transform(source, result);

        System.out.println("Le fichier XML a été modifié avec succès.");    
        } 
		catch (Exception e) {
        e.printStackTrace();
    }
}
	
	
}

