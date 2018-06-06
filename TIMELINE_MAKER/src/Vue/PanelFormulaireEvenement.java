package Vue;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controleur.Controleur;
import Modele.Date;
import Modele.Evenement;
import Modele.ExceptionAjoutEvenement;
import Modele.ExceptionDate;

/**
 * PanelFormulaireEvenement est la classe permet de crée un JPanel 
 * gérer par un GridBagLayout
 * @author Maxime VINCENT et Hugo HAMEL
 */
public class PanelFormulaireEvenement extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel	titreFenetre;
	private JButton ajoutEvt = new JButton("Ajouter");
	private JButton parcourir = new JButton("Parcourir");
	private JTextField textTitre = new JTextField(15);
	
	private JComboBox<?> boxJour;
	private JComboBox<?> boxMois;
	private JComboBox<?> boxAnnee;

	private JComboBox<?> boxpoids;
	
	private JTextField textLienPhoto = new JTextField(15);

	private JTextArea textDescription = new JTextArea(10,20);
	
	/**
	 * Contructeur de la classe PanelFormulaireEvenement 
	 * ajoute des elements au panel pour crée un formulaire
	 */
	public PanelFormulaireEvenement(){
		
		setBackground(new Color(128, 208, 208));
		titreFenetre = new JLabel("Ajout d'un evenement");
		
		GridBagLayout gestionnaire = new GridBagLayout();
		this.setLayout(gestionnaire);
		GridBagConstraints contraintes = new GridBagConstraints();
		contraintes.insets = new Insets(10, 10, 10, 10) ;
		
		contraintes.fill = GridBagConstraints.HORIZONTAL;
		contraintes.anchor = GridBagConstraints.WEST;
		
		contraintes.gridx=0;contraintes.gridy=0;
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
		String jours[] = getListJour();
        boxJour = new JComboBox<Object>(jours) ;
        boxJour.setSelectedItem(Integer.toString(new Date().getJour()));
		this.add(boxJour, contraintes);
		
        //JComboBox Mois
		contraintes.gridx =2 ;
		String mois[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
        boxMois = new JComboBox<Object>(mois) ;
        boxMois.setSelectedItem(Integer.toString(new Date().getMois()));
		this.add(boxMois, contraintes);
		
        //JComboBox Année
		contraintes.gridx =3 ;
		contraintes.gridwidth = 2;
		ArrayList<String> annee = getArrayListAnnee();
        boxAnnee = new JComboBox<Object>(annee.toArray()) ;
        boxAnnee.setSelectedItem(Integer.toString(new Date().getAnnee()));
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
        boxpoids = new JComboBox<Object>(poids) ;
        boxpoids.setSelectedItem(0) ;
		this.add(boxpoids, contraintes);// ajout des heures
		
		
		
		// �tiquette "ien de la photo"
        contraintes.gridy=4;contraintes.gridx=0;
		JLabel labelPhoto = new JLabel("Photo (lien)");
		labelPhoto.setDisplayedMnemonic('h');
		this.add(labelPhoto, contraintes);
		
		//Boutton parcourir photo
		contraintes.gridx = 2 ;
		contraintes.gridwidth = 2;
		this.add(textLienPhoto,contraintes);
		textLienPhoto.setEditable(false);
		contraintes.gridx = 4 ;
		contraintes.gridwidth = 1;
		this.add(parcourir,contraintes);
		parcourir.setActionCommand("parcourir");
		
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
	/**
	 * Méthode permetant de mettre a l'écoute les boutons du Jpanel dans le controleur
	 * @param parC controleur a mettre a l'écoute
	 */
	public void enregistreEcouteur(Controleur parC){
		ajoutEvt.addActionListener(parC);
		parcourir.addActionListener(parC);
	}
	
	/**
	 * récupère les donnée entrez dans les conteneur et créé
	 * un nouvelle objet de la classe evenement avec.
	 * @return l'evenement créé
	 * @throws ExceptionAjoutEvenement
	 */
	public Evenement getEvenement() throws ExceptionAjoutEvenement{
		if (textTitre.getText().compareTo("")==0) {
			throw new ExceptionAjoutEvenement("Vous devez obligatoirement donnée un titre a l'evenement");
		}else {
			int poids = Integer.parseInt(boxpoids.getSelectedItem().toString());
			return new Evenement(textTitre.getText(),getDate(),textDescription.getText(),poids,textLienPhoto.getText());
		}
	}
    /**
     * réinitialise les cellules du formulaire
     */
    public void reset(){
    	this.textTitre.setText("") ;
        this.textDescription.setText("");
        this.textLienPhoto.setText("");
        this.textTitre.requestFocus() ;
    }
    
    /**
     * récupère la date entrez dans les JComboBox
     * @return une date
     * @see Date
     */
    public Date getDate() {
    	String jour = boxJour.getSelectedItem().toString();
    	String mois = boxMois.getSelectedItem().toString();
    	String annee = boxAnnee.getSelectedItem().toString();
    	try {
			Date d1 = new Date(Integer.parseInt(jour),Integer.parseInt(mois),Integer.parseInt(annee));
	    	return d1;
		} catch (ExceptionDate e) {
			e.printStackTrace();
		}
		return null;
    } 
    /**
     * renvoie dans une list de String les jours de 1 a 31
     * @return liste de String
     */
	public String[] getListJour() {
		String[] listJour = new String[31];
		for(int i = 1;i<=31;i++) {
			listJour[i-1] = Integer.toString(i);
		}
		return listJour;
	}
    /**
     * renvoie dans une ArrayList de String les années de 0 a aujourd'hui
     * @return ArrayListe de String
     */
	public ArrayList<String> getArrayListAnnee() {
		ArrayList<String> listAnnee = new ArrayList<String>();
		for(int i = 0; i<=new Date().getAnnee();i++) {
			listAnnee.add(Integer.toString(i));
		}
		return listAnnee;
	}
	/**
	 * Defini le lien de la photo dans la zone de texte
	 * @param lien le lien de la photo en String
	 */
	public void setTextLienPhoto(String lien) {
		textLienPhoto.setText(lien);
	}
	
}

