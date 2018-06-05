package Vue;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;


public class PanelCreation extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private CardLayout gestionnaireFormulaire;
	private boolean timelineOpen;
	
	public PanelCreation(PanelFormulaireTimeline parPFT,PanelFormulaireEvenement parPFE,boolean n) {
		gestionnaireFormulaire = new CardLayout(1,1);
		setLayout(gestionnaireFormulaire);

		setBackground(new Color(128, 208, 208));
		
		PanelFormulaireTimeline panelFormulaireTimeline = parPFT;
		PanelFormulaireEvenement panelFormulaireEvenement = parPFE;
		timelineOpen = n;
		
		add(panelFormulaireEvenement,"formEvenement");
		if (!timelineOpen) {
			add(panelFormulaireTimeline,"formTimeline");
			gestionnaireFormulaire.show(this,"formTimeline");
		}
		
	}
	
	public void changerFormulaire() {
		gestionnaireFormulaire.next(this);
	}
	
}
