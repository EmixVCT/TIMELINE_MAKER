package Modele;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;

import Modele.Date;
import Modele.Evenement;

public class Timeline {
	private String chTitre;
	private Date chDateDebut;
	private Date chDateFin;
	private int chPeriode;
	private String chAdresseFichier;
	private HashMap<Integer,ArrayList<Evenement>> Hash_Evenements;
	
	public Timeline() {
		chTitre = "";
		chDateDebut = new Date();
		chDateFin = new Date();
		chPeriode = 1;
		chAdresseFichier = "";
		Hash_Evenements = new HashMap<Integer,ArrayList<Evenement>>();
	}
	public void setTimeline(String parTitre,Date parDebut,Date parFin,int parPeriode,String parLien) {
		chTitre = parTitre;
		chDateDebut = parDebut;
		chDateFin = parFin;
		chPeriode = parPeriode;
		chAdresseFichier = parLien;
	}
	
	public String toString() {
		return chTitre + " du " + chDateDebut.toString() + " au " +chDateFin.toString();
	}
	
	public void ajout(Evenement parEvt) {
		Date date = parEvt.getChDate();
		int annee = date.getAnnee();
		if (Hash_Evenements.containsKey(annee)){
			Hash_Evenements.get(annee).add(parEvt);
		}
		else{
			ArrayList <Evenement> liste = new ArrayList();
			liste.add(parEvt);
			Hash_Evenements.put(annee, liste);
		}
	}
	
	public Collection<Evenement> getEvenement(int parAnnee) {
		return Hash_Evenements.get(parAnnee);
	}

	public Date getDateFin() {
		return chDateFin;
	}
	
	public Date getDateDebut() {
		return chDateDebut;
	}
	public String getTitre() {
		return chTitre;
	}
	
}
