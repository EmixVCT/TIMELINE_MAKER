package Vue;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controleur.Controleur;
import Modele.LectureEcriture;
import Modele.Timeline;


/**
 * PanelTimelineMaker est la classe permet de crée un JPanel contenant les deux panel
 * principaux gérer par un cardLayout
 * les 2 panels suivant :
 * <ul>
 * <li>Le panelTimeline</li>
 * <li>Le panelCreation</li>
 * </ul>
 * 
 * @author Maxime VINCENT et Hugo HAMEL
 *
 */
public class PanelTimelineMaker extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private CardLayout gestionnaireDeCartes;
	private Timeline timeline;
	private boolean timelineOpen = false;

	/**
	 * Constructeur de la classe PanelTimelineMaker
	 * Affiche dans un premier temp une boite de dialogue puis ajoute les panels
	 */
	public PanelTimelineMaker() {
		
		String intitulesBoutons[] = {"Oui", "Non"};	
		int resultat = JOptionPane.showOptionDialog(this, "Voulez vous ouvrir une frise existante ?", "Timeline Maker", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, intitulesBoutons, intitulesBoutons[0]);
		
		if (resultat == JOptionPane.YES_NO_OPTION) {
			File repertoireCourant = null;
	        try {
	            repertoireCourant = new File(".").getCanonicalFile();
	        } catch(IOException e) {}
	        JFileChooser dialogue = new JFileChooser(repertoireCourant);
	        dialogue.showOpenDialog(null);
	        
			File fichierTimeline = dialogue.getSelectedFile();
			try {
				timeline = (Timeline) LectureEcriture.lecture(fichierTimeline);
				timelineOpen = true;
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this,"Erreur lors de l'ouverture de la Timeline");
				timeline = new Timeline();
			}
		}else {
			
			timeline = new Timeline();
		}
		
		PanelFormulaireTimeline panelFormulaireTimeline = new PanelFormulaireTimeline();
		PanelFormulaireEvenement panelFormulaireEvenement = new PanelFormulaireEvenement();
		PanelCreation panelCreation = new PanelCreation(panelFormulaireTimeline,panelFormulaireEvenement,timelineOpen);
		PanelTimeline panelTimeline = new PanelTimeline(timeline);
		
		
		setBackground(new Color(128, 208, 208));
		gestionnaireDeCartes = new CardLayout(25,25);
		
		setLayout(gestionnaireDeCartes);

		add(panelCreation,"creation");
		add(panelTimeline,"timeline");
		
		gestionnaireDeCartes.show(this,"creation");
		
		@SuppressWarnings("unused")
		Controleur controleur = new Controleur(timeline,panelCreation,panelTimeline,panelFormulaireEvenement ,panelFormulaireTimeline);

	}
	/** 
    * <b>méthode actionPerfomed de la classe PanelTimelineMaker</b> 
    * @param parEvt Objet de la classe ActionEvent
    * 
    * La methode ce déclanche lorsque qu'un evenement ce passe 
    * dans les panel mis sur ecoute pas le controleur
    * @see FenetreTimeline
    */ 
	public void actionPerformed(ActionEvent parEvt) {
		String actionCommand = parEvt.getActionCommand();
		
		if(actionCommand.equals("creation")){
			gestionnaireDeCartes.show(this, "creation");
		}
		if(actionCommand.equals("timeline")){
			gestionnaireDeCartes.show(this, "timeline");
		}
		if(actionCommand.equals("fermer")){
			int saisi = JOptionPane.showConfirmDialog(this,"veux-tu vraiment quitter le TimelineMaker ?", "QUITTER ?",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
			switch(saisi){
			case JOptionPane.CLOSED_OPTION:
				break;
			case JOptionPane.OK_OPTION:
				System.exit(0); break;
			case JOptionPane.CANCEL_OPTION:
				break;
			}
		}				
	}
	/**
	 * Méthode qui recupère si une timeline a été ouverte
	 * @return renvoie vrai ou faux (boolean)
	 */
	public boolean getTimelineOpen() {
		return timelineOpen;
	}

}
