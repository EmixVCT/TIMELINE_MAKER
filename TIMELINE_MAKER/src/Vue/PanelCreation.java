package Vue;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

/**
 * PanelCreation est la classe permet de crée un JPanel contenant deux panelFormulaire
 * gérer par un cardLayout
 * 
 * @author Maxime VINCENT et Hugo HAMEL
 * @see PanelFormulaireTimeline
 * @see PanelFormulaireEvenement
 */
public class PanelCreation extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private CardLayout gestionnaireFormulaire;
	private boolean timelineOpen;
	/**
	 * Constructeur de la classe PanelCreation
	 * @param parPFT {@link PanelFormulaireTimeline}
	 * @param parPFE {@link PanelFormulaireEvenement}
	 * @param n boolean pour savoir si un timeline a deja été créé ou non
	 */
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
	/**
	 * Méthode qui permet de changer de formulaire grace a cardLayout
	 */
	public void changerFormulaire() {
		gestionnaireFormulaire.next(this);
	}
	
}
