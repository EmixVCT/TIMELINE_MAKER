package Vue;

import java.awt.Color;

import javax.swing.JPanel;

import Modele.Timeline;

public class PanelTimeline extends JPanel{
	private Timeline timeline;
	private PanelEvenement panelEvenement;
	private PanelTable panelTable;
	
	public PanelTimeline(Timeline parTimeline,PanelEvenement parPE,PanelTable parPT) {
		setBackground(Color.BLACK);
		timeline = parTimeline;
		panelEvenement = parPE;
		panelTable = parPT;
		}

}
