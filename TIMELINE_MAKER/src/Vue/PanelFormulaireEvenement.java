package Vue;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controleur.Controleur;
import Modele.Timeline;
import Modele.Date;
import Modele.Evenement;

public class PanelFormulaireEvenement extends JPanel{
	public final String NOM_BOUTON="+";
	JButton boutonAjout = new JButton(NOM_BOUTON);	
	Date dateFormulaire = new Date();
	JTextField fieldTitre = new JTextField(10);
	JTextField fieldLieu= new JTextField(10);
	JLabel labelDate = new JLabel(dateFormulaire.toString());
	JTextArea area = new JTextArea("",5,10);
	
	public PanelFormulaireEvenement(){
		setLayout (new GridBagLayout());
		JLabel labelTitre = new JLabel("Titre");
		JLabel labelLieu = new JLabel("Lieu");
		JLabel labelDebut = new JLabel("D�but");
		JLabel labelFin = new JLabel("Fin");
		JLabel labelDescription = new JLabel("Description");
		
		GridBagConstraints contrainte = new GridBagConstraints();
		contrainte.insets=new Insets(5,5,5,5);

		//premiere ligne
		contrainte.gridx=4 ; contrainte.gridy=1 ;
		contrainte.gridwidth=4;
		add(fieldTitre, contrainte);
		
		contrainte.gridx=4 ; contrainte.gridy=2 ;
		contrainte.gridwidth=4;
		add(fieldLieu, contrainte);
		
		contrainte.gridx=4 ; contrainte.gridy=0 ;
		contrainte.gridwidth=4;
		add(boutonAjout, contrainte);
		
		//deusiemme ligne (marche un peut)
		contrainte.gridx=2 ; contrainte.gridy=2 ;
		contrainte.gridwidth=2;
		this.add(labelDate, contrainte);
		
		//premier colone
		contrainte.gridx=0 ; contrainte.gridy=0 ;
		contrainte.gridwidth=1;
		this.add(labelDate, contrainte);
		
		contrainte.gridx=0 ; contrainte.gridy=1 ;
		contrainte.gridwidth=1;
		this.add(labelTitre, contrainte);
		
		contrainte.gridx=0 ; contrainte.gridy=2 ;
		contrainte.gridwidth=1;
		this.add(labelLieu, contrainte);
		
		contrainte.gridx=0 ; contrainte.gridy=3 ;
		contrainte.gridwidth=1;
		this.add(labelDebut, contrainte);
		
		contrainte.gridx=0 ; contrainte.gridy=4 ;
		contrainte.gridwidth=1;
		this.add(labelFin, contrainte);
		
		contrainte.gridx=0 ; contrainte.gridy=5 ;
		contrainte.gridwidth=1;
		this.add(labelDescription, contrainte);
		
		contrainte.gridx=1 ; contrainte.gridy=5 ;
		contrainte.gridwidth=0;
		contrainte.gridheight=5;
		this.add(area, contrainte);
		
	}
	/*
	public Evenement getEvenement(){
		return new Evenement(getDate(),fieldTitre.getText(),fieldLieu.getText());
	}*/
	
	public Date getDate(){
		return	dateFormulaire;
	}
	
	public void setDate(Date parDate){
		dateFormulaire = parDate;
		labelDate.setText(dateFormulaire.toString());
	}
	/*
	public void enregistreEcouteur(Controleur parC){
		boutonAjout.addActionListener(parC);
	}*/

	public void reset() {
		fieldTitre.setText(new String());
		fieldLieu.setText(new String());
		area.setText(new String());
		
		GregorianCalendar calendar = new GregorianCalendar();
		fieldTitre.requestFocus();
	}
	
}

