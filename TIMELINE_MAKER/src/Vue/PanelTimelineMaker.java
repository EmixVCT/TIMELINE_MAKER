package Vue;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelTimelineMaker extends JPanel implements ActionListener{

	private CardLayout gestionnaireDeCartes;
	
	public PanelTimelineMaker() {
		setBackground(new Color(230,67,98));
		gestionnaireDeCartes = new CardLayout(5,5);
		
		setLayout(gestionnaireDeCartes);
		PanelTimeline panelTimeline = new PanelTimeline();
		
		PanelCreation panelCreation = new PanelCreation();
		
		add(panelCreation,"creation");
		add(panelTimeline,"timeline");
		
		gestionnaireDeCartes.show(this,"creation");
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
