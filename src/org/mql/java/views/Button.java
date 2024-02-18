package org.mql.java.views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.mql.java.models.WriteEtudiant;
import org.mql.java.models.XmlDocumentBuilder;
import org.mql.java.models.XmlFileModifier;
import org.mql.java.xml.dom.DeleteEtudiantWithId;
import org.mql.java.xml.dom.ParseEtudiants;
import org.mql.java.xml.dom.UpdateEtudiantWithId;
import org.mql.java.xml.dom.XmlParser;


public class Button extends JButton implements ActionListener {
	private static final long serialVersionUID = 1L;
	private String label;
	private JTextField codeValue;
	private JTextField nomValue;
	private JTextField prenomValue;
	private JTextField ageValue;
	private JTextField emailValue;
	private JTextField telValue;
	private static FormInsert sharedFormInsert;
	private JTextField deleteTextField;
	private JTextField textFieldCodeOld;
	private JTextField  textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldAge ;
	private JTextField textFieldEmail ;
	private JTextField  textFieldTel;
	private static  InterfaceDeleteEtudiant formDelete;
	private static InterfaceUpdateEtudiant formUpdate;
	private  SecondInterface secondFrame;

	public Button(String label) {
		super(label);
		this.label = label;
		addActionListener(this);
	}
	public Button(String label, FormInsert formInsert) {
		super(label);
		this.label = label;
		if ("Inserer".equals(label)) {
			if (sharedFormInsert == null) {
				sharedFormInsert = formInsert;

			}
		}
		addActionListener(this);

	}
	public Button(String label, InterfaceUpdateEtudiant updateInterface) {
		super(label);
		this.label = label;

		if (("Modifier".equals(label))) {
			if (formUpdate == null) {
				Button.formUpdate=updateInterface;
			}
		}

		addActionListener(this);
	}
	public Button(String label, InterfaceDeleteEtudiant deleteInterface) {
		super(label);
		this.label = label;

		if ("Delete".equals(label)) {
			Button.formDelete =deleteInterface;
		}

		addActionListener(this);
	}

