package Vue;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class PanelTimelineMaker extends JPanel{

	private CardLayout gestionnaireDeCartes;
	
	public PanelTimelineMaker() {
		setBackground(new Color(230,67,98));
		gestionnaireDeCartes = new CardLayout(5,5);
		
		PanelTimeline panelTimeline = new PanelTimeline();
		
		PanelCreation panelCreation = new PanelCreation();
		
		add(panelCreation,"creation");
		add(panelTimeline,"timeline");
	}

}
