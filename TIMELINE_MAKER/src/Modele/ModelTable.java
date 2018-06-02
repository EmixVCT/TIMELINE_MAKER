package Modele;

import java.util.Collection;

import javax.swing.table.DefaultTableModel;
import Modele.Timeline;

public class ModelTable extends DefaultTableModel{
	private int chNombreCol;
	private int chNombreLig;
	private int chAnneeDebut;
	private int chAnneeFin;
	private Timeline timeline;
	
	public ModelTable(Timeline partimeline){
		
		timeline = partimeline;
		chAnneeDebut = timeline.getDateDebut().getAnnee();
		chAnneeFin = timeline.getDateFin().getAnnee();
		
		chNombreCol = chAnneeFin - chAnneeDebut;
		chNombreLig = 4;
		this.setColumnCount(chNombreCol);
		this.setRowCount(chNombreLig);
		
		String [] Entete = new String[chNombreCol];
		int j = 0;
		for(int i = chAnneeDebut ; i < chAnneeFin;i++) {
			Entete[j] =  Integer.toString(i);
			j++;
		}
		
		this.setColumnIdentifiers(Entete); 
		
		//Les evenements 
		Collection <Evenement> evtsAnnee = timeline.getEvenement(1999); // A check
		
		if (evtsAnnee != null){
			for (Evenement evt : evtsAnnee){
				ajoutEvenement(evt,1999); // 
			}
		}
	}//constructeur

	public void ajoutEvenement(Evenement parEvt,int parAnnee) {
		int indiceColonne = parAnnee - chAnneeDebut;
		int indiceLigne = parEvt.getChPoids();
		
		while (indiceLigne<15 && getValueAt(indiceLigne, indiceColonne)!= null){
			indiceLigne++;
		}
		setValueAt(parEvt,indiceLigne, indiceColonne);
	}//ajoutEvenement
	
	public Class getColumnClass(int indice){
		return Evenement.class;
	}
}//Classe
