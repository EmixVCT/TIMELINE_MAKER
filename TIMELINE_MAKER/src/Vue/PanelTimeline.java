package Vue;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controleur.Controleur;
import Modele.Timeline;

public class PanelTimeline extends JPanel{
	private Timeline timeline;
	private PanelEvenement panelEvenement;
	private PanelTable panelTable;
	
	private JButton boutonDroite = new JButton(">");
	private JButton boutonGauche = new JButton("<");
	
	public PanelTimeline(Timeline parTimeline,PanelEvenement parPE,PanelTable parPT) {
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);
		timeline = parTimeline;
		panelEvenement = parPE;
		panelTable = parPT;
		
		this.add(panelTable,BorderLayout.SOUTH);
		this.add(panelEvenement,BorderLayout.CENTER);
		this.add(boutonDroite,BorderLayout.EAST);
		this.add(boutonGauche,BorderLayout.WEST);
		}
	
	public void enregistreEcouteur(Controleur parC) {
		boutonDroite.addActionListener(parC);
		boutonGauche.addActionListener(parC);
	}

	public void setTable(Timeline parTimeline) {
		panelTable.updateTable(parTimeline);
	}

}
