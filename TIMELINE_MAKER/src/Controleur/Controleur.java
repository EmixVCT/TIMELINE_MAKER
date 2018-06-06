package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import Modele.Evenement;
import Modele.ExceptionAjoutEvenement;
import Modele.ExceptionCreationTimeline;
import Modele.Timeline;
import Vue.FenetreTimeline;
import Vue.PanelCreation;
import Vue.PanelFormulaireEvenement;
import Vue.PanelFormulaireTimeline;
import Vue.PanelTimeline;

/**
 * Controleur est la classe permet de faire le lien entre le modele et la vue
 * Cette classe est caractérisée par les informations suivante :
 * <ul>
 * <li>une timeline</li>
 * <li>un panelCreation</li>
 * <li>un panelFormulaireTimeline</li>
 * <li>un panelFormulaireEvenement</li>
 * <li>un panelCreation</li>
 * </ul>
 * @author Maxime VINCENT et Hugo HAMEL
 * @see Timeline
 * @see PanelTimeline
 * @see PanelFormulaireEvenement
 * @see PanelFormulaireTimeline
 * @see PanelCreation
 */
public class Controleur implements ActionListener {
	private Timeline timeline;
	
	private PanelCreation panelCreation;
	private PanelFormulaireEvenement panelFormulaireEvenement;
	private PanelFormulaireTimeline panelFormulaireTimeline;
	
	private PanelTimeline panelTimeline;
	
	/** 
    * <b>Constructeur de Controleur</b> 
    * @param parTl correspond a l'objet timeline 
    * @param parPC correspond a un panelcreation
    * @param parPT correspond a un panelTimeline
    * @param parPFE correspond a un panelFormulaireEvenement
    * @param parPFT correspond a un panelFormulaireTimeline 
    * Le controleur ce met a l'écoute des elements des panels
    */ 
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
	
	/** 
    * <b>méthode actionPerfomed de la classe Controleur</b> 
    * @param parEvt Objet de la classe ActionEvent
    * 
    * La methode ce déclanche lorsque qu'un evenement ce passe 
    * dans les panel mis sur ecoute pas le controleur
    */ 
	public void actionPerformed(ActionEvent parEvt) {
		if(parEvt.getActionCommand().equals("cree")){
			try {
				panelFormulaireTimeline.setTimeline(timeline);
				panelCreation.changerFormulaire();
				panelTimeline.setTitre();
				panelTimeline.setTable(timeline);
				FenetreTimeline.enableJMenuItemTimeline();
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
		else if (parEvt.getActionCommand().equals("parcourir")) {
			File repertoireCourant = null;
	        try {
	            repertoireCourant = new File(".").getCanonicalFile();
	        } catch(IOException e) {}
	        JFileChooser dialogue = new JFileChooser(repertoireCourant);
	        dialogue.showOpenDialog(null);
	        panelFormulaireEvenement.setTextLienPhoto(dialogue.getSelectedFile().toString());
	        
		}
		else if(parEvt.getActionCommand().equals("droite")){
			panelTimeline.apres();
		}
		else if(parEvt.getActionCommand().equals("gauche")){
			panelTimeline.avant();
		}
		
	}

}
