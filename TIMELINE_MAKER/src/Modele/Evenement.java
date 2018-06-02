package Modele;

public class Evenement {
	private String chTitre;
	private Date chDate;
	private String chDescription;
	private int chPoids;
	private String chPhoto;
	
	
	public Evenement(String parT,Date parDate,String parDesc,int parPoids,String parPhoto) {
		chTitre = parT;
		chDate = parDate;
		chDescription = parDesc;
		chPoids = parPoids;
		chPhoto = parPhoto;
	}
	
	public String toString() {
		return "Titre :"+ chTitre+"\nDescription :"+chDescription+"\n la date:"+chDate;
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

	public String getChPhoto() {
		return chPhoto;
	}
}
