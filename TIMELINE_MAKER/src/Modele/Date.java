package Modele;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * Date est la classe qui définit une date
 * Cette classe est caractérisée par les informations suivante :
 * <ul>
 * <li>Le jour</li>
 * <li>Le Mois</li>
 * <li>L'Année</li>
 * <li>Le jour de la semaine</li>
 * </ul>
 * @author Maxime VINCENT
 * @version 1.0
 */
public class Date implements Serializable{
	/**
	 * chJour est un entier 
	 * corespond au jour du mois
	 */
	private int chJour;
	/**
	 * chMois est un entier 
	 * corespond au numéraux du mois
	 */
	private int chMois;
	/**
	 * chAnnee est un entier 
	 * corespond a numémeraux de l'année
	 */
	private int chAnnee;
	/**
	 * chJourSemaine est un entier 
	 * corespond a jour de la semaine
	 */
	private int chJourSemaine;  
	 
	

    /** 
     * <b>Constructeur de Date</b> 
     * Ne prennant aucun paramètre.
     * Initialise les champs a la date du Systeme
     */ 
	public Date ()   { 
		GregorianCalendar dateAuj = new GregorianCalendar ();
		chAnnee = dateAuj.get (Calendar.YEAR);
		chMois = dateAuj.get (Calendar.MONTH)+1; 
		chJour = dateAuj.get (Calendar.DAY_OF_MONTH);
		chJourSemaine = dateAuj.get (Calendar.DAY_OF_WEEK);
	}

    /** 
     * <b>Constructeur de Date</b>  
     * 
     * @param parJour 
     *     (int) Jour du mois 
     * @param parMois 
     *     (int) Mois de l'année 
     * @param parAnnee 
     *     (int) Année 
     */ 
	public Date (int parJour, int parMois, int parAnnee) throws ExceptionDate  { 
		if ((parMois <= 0)|| (parMois > 12)) {
			throw new ExceptionDate("Le mois doit etre compris entre 1 et 12 inclus");
		}else {
			chMois = parMois;
		}
		GregorianCalendar dateAuj = new GregorianCalendar ();
		if (parAnnee > dateAuj.get (Calendar.YEAR)) {
			throw new ExceptionDate("L'année doit etre inferieur ou egale a l'année actuelle");
		}else {
			chAnnee = parAnnee; 
		}
		if (parJour <= 0 || parJour > dernierJourDuMois(parMois,parAnnee)) {
			throw new ExceptionDate("Le jour doit etre comprie entre 1 et "+Integer.toString(dernierJourDuMois(parMois,parAnnee))+" inclus");
		}else {
			chJour = parJour;
		}

		GregorianCalendar date = new GregorianCalendar (chAnnee,chMois-1,chJour);
		chJourSemaine = date.get (Calendar.DAY_OF_WEEK);				
	} 
	
    /** 
     * Méthode toString de la class Date
     * 
     * @return la date sous la forme "nomDuJour numérauxDuJour nomDuMois"
     */ 
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
		chaine += " " + chAnnee;
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
    /** 
     * Méthode dernierJourDuMois de la class Date
     * @param parMois Corespond au mois 
     * @param parAnnee Corespond a l'année
     * @return Un entier corespondant au dernier jour du mois
     */ 
	public static int dernierJourDuMois (int parMois, int parAnnee) {
		switch (parMois) {
			case 2 : if (estBissextile (parAnnee))  return 29 ; else return 28 ;  
			case 4 : 	 case 6 : 	 case 9 : 	 case 11 : return 30 ;
			default : return 31 ;
			}  // switch
	}  
	
    /** 
     * Méthode estBissextile de la class Date 
     * @param parAnnee Corespond a l'année
     * @return Un test qui renvoi un boléen en fonction de l'année bissextile ou non
     */
	private static boolean estBissextile(int parAnnee) {
		return parAnnee % 4 == 0 && (parAnnee % 100 != 0 || parAnnee % 400 == 0);
	}
	public int compareTo (Date parDate) {
		if (chAnnee < parDate.chAnnee)
			return -1;
		if (chAnnee > parDate.chAnnee)
			return 1;
		// les annees sont =
		if (chMois < parDate.chMois)
			return -1;
		if (chMois > parDate.chMois)
			return 1;
		// les mois sont =
		if (chJour < parDate.chJour)
			return -1;
		if (chJour > parDate.chJour)
			return 1;
		return 0;	
  }
	  
}
