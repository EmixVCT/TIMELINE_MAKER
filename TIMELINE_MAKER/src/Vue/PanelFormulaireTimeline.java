package Vue;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controleur.Controleur;
import Modele.Date;
import Modele.ExceptionCreationTimeline;
import Modele.ExceptionDate;
import Modele.Timeline;

public class PanelFormulaireTimeline extends JPanel{
	private JLabel	titreFenetre;
	private JButton creeTimeline = new JButton("Crée");
	private JTextField textTitre = new JTextField(15);
	
	private JComboBox boxJourDebut;
	private JComboBox boxMoisDebut;
	private JComboBox boxAnneeDebut;
	
	private JComboBox boxJourFin;
	private JComboBox boxMoisFin;
	private JComboBox boxAnneeFin;

	private JTextField textPeriode = new JTextField(15);
		
	private JTextField textLienDossier = new JTextField(15);

	
	public PanelFormulaireTimeline(){
		
		setBackground(new Color(128, 208, 208));
		titreFenetre = new JLabel("Création d'une Timeline");
		
		GridBagLayout gestionnaire = new GridBagLayout();
		this.setLayout(gestionnaire);
		GridBagConstraints contraintes = new GridBagConstraints();
		contraintes.insets = new Insets(10, 10, 10, 10) ;
		
		contraintes.fill = GridBagConstraints.HORIZONTAL;
		contraintes.anchor = GridBagConstraints.WEST;
		
		contraintes.gridx=0;contraintes.gridx=0;
		contraintes.gridwidth = 4;
		this.add(titreFenetre, contraintes) ;

		contraintes.gridwidth = 1;
		contraintes.gridx = 4 ;// on place le boutton plus loin � droite
		this.add(creeTimeline, contraintes);
		creeTimeline.setActionCommand("cree") ;// le bouton se met � l'�coute


		// �tiquette "Titre"
        contraintes.gridy=1;contraintes.gridx=0;
		JLabel labelTitre = new JLabel("Titre");
		labelTitre.setDisplayedMnemonic('T');
		this.add(labelTitre, contraintes);

        // saisie du Titre
		contraintes.gridx = 1 ;
		contraintes.gridwidth = 4;
		this.add(textTitre, contraintes) ;
		
		
		// �tiquette "Date debut"
		contraintes.gridwidth = 1;
		contraintes.gridx = 0 ;
		contraintes.gridy = 2 ;
		JLabel labelDateDebut = new JLabel("Date debut");
		labelDateDebut.setDisplayedMnemonic('D');
		this.add(labelDateDebut, contraintes);

        //JComboBox Jours debut
		contraintes.gridx =1 ;
		String jours[] = getListJour();
        boxJourDebut = new JComboBox(jours) ;
        boxJourDebut.setSelectedItem(Integer.toString(new Date().getJour()));
		this.add(boxJourDebut, contraintes);
		
        //JComboBox Mois debut
		contraintes.gridx =2 ;
		String mois[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
        boxMoisDebut = new JComboBox(mois) ;
        boxMoisDebut.setSelectedItem(Integer.toString(new Date().getMois()));
		this.add(boxMoisDebut, contraintes);
		
        //JComboBox Année debut
		contraintes.gridx =3 ;
		contraintes.gridwidth = 2;
		ArrayList<String> annee = getArrayListAnnee();
        boxAnneeDebut = new JComboBox(annee.toArray()) ;
        boxAnneeDebut.setSelectedItem(Integer.toString(new Date().getAnnee()));
		this.add(boxAnneeDebut, contraintes);
		
		// �tiquette "Date FIN"
		contraintes.gridwidth = 1;
		contraintes.gridx = 0 ;
		contraintes.gridy = 3 ;
		JLabel labelDateFin = new JLabel("Date debut");
		labelDateFin.setDisplayedMnemonic('D');
		this.add(labelDateFin, contraintes);

        //JComboBox Jours FIN
		contraintes.gridx =1 ;
        boxJourFin = new JComboBox(jours) ;
        boxJourFin.setSelectedItem(Integer.toString(new Date().getJour()));
		this.add(boxJourFin, contraintes);
		
        //JComboBox Mois FIN
		contraintes.gridx =2 ;
        boxMoisFin = new JComboBox(mois) ;
        boxMoisFin.setSelectedItem(Integer.toString(new Date().getMois()));
		this.add(boxMoisFin, contraintes);
		
        //JComboBox Année FIN
		contraintes.gridx =3 ;
		contraintes.gridwidth = 2;
		boxAnneeFin = new JComboBox(annee.toArray()) ;
		boxAnneeFin.setSelectedItem(Integer.toString(new Date().getAnnee()));
		this.add(boxAnneeFin, contraintes);
		
		//étiquette periode
        contraintes.gridy=4;
        contraintes.gridx=0;
		JLabel labelPeriode = new JLabel("Période");
		labelPeriode.setDisplayedMnemonic('P');
		this.add(labelPeriode, contraintes);
		
		contraintes.gridx =1 ;
		contraintes.gridwidth = 4;
		this.add(textPeriode,contraintes);
		
		// �tiquette "lien du dossier de sauvegarde"
        contraintes.gridy=5;
        contraintes.gridx=0;
		JLabel labelDossier = new JLabel("Dossier de sauvgarde (lien)");
		labelDossier.setDisplayedMnemonic('D');
		this.add(labelDossier, contraintes);

        // saisie du lien de la photo
		contraintes.gridy = 6;
		contraintes.gridx = 1 ;
		contraintes.gridwidth = 4;
		textLienDossier.setEditable(false);
		textLienDossier.setText("/Timeline/");
		this.add(textLienDossier, contraintes) ;
		
		
	}


	public void enregistreEcouteur(Controleur parC){
		creeTimeline.addActionListener(parC);
	}
	
	
    
    public void reset(){
    	this.textTitre.setText("") ;
        this.textTitre.requestFocus() ;
    }
    
    public Date getDateDebut() {
    	String jour = boxJourDebut.getSelectedItem().toString();
    	String mois = boxMoisDebut.getSelectedItem().toString();
    	String annee = boxAnneeDebut.getSelectedItem().toString();
    	try {
			Date d1 = new Date(Integer.parseInt(jour),Integer.parseInt(mois),Integer.parseInt(annee));
	    	return d1;
		} catch (ExceptionDate e) {
			e.printStackTrace();
		}
		return null;
    }
    public Date getDateFin() {
    	String jour = boxJourFin.getSelectedItem().toString();
    	String mois = boxMoisFin.getSelectedItem().toString();
    	String annee = boxAnneeFin.getSelectedItem().toString();
    	try {
			Date d1 = new Date(Integer.parseInt(jour),Integer.parseInt(mois),Integer.parseInt(annee));
	    	return d1;
		} catch (ExceptionDate e) {
			e.printStackTrace();
		}
		return null;
    }
    
    public int getPeriode(){
    	try {
    		int n = Integer.parseInt(textPeriode.getText());
        	return n;
    	}catch (Exception e) {
			return 1;
		}
    }

	public void setTimeline(Timeline parTimeline) throws ExceptionCreationTimeline{
		Date debut = getDateDebut();
		Date fin = getDateFin();
		if (debut.compareTo(fin) >= 0 ){
			throw new ExceptionCreationTimeline("La date de debut doit etre strictement inferieur\na la date de fin");
		}
		String titre = textTitre.getText();
		int periode = getPeriode();
		String lien = textLienDossier.getText();
		parTimeline.setTimeline(titre,debut,fin,periode,lien);
		
	}
	
	public String[] getListJour() {
		String[] listJour = new String[31];
		for(int i = 1;i<=31;i++) {
			listJour[i-1] = Integer.toString(i);
		}
		return listJour;
	}
	
	private ArrayList<String> getArrayListAnnee() {
		ArrayList<String> listAnnee = new ArrayList<String>();
		for(int i = 0; i<=new Date().getAnnee();i++) {
			listAnnee.add(Integer.toString(i));
		}
		return listAnnee;
	}
    
	
}
