package Modele;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

import Modele.Date;
import Modele.Evenement;

public class Timeline {
	private String chTitre;
	private Date chDateDebut;
	private Date chDateFin;
	private int chPeriode;
	private String chAdresseFichier;
	private HashMap<Date,Evenement> Hash_Evenements;
	
	public Timeline() {
		chTitre = "";
		chDateDebut = new Date();
		chDateFin = new Date();
		chPeriode = 1;
		chAdresseFichier = "";
		Hash_Evenements = new HashMap<Date,Evenement>();
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
		Hash_Evenements.put(date, parEvt);
	}
	
	public Evenement getEvenement(Date parDate) {
		return Hash_Evenements.get(parDate);
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
	public HashMap<Date, Evenement> getHash_Evenements() {
		return Hash_Evenements;
	}
	public int getchPeriode() {
		return chPeriode;
	}
	
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
}
