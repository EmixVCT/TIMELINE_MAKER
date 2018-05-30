package Modele;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date {
	private int chJour;
	private int chMois;
	private int chAnnee;
	private int chJourSemaine;  
	   
	public Date ()   { 
		GregorianCalendar dateAuj = new GregorianCalendar ();
		chAnnee = dateAuj.get (Calendar.YEAR);
		chMois = dateAuj.get (Calendar.MONTH)+1; 
		chJour = dateAuj.get (Calendar.DAY_OF_MONTH);
		chJourSemaine = dateAuj.get (Calendar.DAY_OF_WEEK);
	}
	  
	public Date (int parJour, int parMois, int parAnnee)   {   
		chJour = parJour;
		chMois = parMois;
		chAnnee = parAnnee; 
		GregorianCalendar date = new GregorianCalendar (chAnnee,chMois-1,chJour);
		chJourSemaine = date.get (Calendar.DAY_OF_WEEK);				
	} 
	
	public String toString () {
		String chaine = new String();
		switch (chJourSemaine) {
			case 1: chaine = "dimanche"; break;
			case 2: chaine = "lundi"; break;
			case 3: chaine = "mardi"; break;
			case 4: chaine = "mercredi"; break;
			case 5: chaine = "jeudi"; break;
			case 6: chaine = "vendredi"; break;
			case 7: chaine = "samedi"; break;
			}
		chaine += " " + chJour + " ";
		switch (chMois) {
			case 1: chaine += "janvier"; break;
			case 2: chaine += "février"; break;
			case 3: chaine += "mars"; break;
			case 4: chaine += "avril"; break;
			case 5: chaine += "mai"; break;
			case 6: chaine += "juin"; break;
			case 7: chaine += "juillet"; break;
			case 8: chaine += "Aout"; break;
			case 9: chaine += "septembre"; break;
			case 10: chaine += "octobre"; break;
			case 11: chaine += "novembre"; break;
			case 12: chaine += "Décembre"; break;
			}	
		return chaine;
	}
	public int getAnnee() { 
		return chAnnee;
	}

	public int getJour() { 
		return chJour;
	}

	public int getMois() { 
		return chMois;
	}

	public int getJourSemaine () {
		return chJourSemaine;
	}

	public void setJour(int jour) {
		this.chJour = jour;
	}

	public void setMois(int mois) {
		this.chMois = mois;
	}

	public void setAnnee(int annee) {
		this.chAnnee = annee;
	}

	public void setJourSemaine(int jourSemaine) {
		this.chJourSemaine = jourSemaine;
	}
	
	
}
