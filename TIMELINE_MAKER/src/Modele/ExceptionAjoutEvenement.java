package Modele;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ExceptionAjoutEvenement extends Exception {
	public ExceptionAjoutEvenement() {
		super();
	}

	public ExceptionAjoutEvenement(String parMessage){
		super(parMessage);
		JPanel conteneur = new JPanel();
		JOptionPane.showMessageDialog(conteneur, parMessage);
	}
}
