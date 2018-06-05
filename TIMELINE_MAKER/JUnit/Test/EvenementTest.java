/**
 * 
 */
package Test;

import static org.junit.Assert.*;


import org.junit.Test;

import Modele.Date;
import Modele.Evenement;

/**
 * @author maxsv
 *
 */
public class EvenementTest {

	/**
	 * Test method for {@link Modele.Evenement#Evenement(java.lang.String, Modele.Date, java.lang.String, int, java.lang.String)}.
	 */
	@Test
	public void testEvenement() {
		Evenement evt1 = new Evenement("titre", new Date(), "description", 1, "/photo");
		assertNotNull("evt1 crée",evt1);
	}

	/**
	 * Test method for {@link Modele.Evenement#toString()}.
	 */
	@Test
	public void testToString() {
		Evenement evt1 = new Evenement("titre", new Date(), "description", 1, "/photo");
		assertTrue("evt1.toString() = titre",evt1.toString().compareTo("titre")==0);
	}

	/**
	 * Test method for {@link Modele.Evenement#getChTitre()}.
	 */
	@Test
	public void testGetChTitre() {
		Evenement evt1 = new Evenement("titre", new Date(), "description", 1, "/photo");
		assertTrue("titre = titre",evt1.getChTitre().compareTo("titre")==0);
	}

	/**
	 * Test method for {@link Modele.Evenement#getChDate()}.
	 */
	@Test
	public void testGetChDate() {
		Evenement evt1 = new Evenement("titre", new Date(), "description", 1, "/photo");
		assertTrue("Date = date du jour",evt1.getChDate().compareTo(new Date())==0);
	}

	/**
	 * Test method for {@link Modele.Evenement#getChDescription()}.
	 */
	@Test
	public void testGetChDescription() {
		Evenement evt1 = new Evenement("titre", new Date(), "description", 1, "/photo");
		assertTrue("desc = desccription",evt1.getChDescription().compareTo("description")==0);
	}

	/**
	 * Test method for {@link Modele.Evenement#getChPoids()}.
	 */
	@Test
	public void testGetChPoids() {
		Evenement evt1 = new Evenement("titre", new Date(), "description", 1, "/photo");
		assertTrue("poid = 1",evt1.getChPoids()==1);
	}

	/**
	 * Test method for {@link Modele.Evenement#getChPhoto()}.
	 */
	@Test
	public void testGetChPhoto() {
		Evenement evt1 = new Evenement("titre", new Date(), "description", 1, "/photo");
		assertTrue("lien photo = /photo",evt1.getChPhoto().compareTo("/photo")==0);
	}

}
