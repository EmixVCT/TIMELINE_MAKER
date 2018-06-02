package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Evenement;
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
			panelFormulaireTimeline.setTimeline(timeline);
			panelCreation.changerFormulaire();
			panelTimeline.setTitre();
			panelTimeline.setTable(timeline);
			
		}
		else if(parEvt.getActionCommand().equals("ajout")){
			timeline.ajout(panelFormulaireEvenement.getEvenement());
			panelTimeline.addEvenement(panelFormulaireEvenement.getEvenement());
			panelFormulaireEvenement.reset();	
			panelTimeline.setTable(timeline);
		}
		else if(parEvt.getActionCommand().equals("droite")){
			panelTimeline.apres();
		}
		else if(parEvt.getActionCommand().equals("gauche")){
			panelTimeline.avant();
		}
		
	}

}