	public Button(String label,JTextField deleteTextField) {
		super(label);
		this.label = label;
		this.deleteTextField = deleteTextField;
	}
	public Button(String label,SecondInterface secondFrame) {
		super(label);
		this.label = label;
		if (("Refresh".equals(label))) {
			this.setSecondFrame(secondFrame);
		}
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if ("Demarrer".equals(label)) {
			SecondInterface second = new SecondInterface();
			second.drawSecondInterface();
			
			second.setLocation(350, 150);
			second.setPreferredSize(new Dimension(800, 700));
			second.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			second.pack();
			second.setVisible(true); 
		}
		else if("Inserer".equals(label)) {
			if (sharedFormInsert != null) {
				sharedFormInsert.drawForm();
			}
		}
		else if ("Confirmer Insert".equals(label)) {
			if (sharedFormInsert != null) {
				String filePath ="C:\\\\projects java\\\\xml_project_el mehdi_amarti_riffi\\\\resources\\\\etudiants.xml";
				this.codeValue = sharedFormInsert.getLabeledCode().getT1();
				this.nomValue = sharedFormInsert.getLabeledNom().getT1();
				this.prenomValue = sharedFormInsert.getLabeledPrenom().getT1();
				this.ageValue = sharedFormInsert.getLabeledAge().getT1();
				this.emailValue = sharedFormInsert.getLabeledEmail().getT1();
				this.telValue = sharedFormInsert.getLabeledTel().getT1();
				  if (codeValue.getText().isEmpty() || nomValue.getText().isEmpty() || prenomValue.getText().isEmpty() ||
				            ageValue.getText().isEmpty() || emailValue.getText().isEmpty() || telValue.getText().isEmpty()) {
				            
					
					  sharedFormInsert.getErrorMsgLabel().setText("Erreur : champ est vide");
				         
				  }
				  else {
				XmlDocumentBuilder build = new XmlDocumentBuilder();
				WriteEtudiant write = new WriteEtudiant(build);
				
				write.writeEtudiant(codeValue.getText(),nomValue.getText(),prenomValue.getText(),  ageValue.getText(), emailValue.getText(), telValue.getText());
				XmlFileModifier modifier = new XmlFileModifier(build);
				modifier.modifierXmlFile(filePath);
				sharedFormInsert.setVisible(false);
				XmlParser parse = new XmlParser(filePath);
				ParseEtudiants etudiants = new ParseEtudiants(parse);
				etudiants.parseEtudiants();
				  }


			}
		}
		else if ("Annuler Insert".equals(label)) {
			sharedFormInsert.setVisible(false);
		}
		else if("Delete".equals(label)) {
			if (formDelete != null) {
				formDelete. drawInterfaceDelete();
			}
		}

		else  if ("Confirmer Delete".equals(label)){
			if(formDelete!= null) {

				this.deleteTextField = formDelete.getLabeledCode().getT1();
				if(deleteTextField.getText().isEmpty()) {
					formDelete.getErrorMsgDeleteLabel().setText("Erreur : champ est vide");
				}
				else {
				String pathProject = "C:\\projects java\\xml_project_el mehdi_amarti_riffi\\resources\\etudiants.xml";
				XmlParser parse = new XmlParser(pathProject);
				DeleteEtudiantWithId parseId = new DeleteEtudiantWithId(parse);
				parseId.deleteEtudiantWithId(deleteTextField.getText(), pathProject);
				parse.writeToFile(pathProject);
				formDelete.setVisible(false);
				}
			}
		}
		else if("Annuler Delete".equals(label)) {
			formDelete.setVisible(false);
		}
		else if("Modifier".equals(label)) {
			if (formUpdate != null) {
				formUpdate.drawInterfaceUpdate();
			}
		}
		else if ("Confirmer Update".equals(label)) {
			if (sharedFormInsert != null) {
				this.textFieldCodeOld = formUpdate.getLabeledCode().getT1()	;
				this.textFieldNom = formUpdate.getLabeledNom().getT1();
				this.textFieldPrenom = formUpdate.getLabeledPrenom().getT1();
				this.textFieldAge = formUpdate.getLabeledAge().getT1();
				this.textFieldEmail = formUpdate.getLabeledEmail().getT1();
				this.textFieldTel = formUpdate.getLabeledTel().getT1();
				if(textFieldCodeOld.getText().isEmpty()||textFieldNom.getText().isEmpty()||textFieldPrenom.getText().isEmpty()||textFieldAge.getText().isEmpty()||textFieldEmail.getText().isEmpty()||textFieldTel.getText().isEmpty()) {
					formUpdate.getErrorMsgUpdateLabel().setText("Erreur : champ est vide");
				}
				else {
				String pathProject = "C:\\projects java\\xml_project_el mehdi_amarti_riffi\\resources\\etudiants.xml";
				XmlParser parse = new XmlParser(pathProject);
				UpdateEtudiantWithId update = new UpdateEtudiantWithId(parse);
				try {
					update.updateEtudiantWithId(textFieldCodeOld.getText(),textFieldNom.getText(),textFieldPrenom.getText(),textFieldAge.getText(),textFieldEmail.getText(),textFieldTel.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				parse.writeToFile(pathProject);
				formUpdate.setVisible(false);

			}
			}
		}
		else if("Annuler Update".equals(label)) {
			formUpdate.setVisible(false);
		}
		else if("Refresh".equals(label)) {
			if (secondFrame != null) {
				secondFrame.removeOldTable();
				secondFrame.drawSecondInterface();
				secondFrame.createButtons();
				
				
			}
		}

	}
	public SecondInterface getSecondFrame() {
		return secondFrame;
	}
	public void setSecondFrame(SecondInterface secondFrame) {
		this.secondFrame = secondFrame;
	}


}














