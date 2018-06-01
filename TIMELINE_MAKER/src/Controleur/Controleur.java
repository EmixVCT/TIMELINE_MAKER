package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Timeline;
import Vue.PanelCreation;
import Vue.PanelFormulaireEvenement;
import Vue.PanelFormulaireTimeline;
import Vue.PanelTimeline;

public class Controleur implements ActionListener {
	private Timeline timeline;
	
	private PanelCreation panelCreation;
	private PanelFormulaireEvenement panelFormulaireEvenement;
	private PanelFormulaireTimeline panelFormulaireTimeline;
	
	private PanelTimeline panelTimeline;
	
	
	public Controleur(Timeline parTl,PanelCreation parPC,PanelTimeline parPT,PanelFormulaireEvenement parPFE ,PanelFormulaireTimeline parPFT) {
		timeline = parTl;
		panelCreation =parPC;
		panelTimeline = parPT;
		panelFormulaireEvenement = parPFE;
		panelFormulaireTimeline = parPFT;
		
		panelFormulaireEvenement.enregistreEcouteur(this);
		panelFormulaireTimeline.enregistreEcouteur(this);
	}

	public void actionPerformed(ActionEvent parEvt) {
		if(parEvt.getActionCommand().equals("cree")){
			timeline = panelFormulaireTimeline.getTimeline();
			panelCreation.changerFormulaire();
			
		}
		
	}

}
