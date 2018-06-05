/**
 * 
 */
package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Modele.Date;
import Modele.ExceptionDate;

/**
 * @author maxsv
 * classe de test de la classe Date
 */
public class DateTest {

	/**
	 * Test method for {@link Modele.Date#Date()}.
	 */
	@Test
	public void testDate() {
	@SuppressWarnings("unused")
	Date d1 = new Date();
	}

	/**
	 * Test method for {@link Modele.Date#Date(int, int, int)}.
	 * @throws ExceptionDate 
	 */
	@Test
	public void testDateIntIntInt() {
		Date d1 = null;
		Date d2 = null;
		Date d3 = null;
		Date d4 = null;
		
		try {
			d1 = new Date(1,1,1);

		} catch (ExceptionDate e) {}
		
		assertNotNull("la date 1/1/1 existe", d1);
		
		try {
			d2 = new Date(50,1,1);
		} catch (ExceptionDate e) {}
		
		assertNull("la date 50/1/1 n'existe pas", d2);
		
		try {
			d3 = new Date(1,50,1);
		} catch (ExceptionDate e) {}
		assertNull("la date 1/50/1 n'existe pas", d3);
		
		try {
			d4 = new Date(1,1,20000);
		} catch (ExceptionDate e) {}
		assertNull("la date 1/1/20000 n'existe pas", d4);
		
	}

	/**
	 * Test method for {@link Modele.Date#toString()}.
	 * @throws ExceptionDate 
	 */
	@Test
	public void testToString() throws ExceptionDate {
		Date d1 = new Date(01,12,1999);
		System.out.println(d1.toString());
	}

	/**
	 * Test method for {@link Modele.Date#getAnnee()}.
	 * @throws ExceptionDate 
	 */
	@Test
	public void testGetAnnee() throws ExceptionDate {
		Date d1 = new Date(01,12,1999);
		assertTrue("année = 1999",d1.getAnnee()==1999);
	}

	/**
	 * Test method for {@link Modele.Date#getJour()}.
	 * @throws ExceptionDate 
	 */
	@Test
	public void testGetJour() throws ExceptionDate {
		Date d1 = new Date(01,12,1999);
		assertTrue("jour = 1",d1.getJour()==1);
	}

	/**
	 * Test method for {@link Modele.Date#getMois()}.
	 * @throws ExceptionDate 
	 */
	@Test
	public void testGetMois() throws ExceptionDate {
		Date d1 = new Date(01,12,1999);
		assertTrue("Mois = 12",d1.getMois()==12);
	}

	/**
	 * Test method for {@link Modele.Date#getJourSemaine()}.
	 * @throws ExceptionDate 
	 */
	@Test
	public void testGetJourSemaine() throws ExceptionDate {
		Date d1 = new Date(01,12,1999);
		//mercredi == 4 
		assertTrue("JourSemaine = 4",d1.getJourSemaine()==4);
	}

	/**
	 * Test method for {@link Modele.Date#dernierJourDuMois(int, int)}.
	 * @throws ExceptionDate 
	 */
	@Test
	public void testDernierJourDuMois() throws ExceptionDate {
		Date d1 = new Date(01,12,1999);
		Date d2 = new Date(01,2,1999);
		Date d3 = new Date(01,2,2000);

		
		assertTrue( "Dernier jour de decembre = 31",Date.dernierJourDuMois(d1.getMois(), d1.getAnnee()) == 31);
		assertTrue( "Dernier jour de fevrier = 28 en 1999",Date.dernierJourDuMois(d2.getMois(), d2.getAnnee())== 28);
		assertTrue( "Dernier jour de fevrier = 29 en 2000",Date.dernierJourDuMois(d3.getMois(), d3.getAnnee())== 29);

	}

	/**
	 * Test method for {@link Modele.Date#compareTo(Modele.Date)}.
	 * @throws ExceptionDate 
	 */
	@Test
	public void testCompareTo() throws ExceptionDate {
		Date d1 = new Date(01,12,1999);
		Date d12 = new Date(01,12,1999);
		
		Date d2 = new Date(01,2,1998);
		
		
		assertTrue("1/12/1999 == 1/12/1999",d1.compareTo(d12) ==0);
		assertTrue("1/12/1998 compare to  1/12/1999 = -X",d2.compareTo(d12) < 0);
		assertTrue("1/12/1999 compare to  1/12/1998 = +X",d12.compareTo(d2) > 0);

	}

}
