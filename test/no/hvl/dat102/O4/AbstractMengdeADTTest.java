package no.hvl.dat102.O4;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class AbstractMengdeADTTest {

	private MengdeADT<Integer> tomMengde;
	private MengdeADT<String> tomMengdeString;
	private MengdeADT<String> mengdeMedEttElement;
	private MengdeADT<String> mengdeMedToElement;	
	private MengdeADT<Integer> mengdeMed3Elementer;
	private MengdeADT<Integer> mengdeLik3Elementer;
	private MengdeADT<Integer> mengdeMed4Elementer;
	private MengdeADT<Integer> mengdeMedPartal;
	private MengdeADT<Integer> mengdeMedOddetal;
	private MengdeADT<Integer> union3og4;
	private MengdeADT<Integer> unionParogOdd;
	private MengdeADT<Integer> snitt3ogOdd;
	private MengdeADT<Integer> snittParogUnion;	
	private MengdeADT<Integer> snittOddogUnion;		
	
	abstract MengdeADT<Integer> opprettNyMengdeOfInteger();

	abstract MengdeADT<String> opprettNyMengdeOfString();

	@BeforeEach
	void nullstill() {

		tomMengde = opprettNyMengdeOfInteger();
		tomMengdeString = opprettNyMengdeOfString();

		mengdeMedEttElement = opprettNyMengdeOfString();
		mengdeMedEttElement.leggTil("Atle");
		
		mengdeMedToElement = opprettNyMengdeOfString();
		mengdeMedToElement.leggTil("Atle");
		mengdeMedToElement.leggTil("Per");	

		mengdeMed3Elementer = opprettNyMengdeOfInteger();
		mengdeMed3Elementer.leggTil(1);
		mengdeMed3Elementer.leggTil(2);
		mengdeMed3Elementer.leggTil(3);
		
		mengdeLik3Elementer = opprettNyMengdeOfInteger();
		mengdeLik3Elementer.leggTil(2);
		mengdeLik3Elementer.leggTil(1);
		mengdeLik3Elementer.leggTil(3);

		mengdeMed4Elementer = opprettNyMengdeOfInteger();
		mengdeMed4Elementer.leggTil(4);
		mengdeMed4Elementer.leggTil(5);
		mengdeMed4Elementer.leggTil(6);
		mengdeMed4Elementer.leggTil(7);
		
		mengdeMedPartal = opprettNyMengdeOfInteger();
		mengdeMedPartal.leggTil(0);
		mengdeMedPartal.leggTil(2);
		mengdeMedPartal.leggTil(4);
		mengdeMedPartal.leggTil(6);
		mengdeMedPartal.leggTil(8);

		mengdeMedOddetal = opprettNyMengdeOfInteger();
		mengdeMedOddetal.leggTil(1);
		mengdeMedOddetal.leggTil(3);
		mengdeMedOddetal.leggTil(5);
		mengdeMedOddetal.leggTil(7);
		mengdeMedOddetal.leggTil(9);
		
		union3og4 = opprettNyMengdeOfInteger();
		union3og4.leggTil(1);
		union3og4.leggTil(2);
		union3og4.leggTil(3);
		union3og4.leggTil(4);
		union3og4.leggTil(5);
		union3og4.leggTil(6);
		union3og4.leggTil(7);
				
		unionParogOdd = opprettNyMengdeOfInteger();
		unionParogOdd.leggTil(0);
		unionParogOdd.leggTil(1);
		unionParogOdd.leggTil(2);
		unionParogOdd.leggTil(3);
		unionParogOdd.leggTil(4);
		unionParogOdd.leggTil(5);
		unionParogOdd.leggTil(6);
		unionParogOdd.leggTil(7);
		unionParogOdd.leggTil(8);
		unionParogOdd.leggTil(9);
		
		snitt3ogOdd = opprettNyMengdeOfInteger();
		snitt3ogOdd.leggTil(1);
		snitt3ogOdd.leggTil(3);
		
		snittParogUnion = opprettNyMengdeOfInteger();
		snittParogUnion.leggTil(2);
		snittParogUnion.leggTil(4);
		snittParogUnion.leggTil(6);
		
		snittOddogUnion = opprettNyMengdeOfInteger();
		snittOddogUnion.leggTil(1);
		snittOddogUnion.leggTil(3);
		snittOddogUnion.leggTil(5);
		snittOddogUnion.leggTil(7);
	}

	/*
	 * Ting å teste (vi har konstruktører, erTom, inneholder, erDelMengdeAv, erLik,
	 * erDisjunkt, snitt, union, minus, leggTil, leggTilAlleFra, fjern, tilTabell,
	 * antallElementer):
	 	* 
	 	* En ny mengde skal vere tom
	 	* En mengde med ett eller fleire element(er) skal ikkje vere tom
	 	* leggTil skal legge til element i mengden dersom det ikkje eksisterer frå før
	 	* leggTilAlleFra skal legge til alle elementer som ikkje eksisterer i mengden frå før	
	 	* fjern skal fjerne element fra mengden.
	 	* tilTabell skal returnere tabellen til mengden.
	 	* antallElementer skal returnere antall elementer i mengden.
	 	* inneholder skal vere sann dersom elementet finnes i mengden og usann ellers
	 	* erDelMengdeAv skal vere sann dersom mengden er ein delmengde av annenMengde og usann ellers
	 	* erLik skal vere sann dersom mengden er lik annenMengde (altså alle elementene i mengden er like) og usann ellers
	 	* erDisjukt skal vere sann dersom alle elementene i mengden ikkje finnes i annenMengde og usann ellers
	 	* snitt skal gi ein ny mengde med snittet av mengden og annenMengde (altså alle elementene som er felles, dersom det ikkje er felles element skal mengden vere tom)
	 	* union skal gi ein ny mengde med unionen av mengden og annenMengde (altså alle elementene i begge mengdene)
	 	* minus skal gi ein ny mengde med differansen til mengden og annenMengde (altså alle elementer som finnes i mengden og ikkje i annenMengde)
	 */
	
	@Test
	void enNyMengdeSkalVereTom() {
		assertTrue(tomMengde.erTom());
		assertTrue(tomMengdeString.erTom());
		assertEquals(0,tomMengde.antallElementer());
		assertFalse(tomMengde.inneholder(null));
	}
	
	@Test
	void enMengdeMedEttEllerFlereElementerSkalIkkeVaereTom() {
		assertFalse(mengdeMedEttElement.erTom());
		assertFalse(mengdeMed3Elementer.erTom());
		assertFalse(mengdeMed3Elementer.inneholder(null));
	}
	
	@Test
	void innholderTest() {
		assertFalse(tomMengde.inneholder(5));
		
		assertTrue(mengdeMedEttElement.inneholder("Atle"));
		assertFalse(mengdeMedEttElement.inneholder("Per"));
		
		assertTrue(mengdeMed3Elementer.inneholder(2));
		assertFalse(mengdeMed3Elementer.inneholder(0));	
	}
	
	@Test 
	void antallElementerTest() {
		assertEquals(0, tomMengde.antallElementer());
		assertEquals(1, mengdeMedEttElement.antallElementer());
		assertEquals(3, mengdeMed3Elementer.antallElementer());
		assertEquals(4, mengdeMed4Elementer.antallElementer());
		assertEquals(5, mengdeMedPartal.antallElementer());
		assertEquals(7, union3og4.antallElementer());
	}
	
	@Test
	void tilTabell() {
		assertNotNull(mengdeMed3Elementer.tilTabell());
//		Integer[] tab = mengdeMed3Elementer.tilTabell());
		Object[] tab = mengdeMed3Elementer.tilTabell(); // Tabellen må være Object, får ClassCastExeption om eg prøver å sette den som integer
		assertEquals(1,tab[0]);
		assertEquals(2,tab[1]);
		assertEquals(3,tab[2]);
		assertEquals(3,tab.length);
	}
	
	@Test
	void leggTilTest() {
		tomMengde.leggTil(1);
		assertFalse(tomMengde.erTom());
		assertTrue(tomMengde.inneholder(1));
		assertEquals(1,tomMengde.antallElementer());
		
		//Sjekker at element ikkje blir lagt til meir enn ein gong
		tomMengde.leggTil(1);
		assertEquals(1,tomMengde.antallElementer());
	}
	@Test
	void leggTilStringTest() {
		tomMengdeString.leggTil("Per");
		assertTrue(tomMengdeString.inneholder("Per"));
		assertEquals(1,tomMengdeString.antallElementer());
		
		tomMengdeString.leggTil("Per");
		assertEquals(1,tomMengdeString.antallElementer());
	}
	
	@Test
	void leggTilAlleFraTest() {
		tomMengde.leggTilAlleFra(mengdeMed3Elementer);
		assertFalse(tomMengde.erTom());
		assertTrue(tomMengde.inneholder(1));
		assertTrue(tomMengde.inneholder(2));
		assertTrue(tomMengde.inneholder(3));
		assertEquals(3,tomMengde.antallElementer());
		
		tomMengde.leggTilAlleFra(mengdeMedPartal);
		assertTrue(tomMengde.inneholder(0));
		assertTrue(tomMengde.inneholder(4));
		assertTrue(tomMengde.inneholder(6));
		assertTrue(tomMengde.inneholder(8));
		assertEquals(7,tomMengde.antallElementer());
		}
	@Test
	void leggTilAlleFraStringTest() {
		tomMengdeString.leggTilAlleFra(mengdeMedEttElement);
		assertTrue(tomMengdeString.inneholder("Atle"));
		assertEquals(1,tomMengdeString.antallElementer());
		
		tomMengdeString.leggTilAlleFra(mengdeMedToElement);
		assertTrue(tomMengdeString.inneholder("Per"));
		assertEquals(2,tomMengdeString.antallElementer());
	}
	
	@Test
	void fjernTest() {
		// Antall skal ikkje endres dersom elementet ikkje eksisterer i mengda
		assertNull(mengdeMed3Elementer.fjern(4));		
		assertEquals(3,mengdeMed3Elementer.antallElementer());
		
		assertEquals(1,mengdeMed3Elementer.fjern(1));
		assertEquals(2,mengdeMed3Elementer.antallElementer());
		assertFalse(mengdeMed3Elementer.inneholder(1));
		assertTrue(mengdeMed3Elementer.inneholder(2));
		assertTrue(mengdeMed3Elementer.inneholder(3));
		
		assertEquals(3,mengdeMed3Elementer.fjern(3));
		assertEquals(2,mengdeMed3Elementer.fjern(2));
		
		assertFalse(mengdeMed3Elementer.inneholder(2));
		assertFalse(mengdeMed3Elementer.inneholder(3));
		assertTrue(mengdeMed3Elementer.erTom());
		
		assertNull(tomMengde.fjern(1));
		assertEquals(0,tomMengde.antallElementer());
		assertTrue(tomMengde.erTom());
	}
	@Test
	void fjernStringTest() {
		mengdeMedToElement.fjern("Pål");
		assertEquals(2,mengdeMedToElement.antallElementer());
		
		mengdeMedToElement.fjern("Per");
		assertFalse(mengdeMedToElement.inneholder("Per"));
		assertTrue(mengdeMedToElement.inneholder("Atle"));
	}
	
	@Test
	void erDelMengdeAvTest() {
		assertTrue(tomMengde.erDelmengdeAv(mengdeMed3Elementer));
		assertTrue(mengdeMed3Elementer.erDelmengdeAv(union3og4));
		assertTrue(mengdeLik3Elementer.erDelmengdeAv(union3og4));
		assertFalse(mengdeMed3Elementer.erDelmengdeAv(mengdeMed4Elementer));
		assertFalse(mengdeMed3Elementer.erDelmengdeAv(tomMengde));
		assertFalse(mengdeMed3Elementer.erDelmengdeAv(mengdeMedOddetal));	
		assertFalse(union3og4.erDelmengdeAv(mengdeMed3Elementer));	
	}
	@Test
	void erDelMengdeAvStringTest() {
		assertTrue(tomMengdeString.erDelmengdeAv(mengdeMedEttElement));
		assertTrue(mengdeMedEttElement.erDelmengdeAv(mengdeMedToElement));
		assertFalse(mengdeMedToElement.erDelmengdeAv(mengdeMedEttElement));
	}
	
	@Test
	void erLikTest() {
		assertTrue(mengdeMed3Elementer.erLik(mengdeLik3Elementer));
		assertFalse(mengdeMed3Elementer.erLik(mengdeMed4Elementer));
		assertFalse(mengdeMedOddetal.erLik(mengdeMedPartal));
		assertFalse(union3og4.erLik(mengdeMed3Elementer));
		assertFalse(tomMengde.erLik(mengdeMed3Elementer));
		
		tomMengde.leggTilAlleFra(mengdeMed3Elementer);
		assertTrue(mengdeMed3Elementer.erLik(tomMengde));
		
		mengdeMedOddetal.fjern(9);
		assertTrue(mengdeMedOddetal.erLik(snittOddogUnion));
	}
	@Test
	void erLikStringTest() {
		tomMengdeString.leggTil("Atle");
		assertTrue(mengdeMedEttElement.erLik(tomMengdeString));
		assertFalse(mengdeMedToElement.erLik(mengdeMedEttElement));
	}
	
	@Test
	void erDisjuktTest() {
		assertTrue(tomMengde.erDisjunkt(mengdeMed3Elementer));
		assertTrue(mengdeMed3Elementer.erDisjunkt(mengdeMed4Elementer));
		assertTrue(mengdeMedPartal.erDisjunkt(mengdeMedOddetal));
		assertFalse(mengdeMed3Elementer.erDisjunkt(mengdeLik3Elementer));
		assertFalse(mengdeMed3Elementer.erDisjunkt(mengdeMedPartal));
		assertFalse(mengdeMed3Elementer.erDisjunkt(mengdeMedOddetal));
		assertFalse(mengdeMed3Elementer.erDisjunkt(union3og4));
		
		mengdeMed3Elementer.fjern(2);
		assertTrue(mengdeMed3Elementer.erDisjunkt(mengdeMedPartal));
	}
	@Test
	void erDisjuktStringTest() {
		assertTrue(tomMengdeString.erDisjunkt(mengdeMedToElement));
		assertFalse(mengdeMedEttElement.erDisjunkt(mengdeMedToElement));
	}
	
	@Test
	void snittTest() {
		assertNotNull(mengdeMed3Elementer.snitt(mengdeLik3Elementer));
		assertNotNull(tomMengde.snitt(tomMengde));
		
		assertTrue(mengdeMed3Elementer.snitt(mengdeLik3Elementer).erLik(mengdeMed3Elementer));
		assertTrue(mengdeMed3Elementer.snitt(mengdeMed4Elementer).erLik(tomMengde));	
		assertTrue(mengdeMedPartal.snitt(mengdeMedOddetal).erLik(tomMengde));
		
		assertTrue(mengdeMed3Elementer.snitt(mengdeMedOddetal).erLik(snitt3ogOdd));
		assertTrue(mengdeMedOddetal.snitt(mengdeMed3Elementer).erLik(snitt3ogOdd));
		assertTrue(mengdeMedPartal.snitt(union3og4).erLik(snittParogUnion));
		assertTrue(union3og4.snitt(mengdeMedPartal).erLik(snittParogUnion));
		assertTrue(mengdeMedOddetal.snitt(union3og4).erLik(snittOddogUnion));	
		assertTrue(union3og4.snitt(mengdeMedOddetal).erLik(snittOddogUnion));	
		
		mengdeMed4Elementer.leggTil(2);
		assertTrue(mengdeMed4Elementer.snitt(mengdeMedPartal).erLik(snittParogUnion));
	}
	@Test
	void snittStringTest() {
		assertNotNull(tomMengdeString.snitt(mengdeMedToElement));
		assertTrue(mengdeMedToElement.snitt(mengdeMedEttElement).erLik(mengdeMedEttElement));
		assertTrue(tomMengdeString.snitt(mengdeMedToElement).erLik(tomMengdeString));	
	}
	
	@Test
	void unionTest() {
		assertNotNull(mengdeMed3Elementer.union(mengdeLik3Elementer));
		assertNotNull(tomMengde.union(tomMengde));
		
		assertTrue(mengdeMed3Elementer.union(mengdeLik3Elementer).erLik(mengdeMed3Elementer));
		assertTrue(mengdeMed3Elementer.union(mengdeMed4Elementer).erLik(union3og4));	
		assertTrue(mengdeMedPartal.union(tomMengde).erLik(mengdeMedPartal));
		assertTrue(mengdeMedPartal.union(mengdeMedOddetal).erLik(unionParogOdd));
		assertTrue(mengdeMedOddetal.union(mengdeMedPartal).erLik(unionParogOdd));		
	}
	
	@Test 
	void minusTest() {
		assertNotNull(mengdeMed3Elementer.minus(mengdeMed4Elementer));
		assertNotNull(mengdeMed3Elementer.minus(mengdeLik3Elementer));
		assertNotNull(tomMengde.minus(tomMengde));
		assertNotNull(tomMengde.minus(mengdeMed3Elementer));
		
		assertTrue(mengdeMed3Elementer.minus(mengdeLik3Elementer).erLik(tomMengde));
		assertTrue(mengdeMed3Elementer.minus(mengdeMed4Elementer).erLik(mengdeMed3Elementer));
		assertTrue(mengdeMed3Elementer.minus(mengdeMedPartal).erLik(snitt3ogOdd));
		
	}
	
	
	
}
