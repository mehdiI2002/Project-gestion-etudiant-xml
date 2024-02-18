package org.mql.java.views;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FormInsert  extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel container;
	private  JLabel labelTittle;
	private Button confirmer;
	private LabledTextField labeledNom;
	private LabledTextField labeledPrenom;
	private LabledTextField labeledAge ;
	private LabledTextField labeledEmail ;
	private LabledTextField  labeledTel;
	private LabledTextField labeledCode;
	private Button annuler ;
	private JPanel containerButton;
	private JPanel errorMsgPanel;
	private JLabel errorMsgLabel;
	



	public FormInsert() {
		container = new JPanel();
		containerButton = new JPanel();
		labelTittle = new JLabel("Inserer un etudiant !!");
		labeledNom  = new LabledTextField("nom", 20, 70);
		labeledPrenom= new LabledTextField("prenom", 20, 70);
		labeledAge  = new LabledTextField("age", 20, 70);
		labeledEmail = new LabledTextField("email", 20, 70);
		labeledTel  = new LabledTextField("tel", 20, 70);
		labeledCode  =    new LabledTextField("code", 20, 70);
		confirmer = new Button("Confirmer Insert");
		container.add(confirmer);
		annuler = new Button("Annuler Insert");
		container.add(annuler);
		  errorMsgLabel = new JLabel("");
		  errorMsgPanel = new JPanel();
		   

	}
	public   void drawForm() {	
		
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		labelTittle.setFont(new Font("Arial", Font.BOLD, 24));
		labelTittle.setAlignmentX(JLabel.CENTER_ALIGNMENT); 
		container.add(labelTittle);
	
		container.add(labeledCode);
		
		container.add(labeledNom);
		container.add(labeledPrenom);
		container.add(labeledAge);
		container.add(labeledEmail);
		container.add(labeledTel);
		
		
		containerButton.add(confirmer, BorderLayout.SOUTH);
		containerButton.add(annuler, BorderLayout.SOUTH);
		container.add(containerButton);
		errorMsgPanel.add(errorMsgLabel);
		container.add(errorMsgPanel);
		 
		
		setSize(500,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); 
		setVisible(true);
		getContentPane().add(container);
		setResizable(true);
		//pack();
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
	public JLabel getErrorMsgLabel() {
		return errorMsgLabel;
	}
	public void setErrorMsgLabel(JLabel errorMsgLabel) {
		this.errorMsgLabel = errorMsgLabel;
	}
	



}
