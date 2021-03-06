package Modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import Modele.Timeline;
/**
 * ModelTable est la classe permet de definir un modele a une JTable
 * Cette classe est caractérisée par les informations suivante :
 * <ul>
 * <li>une timeline</li>
 * <li>un nombre de colonne</li>
 * <li>un nombre de ligne</li>
 * <li>une année de debut</li>
 * <li>une année de fin</li>
 * </ul>
 * @author Maxime VINCENT et Hugo HAMEL
 * @see DefaultTableModel
 */
public class ModelTable extends DefaultTableModel{

	private static final long serialVersionUID = 1L;
	private int chNombreCol;
	private int chNombreLig;
	private int chAnneeDebut;
	private int chAnneeFin;
	private Timeline timeline;
	/** 
    * <b>Constructeur de ModelTable</b> 
    * @param partimeline correspond a l'objet timeline 
    * ModelTable construit la JTable avec les information recupéré dans la Timeline entrez en paramètre
    */ 
	public ModelTable(Timeline partimeline){

		timeline = partimeline;
		chAnneeDebut = timeline.getDateDebut().getAnnee();
		chAnneeFin = timeline.getDateFin().getAnnee();
		
		chNombreCol = chAnneeFin - chAnneeDebut +1;
		chNombreLig = 4;
		
		this.setColumnCount(chNombreCol);
		this.setRowCount(chNombreLig);
		
		ArrayList<String> Entete = new ArrayList<String>();
		int j = 0;
		for(int i = chAnneeDebut ; i <= chAnneeFin;i++) {

			if (j%timeline.getchPeriode()==0) {
				Entete.add(Integer.toString(i)) ;
			}
			else
				Entete.add("");
			j++;
		}
		this.setColumnIdentifiers(Entete.toArray()); 
		
		//Les evenements 
		HashMap<Date,Evenement> hashevts = timeline.getHash_Evenements();
				
		Iterator<Date> dates = hashevts.keySet().iterator();
		Date date;
		Evenement evt;
		while(dates.hasNext()) {
			date = (Date) dates.next();
			evt = hashevts.get(date);
			ajoutEvenement(evt);

		}

	}//constructeur
	/** 
    * Méthode ajoutEvenememnt
    * @param parEvt correspond a l'objet Evenement
    * Ajoute a la JTable un Evenement on fonction de ces champs
    */ 
	public void ajoutEvenement(Evenement parEvt) {
		int indiceColonne = parEvt.getChDate().getAnnee() - chAnneeDebut;
		int indiceLigne = parEvt.getChPoids()-1;
		
		while (indiceLigne<15 && getValueAt(indiceLigne, indiceColonne)!= null){
			indiceLigne++;
		}
		setValueAt(parEvt,indiceLigne, indiceColonne);
	}//ajoutEvenement
	

	public Class<Evenement> getColumnClass(int indice){
		return Evenement.class;
	}
}//Classe
