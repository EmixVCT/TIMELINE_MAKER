package Vue;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

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
		
		gestionnaireFormulaire.show(this,"formEvenement");

	}

}
