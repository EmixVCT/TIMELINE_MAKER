package Modele;

public class ExceptionAjoutEvenement extends Exception {
	public ExceptionAjoutEvenement() {
		super();
	}

	public ExceptionAjoutEvenement(String parMessage) {
		super(parMessage);
	}
}
