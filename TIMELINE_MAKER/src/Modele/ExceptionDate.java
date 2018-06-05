package Modele;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ExceptionDate extends Exception {
	/**
	 * 
	 */
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
