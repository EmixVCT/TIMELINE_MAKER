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

public class PanelTimeline extends JPanel{
	private Timeline timeline;
	private PanelTable panelTable;
	
	private JButton boutonDroite = new JButton(">");
	private JButton boutonGauche = new JButton("<");
	
	private CardLayout gestionnaireEvts;
	private JPanel panelEvts = new JPanel();
	
	private Date dateCourante;
	private int nbPanelEvenements = 0;
	
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
	
	public void enregistreEcouteur(Controleur parC) {
		boutonDroite.addActionListener(parC);
		boutonGauche.addActionListener(parC);
	}

	public void setTable(Timeline parTimeline) {
		panelTable.updateTable(parTimeline);
	}
	public void setTitre(){
		String titre = "<html><h1>"+timeline.getTitre()+"</h1></html>";
		JLabel label = new JLabel(titre,JLabel.CENTER);
		this.add(label,BorderLayout.NORTH);
	}
	public void addEvenement(Evenement parEvt) {
		panelEvts.add(new PanelEvenement(parEvt),parEvt.getChTitre());
		
		if (nbPanelEvenements ==0) {
			showEvenement(parEvt);
			dateCourante = parEvt.getChDate(); //add dateCourante
		}
		nbPanelEvenements += 1;

	}
	
	public void showEvenement(Evenement parEvt) {
		gestionnaireEvts.show(panelEvts,parEvt.getChTitre());
		dateCourante = parEvt.getChDate(); //add dateCourante
	}

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
	
	public void setDateCourante(Date parDate) {
		dateCourante = parDate;
	}

}
