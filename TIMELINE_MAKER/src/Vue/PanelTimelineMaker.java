package Vue;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controleur.Controleur;
import Modele.Timeline;

public class PanelTimelineMaker extends JPanel implements ActionListener{

	private CardLayout gestionnaireDeCartes;
	
	private Timeline timeline;
	private PanelFormulaireTimeline panelFormulaireTimeline = new PanelFormulaireTimeline();
	private PanelFormulaireEvenement panelFormulaireEvenement = new PanelFormulaireEvenement();
	
	private PanelTimeline panelTimeline = new PanelTimeline();
	private PanelCreation panelCreation = new PanelCreation(panelFormulaireTimeline,panelFormulaireEvenement);
	
	public PanelTimelineMaker() {
		setBackground(new Color(230,67,98));
		gestionnaireDeCartes = new CardLayout(5,5);
		
		setLayout(gestionnaireDeCartes);

		add(panelCreation,"creation");
		add(panelTimeline,"timeline");
		
		gestionnaireDeCartes.show(this,"creation");
		
		Controleur controleur = new Controleur(timeline,panelCreation,panelTimeline,panelFormulaireEvenement ,panelFormulaireTimeline);
	}

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

}
