package Modele;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ExceptionCreationTimeline extends Exception {

	public ExceptionCreationTimeline() {
		super();
	}

	public ExceptionCreationTimeline(String parMessage) {
		super(parMessage);
		JPanel conteneur = new JPanel();
		JOptionPane.showMessageDialog(conteneur, parMessage);
	}


}
