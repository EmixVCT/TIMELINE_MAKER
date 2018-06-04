package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Evenement;
import Modele.ExceptionAjoutEvenement;
import Modele.ExceptionCreationTimeline;
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
		panelTimeline.enregistreEcouteur(this);
	}

	public void actionPerformed(ActionEvent parEvt) {
		if(parEvt.getActionCommand().equals("cree")){
			try {
				panelFormulaireTimeline.setTimeline(timeline);
				panelCreation.changerFormulaire();
				panelTimeline.setTitre();
				panelTimeline.setTable(timeline);
			} catch (ExceptionCreationTimeline e) {
				e.printStackTrace();
			}	
		}
		else if(parEvt.getActionCommand().equals("ajout")){
			try {
				Evenement evt1 = panelFormulaireEvenement.getEvenement();
				timeline.ajout(evt1);
				panelTimeline.addEvenement(evt1);
				panelFormulaireEvenement.reset();	
				panelTimeline.setTable(timeline);
			} catch (ExceptionAjoutEvenement e) {
				e.printStackTrace();
			}

		}
		else if(parEvt.getActionCommand().equals("droite")){
			panelTimeline.apres();
		}
		else if(parEvt.getActionCommand().equals("gauche")){
			panelTimeline.avant();
		}
		
	}

}
