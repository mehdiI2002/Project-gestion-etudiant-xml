package org.mql.java.views;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterfaceDeleteEtudiant extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel container ;
	private JLabel labelTittle;
	LabledTextField labeledCode;
	private JPanel containerButton;
	private Button confirmer;
	private Button annuler;
	private JPanel errorMsgDeletePanel;
	private JLabel errorMsgDeleteLabel;

	public InterfaceDeleteEtudiant() {
		labelTittle = new JLabel("Supprimer  un etudiant !!");
		container = new JPanel();
		labeledCode = new LabledTextField("Code", 20, 70);
		containerButton = new JPanel();
		confirmer = new Button("Confirmer Delete");
		container.add(confirmer);
		annuler = new Button("Annuler Delete");
		container.add(annuler);
		 errorMsgDeleteLabel = new JLabel("");
		  errorMsgDeletePanel = new JPanel();
	}
	public void drawInterfaceDelete () {
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		labelTittle.setFont(new Font("Arial", Font.BOLD, 24));
		labelTittle.setAlignmentX(JLabel.CENTER_ALIGNMENT); 
		container.add(labelTittle);
		container.add( labeledCode);
		
		add(container);
		containerButton.add(confirmer, BorderLayout.SOUTH);
		containerButton.add(annuler, BorderLayout.SOUTH);
		container.add(containerButton);
		errorMsgDeletePanel.add(errorMsgDeleteLabel);
		container.add(errorMsgDeletePanel);
		setSize(500,200);
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
	public JLabel getErrorMsgDeleteLabel() {
		return errorMsgDeleteLabel;
	}
	public void setErrorMsgDeleteLabel(JLabel errorMsgDeleteLabel) {
		this.errorMsgDeleteLabel = errorMsgDeleteLabel;
	}
	
	

}
