package Modele;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * ExceptionAjoutEvenement est la classe permet de crée des exception
 * @author Maxime VINCENT et Hugo HAMEL
 * @see Timeline
 */
public class ExceptionAjoutEvenement extends Exception {

	private static final long serialVersionUID = 1L;

	public ExceptionAjoutEvenement() {
		super();
	}

	public ExceptionAjoutEvenement(String parMessage){
		super(parMessage);
		JPanel conteneur = new JPanel();
		JOptionPane.showMessageDialog(conteneur, parMessage);
	}
}
