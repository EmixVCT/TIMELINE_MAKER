package Vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controleur.Controleur;
import Modele.Date;
import Modele.Evenement;
import Modele.Timeline;
/**
 * PanelTimeline est la classe permet de crée un JPanel contenant plusieur panel
 * gérer par un BorderLayout
 * Cette classe est caractérisée par les informations suivante :
 * <ul>
 * <li>une timeline</li>
 * <li>un panelEvts</li>
 * <li>un panelTable</li>
 * <li>un boutonDroite</li>
 * <li>un boutonGauche</li>
 * <li>Une Date</li>
 * </ul>
 * @author Maxime VINCENT et Hugo HAMEL
 * @see Date
 * @see Timeline
 * @see PanelTable
 * @see PanelEvenement
 */
public class PanelTimeline extends JPanel{

	private static final long serialVersionUID = 1L;
	private Timeline timeline;
	private PanelTable panelTable;
	
	private JButton boutonDroite = new JButton(">");
	private JButton boutonGauche = new JButton("<");
	
	private CardLayout gestionnaireEvts;
	private JPanel panelEvts = new JPanel();
	
	private Date dateCourante;
	private int nbPanelEvenements = 0;
	/**
	 * Constructeur de la classe PanelTimeLine
	 * @param parTimeline un timeline
	 */
	public PanelTimeline(Timeline parTimeline) {
		setLayout(new BorderLayout());
		setBackground(new Color(128, 208, 208));
		
		gestionnaireEvts = new CardLayout(5,5);
		panelEvts.setLayout(gestionnaireEvts);
		panelEvts.setBackground(new Color(128, 208, 208));

		this.add(panelEvts,BorderLayout.CENTER);
		
		timeline = parTimeline;
		panelTable = new PanelTable(timeline, gestionnaireEvts,panelEvts,this);
		
		boutonDroite.setActionCommand("droite");
		boutonDroite.setBackground(new Color(128, 208, 208));
		boutonGauche.setActionCommand("gauche");
		boutonGauche.setBackground(new Color(128, 208, 208));

		
		this.add(panelTable,BorderLayout.SOUTH);
		this.add(boutonDroite,BorderLayout.EAST);
		this.add(boutonGauche,BorderLayout.WEST);
		
		panelEvts.add(new JLabel("<html><h1>Entrez des Evenements</h1></html>",JLabel.CENTER));
		
		if (timeline.getNbEvenements() !=0) {
			HashMap<Date,Evenement> hash_evt = timeline.getHash_Evenements();
			Iterator<Date> dates = hash_evt.keySet().iterator();
			Evenement evt;
			Date date;
			while(dates.hasNext()) {
				date = (Date) dates.next();
				evt = hash_evt.get(date);
				addEvenement(evt);
			}
			setTitre();
		}
	}
	/**
	 * Méthode permetant de mettre a l'écoute les boutons du Jpanel dans le controleur
	 * @param parC controleur a mettre a l'écoute
	 */
	public void enregistreEcouteur(Controleur parC) {
		boutonDroite.addActionListener(parC);
		boutonGauche.addActionListener(parC);
	}
	/**
	 * met a jour le modele de la Jtable en fonction du timeline
	 * @param parTimeline timeline
	 */
	public void setTable(Timeline parTimeline) {
		panelTable.updateTable(parTimeline);
	}
	/**
	 * Ajout un titre de la fenetre et le mettre en html
	 */
	public void setTitre(){
		String titre = "<html><h1>"+timeline.getTitre()+"</h1></html>";
		JLabel label = new JLabel(titre,JLabel.CENTER);
		this.add(label,BorderLayout.NORTH);
	}
	/**
	 * Ajout un Evenement, pour cela ajoute un nouveau PanelEvenement contenant l'evenement.
	 * @param parEvt Evenement a ajouter
	 */
	public void addEvenement(Evenement parEvt) {
		panelEvts.add(new PanelEvenement(parEvt),parEvt.getChTitre());
		
		if (nbPanelEvenements ==0) {
			showEvenement(parEvt);
			dateCourante = parEvt.getChDate(); //add dateCourante
		}
		nbPanelEvenements += 1;

	}
	/**
	 * Affiche le panelEvenement corespondant a l'evenement donnée en parametre
	 * @param parEvt un Evenement
	 */
	public void showEvenement(Evenement parEvt) {
		gestionnaireEvts.show(panelEvts,parEvt.getChTitre());
		dateCourante = parEvt.getChDate(); //add dateCourante
	}

	/**
	 * Méthode qui affiche le PanelEvenement d'apres chronologiquement en fonction de la date de l'evenement
	 * @see Date
	 */
	public void apres() {		
		//Les evenements 
		HashMap<Date,Evenement> hashevts = timeline.getHash_Evenements();
		Iterator<Date> dates = hashevts.keySet().iterator();
		
		Date date;
		Evenement evt = null;
		Date tamp = timeline.getDateFin();
		
		while(dates.hasNext()) {
			date = (Date) dates.next();
			evt = hashevts.get(date);
			if (evt.getChDate().compareTo(dateCourante) > 0 && evt.getChDate().compareTo(tamp) <= 0)
				tamp = evt.getChDate();	
		}
		try {
			showEvenement(timeline.getEvenement(tamp));
		}catch (Exception e) {
		}
	}
	/**
	 * Méthode qui affiche le PanelEvenement d'avant chronologiquement en fonction de la date de l'evenement
	 * @see Date
	 */
	public void avant() {		
		//Les evenements 
		HashMap<Date,Evenement> hashevts = timeline.getHash_Evenements();
		Iterator<Date> dates = hashevts.keySet().iterator();
		
		Date date;
		Evenement evt = null;
		Date tamp = timeline.getDateDebut();
		
		while(dates.hasNext()) {
			date = (Date) dates.next();
			evt = hashevts.get(date);
			if (evt.getChDate().compareTo(dateCourante) < 0 && evt.getChDate().compareTo(tamp) >= 0)
				tamp = evt.getChDate();
		}
		try {
			showEvenement(timeline.getEvenement(tamp));
		}catch (Exception e) {
		}	
	}
	
	/**
	 * Change la date de l'evenement afficher
	 * @param parDate Un objet de la classe Date
	 * @see Date
	 */
	public void setDateCourante(Date parDate) {
		dateCourante = parDate;
	}

}
