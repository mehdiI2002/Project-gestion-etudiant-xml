package org.mql.java.views;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterfaceUpdateEtudiant extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel container ;
	private JLabel labelTittle;
	private LabledTextField labeledCode;
	
	private JPanel containerButton;
	private Button confirmer;
	private Button annuler;
	private LabledTextField labeledNom;
	private LabledTextField labeledPrenom;
	private LabledTextField labeledAge ;
	private LabledTextField labeledEmail ;
	private LabledTextField  labeledTel;
	private JPanel errorMsgUpdatePanel;
	private JLabel errorMsgUpdateLabel;
	

	public InterfaceUpdateEtudiant() {		
		labelTittle = new JLabel("Modifier un etudiant !!");
		container = new JPanel();
		containerButton = new JPanel();
		labeledCode = new LabledTextField("Code", 20, 70);
		
		labeledNom  = new LabledTextField("nom", 20, 70);
		labeledPrenom= new LabledTextField("prenom", 20, 70);
		labeledAge  = new LabledTextField("age", 20, 70);
		labeledEmail = new LabledTextField("email", 20, 70);
		labeledTel  = new LabledTextField("tel", 20, 70);;
		confirmer = new Button("Confirmer Update");
		container.add(confirmer);
		annuler = new Button("Annuler Update");
		container.add(annuler);
		  errorMsgUpdateLabel = new JLabel("");
		  errorMsgUpdatePanel = new JPanel();
	}
	public void drawInterfaceUpdate () {
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		labelTittle.setFont(new Font("Arial", Font.BOLD, 24));
		labelTittle.setAlignmentX(JLabel.CENTER_ALIGNMENT); 
		container.add(labelTittle);
		container.add( labeledCode);
		
		container.add(labeledNom);
		container.add(labeledPrenom);
		container.add(labeledAge);
		container.add(labeledEmail);
		container.add(labeledTel);
		add(container);
		containerButton.add(confirmer, BorderLayout.SOUTH);
		containerButton.add(annuler, BorderLayout.SOUTH);
		container.add(containerButton);
		errorMsgUpdatePanel.add(errorMsgUpdateLabel);
		container.add(errorMsgUpdatePanel);
		setSize(500,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}

	
	public LabledTextField getLabeledCode() {
		return labeledCode;
	}
	public void setLabeledCode(LabledTextField labeledCode) {
		this.labeledCode = labeledCode;
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
	public JPanel getErrorMsgUpdatePanel() {
		return errorMsgUpdatePanel;
	}
	public void setErrorMsgUpdatePanel(JPanel errorMsgUpdatePanel) {
		this.errorMsgUpdatePanel = errorMsgUpdatePanel;
	}
	public JLabel getErrorMsgUpdateLabel() {
		return errorMsgUpdateLabel;
	}
	public void setErrorMsgUpdateLabel(JLabel errorMsgUpdateLabel) {
		this.errorMsgUpdateLabel = errorMsgUpdateLabel;
	}
	



}


