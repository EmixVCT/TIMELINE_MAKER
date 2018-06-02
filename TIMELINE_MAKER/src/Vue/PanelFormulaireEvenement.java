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
import Modele.Timeline;
import Modele.Date;
import Modele.Evenement;

public class PanelFormulaireEvenement extends JPanel{
	
	private JLabel	titreFenetre;
	private JButton ajoutEvt = new JButton("Ajouter");
	private JTextField textTitre = new JTextField(15);
	
	private JComboBox boxJour;
	private JComboBox boxMois;
	private JComboBox boxAnnee;

	private JComboBox boxpoids;
	
	private JTextField textLienPhoto = new JTextField(15);

	private JTextArea textDescription = new JTextArea(10,20);
	
	public PanelFormulaireEvenement(){
		
		setBackground(new Color(186,166,79));
		titreFenetre = new JLabel("Ajout d'un evenement");
		
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
		this.add(ajoutEvt, contraintes);
		ajoutEvt.setActionCommand("ajout") ;// le bouton se met � l'�coute


		// �tiquette "Titre"
        contraintes.gridy=1;contraintes.gridx=0;
		JLabel labelTitre = new JLabel("Titre");
		labelTitre.setDisplayedMnemonic('T');
		this.add(labelTitre, contraintes);

        // saisie du Titre
		contraintes.gridx = 1 ;
		contraintes.gridwidth = 4;
		this.add(textTitre, contraintes) ;
		
		
		// �tiquette "Date"
		contraintes.gridwidth = 1;
		contraintes.gridx = 0 ;
		contraintes.gridy = 2 ;
		JLabel labelDate = new JLabel("Date");
		labelDate.setDisplayedMnemonic('D');
		this.add(labelDate, contraintes);

        //JComboBox Jours
		contraintes.gridx =1 ;
		String jours[] = {"1","2","3","4","5","6","7","8","9"};
        boxJour = new JComboBox(jours) ;
        boxJour.setSelectedItem(jours[0]);;
		this.add(boxJour, contraintes);
		
        //JComboBox Mois
		contraintes.gridx =2 ;
		String mois[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
        boxMois = new JComboBox(mois) ;
        boxMois.setSelectedItem(mois[0]);;
		this.add(boxMois, contraintes);
		
        //JComboBox Année
		contraintes.gridx =3 ;
		contraintes.gridwidth = 2;
		String annee[] = {"1999","2001","2002","2003","2004","2005","2006","2007","2008"};
        boxAnnee = new JComboBox(annee) ;
        boxAnnee.setSelectedItem(annee[0]);;
		this.add(boxAnnee, contraintes);
		
		
		
		
		// étiquette "Poids"
		contraintes.gridx = 0;
		contraintes.gridwidth = 1;
		contraintes.gridy = 3 ;
		JLabel labelPoid = new JLabel("Poids");
		labelPoid.setDisplayedMnemonic('P');
		this.add(labelPoid, contraintes);

		// JComboBox Poid
		contraintes.gridx =1 ;
		contraintes.gridwidth = 3;
		
		String poids[] = new String[4];
		for(int i = 0 ; i <= 3 ; i++) {
				poids[i] = ""+(i+1) ;
		}
        boxpoids = new JComboBox(poids) ;
        boxpoids.setSelectedItem(0) ;
		this.add(boxpoids, contraintes);// ajout des heures
		
		// �tiquette "ien de la photo"
        contraintes.gridy=4;contraintes.gridx=0;
		JLabel labelPhoto = new JLabel("Photo (lien)");
		labelPhoto.setDisplayedMnemonic('P');
		this.add(labelPhoto, contraintes);

        // saisie du lien de la photo
		contraintes.gridx = 2 ;
		contraintes.gridwidth = 3;
		this.add(textLienPhoto, contraintes) ;
		
		
        // étiquette "Description"
		contraintes.insets = new Insets(10,10,10,10);
		contraintes.fill = GridBagConstraints.BOTH ;
		contraintes.gridx = 0 ;
		contraintes.gridy = 5 ;
		JLabel labelDescription = new JLabel("Description");
		labelDescription.setDisplayedMnemonic('e');
		this.add(labelDescription, contraintes);

        // zone de saisie (Dexcription)
		JScrollPane scroll = new JScrollPane (textDescription);
		contraintes.gridwidth = 3;
		contraintes.gridx = 2 ;
		this.add(scroll, contraintes) ;
	}// PanelFormuaire()

	public void enregistreEcouteur(Controleur parC){
		ajoutEvt.addActionListener(parC);
	}
	
	public Evenement getEvenement(){
		return null;//new Evenement (getDate(),textTitre.getText(),textLieu.getText());
	}
    
    public void reset(){
    	this.textTitre.setText("") ;
        this.textDescription.setText("");
        this.textLienPhoto.setText("");
        this.textTitre.requestFocus() ;
    }
    
	
}

