package org.mql.java.xml.dom;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DeleteEtudiantWithId {

	private XmlParser parse;
	
	public DeleteEtudiantWithId( XmlParser parse) {
		this.parse = parse;
		
	}
	public XmlParser getParse() {
		return parse;
	}
	public void deleteEtudiantWithId(String codeE,String filePath) {
		NodeList classNodes = parse.getRootElement().getElementsByTagName("etudiant");
		for (int i = 0; i < classNodes.getLength(); i++) {
			Element etudiantElement = (Element) classNodes.item(i);
			String codeEtudiant = etudiantElement.getAttribute("codeE");
			if(codeEtudiant.equals(codeE)) {
				 Node parentNode = etudiantElement.getParentNode();
	                parentNode.removeChild(etudiantElement);
	                break;
			}
	    }
		 
  }
	
}



