package Modele;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ExceptionCreationTimeline extends Exception {

	/**
	 * 
	 */
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
