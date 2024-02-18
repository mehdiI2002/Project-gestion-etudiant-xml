package org.mql.java.views;

public class LabeledTextFields {
	private LabledTextField labeledNom;
	private  LabledTextField labeledPrenom;
	private LabledTextField labeledAge  ;
	private LabledTextField labeledEmail;
	private LabledTextField  labeledTel;
	private LabledTextField labeledCode;
	public LabeledTextFields() {
		labeledNom  = new LabledTextField("nom", 20, 70);
		labeledPrenom= new LabledTextField("prenom", 20, 70);
		labeledAge  = new LabledTextField("age", 20, 70);
		labeledEmail = new LabledTextField("email", 20, 70);
		labeledTel  = new LabledTextField("tel", 20, 70);
		labeledCode  =    new LabledTextField("code", 20, 70);
	}
	public LabledTextField getLabeledNom() {
		return labeledNom;
	}
	public void setLabeledNom(LabledTextField labeledNom) {
		this.labeledNom = labeledNom;
	}
	public LabledTextField getLabeledPrenom() {
		return labeledPrenom;
	}
	public void setLabeledPrenom(LabledTextField labeledPrenom) {
		this.labeledPrenom = labeledPrenom;
	}
	public LabledTextField getLabeledAge() {
		return labeledAge;
	}
	public void setLabeledAge(LabledTextField labeledAge) {
		this.labeledAge = labeledAge;
	}
	public LabledTextField getLabeledEmail() {
		return labeledEmail;
	}
	public void setLabeledEmail(LabledTextField labeledEmail) {
		this.labeledEmail = labeledEmail;
	}
	public LabledTextField getLabeledTel() {
		return labeledTel;
	}
	public void setLabeledTel(LabledTextField labeledTel) {
		this.labeledTel = labeledTel;
	}
	public LabledTextField getLabeledCode() {
		return labeledCode;
	}
	public void setLabeledCode(LabledTextField labeledCode) {
		this.labeledCode = labeledCode;
	}

	
}
