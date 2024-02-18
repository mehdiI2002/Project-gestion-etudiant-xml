package org.mql.java.xml.dom;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class UpdateEtudiantWithId {
	private XmlParser parse;
	public UpdateEtudiantWithId(XmlParser parse) {
		this.parse = parse;
		
	}
	public XmlParser getParse() {
		return parse;
	}
	public void updateEtudiantWithId(String codeE, String newNom, String newPrenom, String newAge, String newEmail, String newTel) throws Exception {
		NodeList classNodes = parse.getRootElement().getElementsByTagName("etudiant");

	    for (int i = 0; i < classNodes.getLength(); i++) {
	        Element etudiantElement = (Element) classNodes.item(i);
	        String codeEtudiant = etudiantElement.getAttribute("codeE");
	        if (codeEtudiant.equals(codeE)) {
	            etudiantElement.getElementsByTagName("nom").item(0).setTextContent(newNom);
	            etudiantElement.getElementsByTagName("prenom").item(0).setTextContent(newPrenom);
	            etudiantElement.getElementsByTagName("age").item(0).setTextContent(newAge);
	            etudiantElement.getElementsByTagName("email").item(0).setTextContent(newEmail);
	            etudiantElement.getElementsByTagName("tel").item(0).setTextContent(newTel);

	            break;

	        }     
	               
	               
	           
		}
	}
		
	

}
