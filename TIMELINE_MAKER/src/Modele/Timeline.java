package Modele;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;

import Modele.Date;
import Modele.Evenement;

/**
 * Timeline est la classe qui définit une timeline (frise chronologique)
 * Cette classe est caractérisée par les informations suivante :
 * <ul>
 * <li>Un titre</li>
 * <li>Une date de debut</li>
 * <li>Une date de fin</li>
 * <li>Une période</li>
 * <li>Une adresse de fichier de sauvegarde</li>
 * <li>Une HashMap contenant les Evenements</li>
 * <li>Une variable contant les evenements</li>
 * </ul>
 * @author Maxime VINCENT
 * @see Date
 * @see Evenement
 * @see HashMap
 */
public class Timeline implements Serializable{

	private static final long serialVersionUID = 1L;
	private String chTitre;
	private Date chDateDebut;
	private Date chDateFin;
	private int chPeriode;
	private String chAdresseFichier;
	private HashMap<Date,Evenement> Hash_Evenements;
	private int nbEvenement = 0;
	
    /** 
     * <b>Constructeur de Date</b> 
     * Ne prennant aucun paramètre.
     * Initialise les champs "vide"
     */ 
	public Timeline() {
		chTitre = "";
		chDateDebut = new Date();
		chDateFin = new Date();
		chPeriode = 1;
		chAdresseFichier = "";
		Hash_Evenements = new HashMap<Date,Evenement>();
	}
	/**
	 * Méthode setTimeline qui permet de definir tout les champs de la timeline
	 * @param parTitre le titre
	 * @param parDebut la date de debut
	 * @param parFin la date de fin
	 * @param parPeriode la période
	 * @param parLien le lien du fichier de sauvegarde
	 */
	public void setTimeline(String parTitre,Date parDebut,Date parFin,int parPeriode,String parLien) {
		chTitre = parTitre;
		chDateDebut = parDebut;
		chDateFin = parFin;
		chPeriode = parPeriode;
		chAdresseFichier = parLien;
	}
	/**
	 * Méthode toString de la classe Timeline
	 */
	public String toString() {
		return chTitre + " du " + chDateDebut.toString() + " au " +chDateFin.toString();
	}
	/**
	 * Méthode permettant d'ajouté un Evenement a la timeline 
	 * @param parEvt evenement a ajouter
	 * @throws ExceptionAjoutEvenement
	 * @see Date
	 * @see Evenement
	 */
	public void ajout(Evenement parEvt) throws ExceptionAjoutEvenement{
		Date dateEvt = parEvt.getChDate();
		if (dateEvt.compareTo(chDateDebut) >= 0 && dateEvt.compareTo(chDateFin) <= 0) {
			Date date = parEvt.getChDate();
			Hash_Evenements.put(date, parEvt);
			nbEvenement++;
			saveTimeline();
		}
		else
			throw new ExceptionAjoutEvenement("La date de l'evenement doit etre comprise entre la date de debut et la date de fin");
	}
	/**
	 * Méthode getEvenement de la classe Timeline
	 */
	public Evenement getEvenement(Date parDate) {
		return Hash_Evenements.get(parDate);
	}
	/**
	 * Méthode getDateFin de la classe Timeline
	 */
	public Date getDateFin() {
		return chDateFin;
	}
	/**
	 * Méthode getDateDebut de la classe Timeline
	 */
	public Date getDateDebut() {
		return chDateDebut;
	}
	/**
	 * Méthode getTitre de la classe Timeline
	 */
	public String getTitre() {
		return chTitre;
	}
	/**
	 * Méthode getHash_Evenements de la classe Timeline
	 */
	public HashMap<Date, Evenement> getHash_Evenements() {
		return Hash_Evenements;
	}
	/**
	 * Méthode getchPeriode de la classe Timeline
	 */
	public int getchPeriode() {
		return chPeriode;
	}
	/**
	 * Méthode getPremierEvenement de la classe Timeline
	 * @return Le premier evenement de la timeline en fonction de la date 
	 */
	public Evenement getPremierEvenement() {
		Iterator<Date> dates = Hash_Evenements.keySet().iterator();
		Date date;
		Date tamp = chDateFin;
		
		Evenement evt;
		while(dates.hasNext()) {
			date = (Date) dates.next();
			if (date.compareTo(tamp) < 1) {
				tamp = date;
			}
		}
		evt = Hash_Evenements.get(tamp);
		return evt;
	}
	/**
	 * Méthode getDernierEvenement de la classe Timeline
	 * @return Le dernier evenement de la timeline en fonction de la date 
	 */
	public Evenement getDernierEvenement() {
		Iterator<Date> dates = Hash_Evenements.keySet().iterator();
		Date date;
		Date tamp = chDateDebut;
		
		Evenement evt;
		while(dates.hasNext()) {
			date = (Date) dates.next();
			if (date.compareTo(tamp) > 1) {
				tamp = date;
			}
		}
		evt = Hash_Evenements.get(tamp);
		return evt;
	}
	/**
	 * Méthode saveTimeline de la classe Timeline
	 * sauvegarde la l'objet a l'adresse du fichier
	 * @see LectureEcriture
	 */
	public void saveTimeline() {
		File file = new File(chAdresseFichier);
		file.mkdirs();
		LectureEcriture.ecriture(new File(chAdresseFichier + File.separator + chTitre + ".ser"), this);
	}
	/**
	 * Méthode getNbEvenements de la classe Timeline
	 */
	public int getNbEvenements() {
		return nbEvenement;
	}
}
