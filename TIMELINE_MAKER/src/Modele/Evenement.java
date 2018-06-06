package Modele;

import java.io.Serializable;

/**
 * Evenement est la classe permet de crée des evenement 
 * Cette classe est caractérisée par les informations suivante :
 * <ul>
 * <li>un titre d'evenement</li>
 * <li>une date d'evenement</li>
 * <li>une description de l'evenement</li>
 * <li>un poid de l'evenement</li>
 * <li>une lien vers un photo</li>
 * </ul>
 * @author Maxime VINCENT et Hugo HAMEL
 * @see Date
 */
public class Evenement implements Serializable {

	private static final long serialVersionUID = 1L;
	private String chTitre;
	private Date chDate;
	private String chDescription;
	private int chPoids;
	private String chPhoto;
	//private Icon icon;
	
	/** 
    * <b>Constructeur de Evenement</b> 
    * @param parT titre de l'evenement en String
    * @param parDate Objet de la classe Date
    * @param parDesc description de levenement en String
    * @param parPoids Poid de l'evenement en integer
    * @param parPhoto lien de fichier photo en string
    * @see Date
    */ 
	public Evenement(String parT,Date parDate,String parDesc,int parPoids,String parPhoto) {
		chTitre = parT;
		chDate = parDate;
		chDescription = parDesc;
		chPoids = parPoids;
		chPhoto = parPhoto;
		//icon = new ImageIcon(chPhoto);
	}
	/**
	 * méthode toString de la classe Evenement
	 */
	public String toString() {
		return chTitre;
	}
	/**
	 * méthode getChTitre de la classe Evenement
	 */
	public String getChTitre() {
		return chTitre;
	}
	/**
	 * méthode getChDate de la classe Evenement
	 */
	public Date getChDate() {
		return chDate;
	}
	/**
	 * méthode getChDescription de la classe Evenement
	 */
	public String getChDescription() {
		return chDescription;
	}
	/**
	 * méthode getChPoids de la classe Evenement
	 */
	public int getChPoids() {
		return chPoids;
	}

	/**
	 * méthode getChPhoto de la classe Evenement
	 */
	public String getChPhoto() {
		return chPhoto;
	}
}
