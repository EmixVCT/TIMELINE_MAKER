package Vue;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;


public class PanelCreation extends JPanel {
	
	private CardLayout gestionnaireFormulaire;
	
	public PanelCreation(PanelFormulaireTimeline parPFT,PanelFormulaireEvenement parPFE) {
		gestionnaireFormulaire = new CardLayout(1,1);
		setLayout(gestionnaireFormulaire);
		
		setBackground(new Color(128, 208, 208));
		
		PanelFormulaireTimeline panelFormulaireTimeline = parPFT;
		PanelFormulaireEvenement panelFormulaireEvenement = parPFE;
		add(panelFormulaireTimeline,"formTimeline");
		add(panelFormulaireEvenement,"formEvenement");
		
		gestionnaireFormulaire.show(this,"formTimeline");
	}
	
	public void changerFormulaire() {
		gestionnaireFormulaire.next(this);
	}
}
