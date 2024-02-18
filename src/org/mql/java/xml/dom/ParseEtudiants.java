package org.mql.java.xml.dom;

import java.util.Vector;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParseEtudiants {

	private XmlParser parse;
	private Vector<String > noms ;
	private Vector<String> prenoms;
	private Vector<String> ages;
	private Vector<String> emails;
	private Vector<String>  tels;
	private Vector<String> codesEtudiants;

	public ParseEtudiants( XmlParser parse) {
		this.parse = parse;
		noms = new Vector<String>();
		prenoms = new Vector<String>();
		ages = new Vector<>();
		emails = new Vector<String>();
		tels = new Vector<>();
		codesEtudiants = new Vector<String>();

	}
	public void parseEtudiants() {
		NodeList classNodes = parse.getRootElement().getElementsByTagName("etudiant");
		for (int i = 0; i < classNodes.getLength(); i++) {
			Element etudiantElement = (Element) classNodes.item(i);
			String codeEtudiant = etudiantElement.getAttribute("codeE");
			codesEtudiants.add(codeEtudiant);
			NodeList childNodes = etudiantElement.getChildNodes();
			for (int j = 0; j < childNodes.getLength(); j++) {
				Node childNode = childNodes.item(j);
				if (childNode.getNodeName().equals("nom")) {
					String nomContent = childNode.getTextContent();
					noms.add(nomContent);
				}
				else if(childNode.getNodeName().equals("prenom")) {
					String prenom = childNode.getTextContent();
					prenoms.add(prenom);

				}
				else if( childNode.getNodeName().equals("age")) {
					try {
					String  age = (childNode.getTextContent());
					ages.add(age);
					}
					catch (Exception e) {
						System.out.println("erreur dans le parse ");
					}
					
				}
				else if( childNode.getNodeName().equals("email")) {
					String email = childNode.getTextContent();
					emails.add(email);
				}
				else if( childNode.getNodeName().equals("tel")) {
					String tel = childNode.getTextContent();
					tels.add(tel);
				}

			}
		}

	}


	public XmlParser getParse() {
		return parse;
	}
	public void setParse(XmlParser parse) {
		this.parse = parse;
	}
	public Vector<String> getNoms() {
		return noms;
	}
	public void setNoms(Vector<String> noms) {
		this.noms = noms;
	}
	public Vector<String> getPrenoms() {
		return prenoms;
	}
	public void setPrenoms(Vector<String> prenoms) {
		this.prenoms = prenoms;
	}
	public Vector<String> getAges() {
		return ages;
	}
	public void setAges(Vector<String> ages) {
		this.ages = ages;
	}
	public Vector<String> getEmail() {
		return emails;
	}
	public void setEmail(Vector<String> emails) {
		this.emails = emails;
	}
	public Vector<String> getTels() {
		return tels;
	}
	public void setTels(Vector<String> tels) {
		this.tels = tels;
	}
	public Vector<String> getCodesEtudiants() {
		return codesEtudiants;
	}
	public void setCodesEtudiants(Vector<String> codesEtudiants) {
		this.codesEtudiants = codesEtudiants;
	}



}
