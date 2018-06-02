package Vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controleur.Controleur;
import Modele.Evenement;
import Modele.Timeline;

public class PanelTimeline extends JPanel{
	private Timeline timeline;
	private PanelTable panelTable;
	private PanelEvenement[] tabPanelEvenement;
	private PanelEvenement panelEvenement;
	
	private JButton boutonDroite = new JButton(">");
	private JButton boutonGauche = new JButton("<");
	
	private CardLayout gestionnaireEvts;
	private JPanel panelEvts = new JPanel();

	private static int nbPanelEvenements = 0;
	public PanelTimeline(Timeline parTimeline,PanelEvenement[] parTabPanelEvenement,PanelTable parPT) {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		
		timeline = parTimeline;
		panelTable = parPT;
		tabPanelEvenement = parTabPanelEvenement;
		
		boutonDroite.setActionCommand("droite");
		boutonGauche.setActionCommand("gauche");
		
		this.add(panelTable,BorderLayout.SOUTH);
		this.add(boutonDroite,BorderLayout.EAST);
		this.add(boutonGauche,BorderLayout.WEST);
		
		gestionnaireEvts = new CardLayout(5,5);
		panelEvts.setLayout(gestionnaireEvts);
		this.add(panelEvts,BorderLayout.CENTER);

		}
	
	public void enregistreEcouteur(Controleur parC) {
		boutonDroite.addActionListener(parC);
		boutonGauche.addActionListener(parC);
	}

	public void setTable(Timeline parTimeline) {
		panelTable.updateTable(parTimeline);
	}
	public void setTitre(){
		this.add(new JLabel(timeline.getTitre(),JLabel.CENTER),BorderLayout.NORTH);
	}
	public void addEvenement(Evenement parEvt) {

		tabPanelEvenement[nbPanelEvenements] = new PanelEvenement(parEvt);
		panelEvts.add(tabPanelEvenement[nbPanelEvenements],parEvt.getChTitre());
		
		nbPanelEvenements += 1;
	}
	
	public void showEvenement(Evenement parEvt) {
		gestionnaireEvts.show(panelEvts,parEvt.getChTitre());
	}

}
