/**
 * 
 */
package Test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import Modele.Date;
import Modele.Evenement;
import Modele.ExceptionAjoutEvenement;
import Modele.ExceptionDate;
import Modele.Timeline;

/**
 * @author maxsv
 *
 */
public class TimelineTest {
	private Timeline timeline = new Timeline();

	/**
	 * Test method for {@link Modele.Timeline#Timeline()}.
	 */
	@Test
	public void testTimeline() {
		Timeline t = new Timeline();
		assertNotNull("Timeline crée",t);
	}

	/**
	 * Test method for {@link Modele.Timeline#setTimeline(java.lang.String, Modele.Date, Modele.Date, int, java.lang.String)}.
	 * @throws ExceptionDate 
	 */
	@Test
	public void testSetTimeline() throws ExceptionDate {
		Timeline t = new Timeline();
		t.setTimeline("titre", new Date(1,1,2000), new Date(1,1,2010), 2, "/lien");
		assertNotNull("Timeline crée",t);
	}

	/**
	 * Test method for {@link Modele.Timeline#toString()}.
	 * @throws ExceptionDate 
	 */
	@Test
	public void testToString() throws ExceptionDate {
		Timeline t = new Timeline();
		t.setTimeline("titre", new Date(1,1,2000), new Date(1,1,2010), 2, "/lien");
		System.out.println(t.toString());
	}

	/**
	 * Test method for {@link Modele.Timeline#ajout(Modele.Evenement)}.
	 * @throws ExceptionDate 
	 * @throws ExceptionAjoutEvenement 
	 */
	@Test
	public void testAjout() throws ExceptionDate {
		Timeline t = new Timeline();
		t.setTimeline("titre", new Date(1,1,2000), new Date(1,1,2010), 2, "/lien");
		
		try {
			t.ajout(new Evenement("", new Date(), "desc", 1, "/photo"));
		} catch (ExceptionAjoutEvenement e) {}
		assertNull("t est null la date est en dehors de la frise",t.getEvenement(new Date()));
		
		
		try {
			t.ajout(new Evenement("", new Date(1,1,2002), "desc", 1, "/photo"));
		} catch (ExceptionAjoutEvenement e) {}
		assertNull("t est null car le titre est null",t.getEvenement(new Date(1,1,2002)));
		
	}

	/**
	 * Test method for {@link Modele.Timeline#getEvenement(Modele.Date)}.
	 */
	@Test
	public void testGetEvenement() {
		Date dateD = new Date();
		try {
			dateD = new Date(1,1,1);
		} catch (ExceptionDate e) {}
		Date dateF = new Date();
		timeline.setTimeline("titre", dateD, dateF, 1, "lien");
		
		
		Date dateEvt = new Date();
		try {
			dateEvt = new Date(1,1,2002);
		} catch (ExceptionDate e) {}
		
		
		Evenement parEvt = new Evenement("",dateEvt , "desc", 1, "/photo");
		try {
			timeline.ajout(parEvt);
		} catch (ExceptionAjoutEvenement e) {}
		
		assertNotNull("renvoi l'evenement",timeline.getEvenement(dateEvt));
		assertNull("renvoi pas d'evenement",timeline.getEvenement(new Date()));

	}

	/**
	 * Test method for {@link Modele.Timeline#getDateFin()}.
	 */
	@Test
	public void testGetDateFin() {
		Date dateD = new Date();
		try {
			dateD = new Date(1,1,1);
		} catch (ExceptionDate e) {}
		Date dateF = new Date();
		timeline.setTimeline("titre", dateD, dateF, 1, "lien");
		
		assertTrue("Date de fin est egale a la date d'aujourd'hui",timeline.getDateFin().compareTo(new Date())==0);
		assertFalse("Date de fin est pas egale a la date de debut",timeline.getDateFin().compareTo(dateD)==0);

	}

	/**
	 * Test method for {@link Modele.Timeline#getDateDebut()}.
	 */
	@Test
	public void testGetDateDebut() {
		Date dateD = new Date();
		try {
			dateD = new Date(1,1,1);
		} catch (ExceptionDate e) {}
		Date dateF = new Date();
		timeline.setTimeline("titre", dateD, dateF, 1, "lien");
		
		assertFalse("Date de depart est pas egale a la date d'aujourd'hui",timeline.getDateDebut().compareTo(new Date())==0);
		assertTrue("Date de depart est egale a la date de depart",timeline.getDateDebut().compareTo(dateD)==0);
	}

	/**
	 * Test method for {@link Modele.Timeline#getTitre()}.
	 */
	@Test
	public void testGetTitre() {
		Date dateD = new Date();
		try {
			dateD = new Date(1,1,1);
		} catch (ExceptionDate e) {}
		Date dateF = new Date();
		timeline.setTimeline("titre", dateD, dateF, 1, "lien");
		assertTrue("Le titre est egale a titre",timeline.getTitre().compareTo("titre")==0);
		assertFalse("Le titre est pas egale a ttitre",timeline.getTitre().compareTo("ttitre")==0);


	}

	/**
	 * Test method for {@link Modele.Timeline#getHash_Evenements()}.
	 */
	@Test
	public void testGetHash_Evenements() {
		Date dateD = new Date();
		try {
			dateD = new Date(1,1,1);
		} catch (ExceptionDate e) {}
		Date dateF = new Date();
		timeline.setTimeline("titre", dateD, dateF, 1, "lien");
		
		
		Date dateEvt = new Date();
		try {
			dateEvt = new Date(1,1,2002);
		} catch (ExceptionDate e) {}
		
		
		Evenement parEvt = new Evenement("",dateEvt , "desc", 1, "/photo");
		try {
			timeline.ajout(parEvt);
		} catch (ExceptionAjoutEvenement e) {}
		
		HashMap<Date, Evenement> hp = timeline.getHash_Evenements();
		
		HashMap<Date, Evenement> res = new HashMap<Date, Evenement>();
		res.put(dateEvt,parEvt);
		
		assertEquals(hp, res);
	}


	/**
	 * Test method for {@link Modele.Timeline#getPremierEvenement()}.
	 */
	@Test
	public void testGetPremierEvenement() {
	}

	/**
	 * Test method for {@link Modele.Timeline#getDernierEvenement()}.
	 */
	@Test
	public void testGetDernierEvenement() {
	}



}
