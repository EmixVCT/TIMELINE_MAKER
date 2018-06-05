package Modele;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Evenement {
	private String chTitre;
	private Date chDate;
	private String chDescription;
	private int chPoids;
	private String chPhoto;
	private Icon icon;
	
	public Evenement(String parT,Date parDate,String parDesc,int parPoids,String parPhoto) {
		chTitre = parT;
		chDate = parDate;
		chDescription = parDesc;
		chPoids = parPoids;
		chPhoto = parPhoto;
		icon = new ImageIcon(chPhoto);
	}
	
	public String toString() {
		return chTitre;
	}

	public String getChTitre() {
		return chTitre;
	}

	public Date getChDate() {
		return chDate;
	}

	public String getChDescription() {
		return chDescription;
	}

	public int getChPoids() {
		return chPoids;
	}

	public Icon getIcon() {
		return icon;
	}
	public String getChPhoto() {
		return chPhoto;
	}
}
