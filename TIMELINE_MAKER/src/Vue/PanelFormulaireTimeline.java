package Vue;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controleur.Controleur;
import Modele.Evenement;
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
		
		setBackground(new Color(186,166,79));
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
		String jours[] = {"1","2","3","4","5","6","7","8","9"};
        boxJourDebut = new JComboBox(jours) ;
        boxJourDebut.setSelectedItem(jours[0]);;
		this.add(boxJourDebut, contraintes);
		
        //JComboBox Mois debut
		contraintes.gridx =2 ;
		String mois[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
        boxMoisDebut = new JComboBox(mois) ;
        boxMoisDebut.setSelectedItem(mois[0]);;
		this.add(boxMoisDebut, contraintes);
		
        //JComboBox Année debut
		contraintes.gridx =3 ;
		contraintes.gridwidth = 2;
		String annee[] = {"1999","2001","2002","2003","2004","2005","2006","2007","2008"};
        boxAnneeDebut = new JComboBox(annee) ;
        boxAnneeDebut.setSelectedItem(annee[0]);;
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
        boxJourDebut = new JComboBox(jours) ;
        boxJourDebut.setSelectedItem(jours[0]);;
		this.add(boxJourDebut, contraintes);
		
        //JComboBox Mois FIN
		contraintes.gridx =2 ;
        boxMoisDebut = new JComboBox(mois) ;
        boxMoisDebut.setSelectedItem(mois[0]);;
		this.add(boxMoisDebut, contraintes);
		
        //JComboBox Année FIN
		contraintes.gridx =3 ;
		contraintes.gridwidth = 2;
        boxAnneeDebut = new JComboBox(annee) ;
        boxAnneeDebut.setSelectedItem(annee[0]);;
		this.add(boxAnneeDebut, contraintes);
		
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
		this.add(textLienDossier, contraintes) ;
		
		
	}

	public void enregistreEcouteur(Controleur parC){
		creeTimeline.addActionListener(parC);
	}
	
	
	public Timeline getTimeline(){
		return null;//new Timeline ();
	}
    
    public void reset(){
    	this.textTitre.setText("") ;
        this.textTitre.requestFocus() ;
    }
    
	
}
