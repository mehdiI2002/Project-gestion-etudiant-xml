package org.mql.java.views;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.mql.java.xml.dom.ParseEtudiants;
import org.mql.java.xml.dom.XmlParser;

public class SecondInterface extends JFrame  {
	private static final long serialVersionUID = 1L;
	private JPanel container;
	private JPanel containerButton;
	private DefaultTableModel tableModel;
	private JTable table;
	private Container containerTable;

	public SecondInterface() {
		container = new JPanel();
		containerButton = new JPanel();
		containerTable = new JPanel();
		
	}
	public void drawSecondInterface() {
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.setBackground(Color.RED);
		JLabel label = new JLabel("Gestion des étudiants");
		label.setFont(new Font("Arial", Font.BOLD, 24));
		label.setAlignmentX(JLabel.CENTER_ALIGNMENT); 
		container.add(label);
		loadTable();
		createButtons();
		this.setContentPane(container);
		
	}
	public void createButtons() {
		FormInsert formInsert = new FormInsert();
		Button buttonInsert = new Button("Inserer",formInsert);
		containerButton.add(buttonInsert);
		InterfaceUpdateEtudiant update = new InterfaceUpdateEtudiant();
		Button buttonModify = new Button("Modifier",update);
		containerButton.add(buttonModify);
		InterfaceDeleteEtudiant deleteInterface = new InterfaceDeleteEtudiant();
		Button buttonDelete = new Button("Delete",deleteInterface);
		containerButton.add(buttonDelete);
		Button buttonRefresh = new Button("Refresh",this);
		containerButton.add(buttonRefresh);
		 container.add(containerButton);
}
	public void loadTable() {
		
		XmlParser parse = new XmlParser("C:\\projects java\\xml_project_el mehdi_amarti_riffi\\resources\\etudiants.xml");
		ParseEtudiants parseEtudiant = new ParseEtudiants(parse);
		parseEtudiant.parseEtudiants();
		Vector<String> codes = parseEtudiant.getCodesEtudiants();
		Vector<String> noms = parseEtudiant.getNoms();
		Vector<String>  prenoms = parseEtudiant.getPrenoms();
		Vector<Integer> ages = parseEtudiant.getAges();
		Vector<String > emails = parseEtudiant.getEmail();
		Vector<String> tels = parseEtudiant.getTels();
	


		Object[][] data = new Object[noms.size()][6];
		for (int i = 0; i < noms.size(); i++) {
			data[i][0] = codes.get(i);
			data[i][1] = noms.get(i);
			data[i][2] = prenoms.get(i);
			data[i][3] = ages.get(i);
			data[i][4] = emails.get(i);
			data[i][5] = tels.get(i);
			
		}
		String[] columnNames = {"Code","Nom", "prenom", "Age","Email","Tel"};
		tableModel = new DefaultTableModel(data, columnNames);
		table = new JTable(tableModel);
		table.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane(table);
		containerTable.add(scrollPane);
		containerTable.setPreferredSize(new Dimension(1000, 800));
		container.add(containerTable);
		revalidate();
	    repaint();
	}
	public void removeOldTable() {
	    containerTable.removeAll(); 
	    containerButton.removeAll();
	    container.removeAll();
	}
	
	
	
	 
}

	



