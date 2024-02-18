package org.mql.java.models;

import org.w3c.dom.Element;

public class WriteEtudiant {
	private XmlDocumentBuilder write;
	public WriteEtudiant(XmlDocumentBuilder write) {
		this.write = write;
	}
	public void writeEtudiant(String code,String nom,String prenom,String age,String email,String tel ) {
	
		 Element etudiantElement = write.getDoc().createElement("etudiant");
         etudiantElement.setAttribute("codeE",code);
     	if (!nom.isEmpty()) {
         Element nomElement = write.getDoc().createElement("nom");
         nomElement.appendChild( write.getDoc().createTextNode(nom));
         etudiantElement.appendChild(nomElement);
     	}
    	if (!prenom.isEmpty()) {
         Element prenomElement = write.getDoc().createElement("prenom");
         prenomElement.appendChild(write.getDoc().createTextNode(prenom));
         etudiantElement.appendChild(prenomElement);
    	}
    	if (!age.isEmpty()) {
         Element ageElement = write.getDoc().createElement("age");
         ageElement.appendChild(write.getDoc().createTextNode(age));
         etudiantElement.appendChild(ageElement);
    	}
    	if (!email.isEmpty()) {
         Element emailElement = write.getDoc().createElement("email");
         emailElement.appendChild(write.getDoc().createTextNode(email));
         etudiantElement.appendChild(emailElement);
    	}
    	if(!tel.isEmpty()) {
         Element telElement = write.getDoc().createElement("tel");
         telElement.setAttribute("type", "fixe");
         telElement.appendChild(write.getDoc().createTextNode(tel));
         etudiantElement.appendChild(telElement);
    	}

         // Ajout de l'élément etudiant au document
         write.getDoc().getDocumentElement().appendChild(etudiantElement);
	}
	public XmlDocumentBuilder getWrite() {
		return write;
	}
	public void setWrite(XmlDocumentBuilder write) {
		this.write = write;
	}
	

}
