package Vue;

import java.awt.Color;

import javax.swing.JPanel;

import Modele.Evenement;

public class PanelEvenement extends JPanel{
	private Evenement chEvenement;
	
	public PanelEvenement(Evenement parEvt) {
		setBackground(Color.darkGray);
		chEvenement = parEvt;
	}

}
