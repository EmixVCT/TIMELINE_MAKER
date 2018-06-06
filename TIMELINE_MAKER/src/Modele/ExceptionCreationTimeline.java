package Modele;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Vue.PanelFormulaireTimeline;

/**
 * ExceptionCreationTimeline est la classe permet de crée des exception
 * lors de la creation de timeline dans le formulaire
 * @author Maxime VINCENT et Hugo HAMEL
 * @see PanelFormulaireTimeline
 */
public class ExceptionCreationTimeline extends Exception {

	private static final long serialVersionUID = 1L;

	public ExceptionCreationTimeline() {
		super();
	}

	public ExceptionCreationTimeline(String parMessage) {
		super(parMessage);
		JPanel conteneur = new JPanel();
		JOptionPane.showMessageDialog(conteneur, parMessage);
	}


}
