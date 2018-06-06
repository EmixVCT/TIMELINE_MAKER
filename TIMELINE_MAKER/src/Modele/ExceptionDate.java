package Modele;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * ExceptionDate est la classe permet de crée des exception
 * lors de la creation de date avec les contructeur a trois entier en parametre
 * @author Maxime VINCENT et Hugo HAMEL
 * @see Date
 */
public class ExceptionDate extends Exception {

	private static final long serialVersionUID = 1L;
	public ExceptionDate(String parMessage){
		super(parMessage);
		JPanel conteneur = new JPanel();
		JOptionPane.showMessageDialog(conteneur, parMessage);
	}
	public ExceptionDate(){
		super();
	}
}
