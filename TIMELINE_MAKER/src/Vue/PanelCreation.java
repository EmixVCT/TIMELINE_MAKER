package Vue;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

import Modele.Date;
import Modele.Timeline;

public class PanelCreation extends JPanel {
	
	private CardLayout gestionnaireFormulaire;
	
	public PanelCreation() {
		gestionnaireFormulaire = new CardLayout(1,1);
		setLayout(gestionnaireFormulaire);
		
		setBackground(Color.YELLOW);
		
		PanelFormulaireTimeline panelFormulaireTimeline = new PanelFormulaireTimeline();
		PanelFormulaireEvenement panelFormulaireEvenement = new PanelFormulaireEvenement();
		
		add(panelFormulaireTimeline,"formTimeline");
		add(panelFormulaireEvenement,"formEvenement");
		
		gestionnaireFormulaire.show(this,"formTimeline");
	}
	
	public void changerFormulaire() {
		gestionnaireFormulaire.show(this, "formEvenement");
	}
}
