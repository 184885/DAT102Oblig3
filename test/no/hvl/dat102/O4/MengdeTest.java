package no.hvl.dat102.O4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MengdeTest  {	
	private MengdeADT<Integer> tomMengde;
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

	@BeforeEach
	void nullstill() {
		tomMengde = new JavaSetToMengde<>();
		
		mengdeMed3Elementer = new TabellMengde<>();
		mengdeMed3Elementer.leggTil(1);
		mengdeMed3Elementer.leggTil(2);
		mengdeMed3Elementer.leggTil(3);
		
		mengdeLik3Elementer = new LenketMengde<>();
		mengdeLik3Elementer.leggTil(2);
		mengdeLik3Elementer.leggTil(1);
		mengdeLik3Elementer.leggTil(3);

		mengdeMed4Elementer = new JavaSetToMengde<>();
		mengdeMed4Elementer.leggTil(4);
		mengdeMed4Elementer.leggTil(5);
		mengdeMed4Elementer.leggTil(6);
		mengdeMed4Elementer.leggTil(7);
		
		mengdeMedPartal = new TabellMengde<>();
		mengdeMedPartal.leggTil(0);
		mengdeMedPartal.leggTil(2);
		mengdeMedPartal.leggTil(4);
		mengdeMedPartal.leggTil(6);
		mengdeMedPartal.leggTil(8);

		mengdeMedOddetal = new LenketMengde<>();
		mengdeMedOddetal.leggTil(1);
		mengdeMedOddetal.leggTil(3);
		mengdeMedOddetal.leggTil(5);
		mengdeMedOddetal.leggTil(7);
		mengdeMedOddetal.leggTil(9);
		
		union3og4 = new JavaSetToMengde<>();
		union3og4.leggTil(1);
		union3og4.leggTil(2);
		union3og4.leggTil(3);
		union3og4.leggTil(4);
		union3og4.leggTil(5);
		union3og4.leggTil(6);
		union3og4.leggTil(7);
				
		unionParogOdd = new TabellMengde<>();
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

		snitt3ogOdd = new LenketMengde<>();
		snitt3ogOdd.leggTil(1);
		snitt3ogOdd.leggTil(3);
		
		snittParogUnion = new JavaSetToMengde<>();
		snittParogUnion.leggTil(2);
		snittParogUnion.leggTil(4);
		snittParogUnion.leggTil(6);
		
		snittOddogUnion = new TabellMengde<>();
		snittOddogUnion.leggTil(1);
		snittOddogUnion.leggTil(3);
		snittOddogUnion.leggTil(5);
		snittOddogUnion.leggTil(7);

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
	void erLikTest() {
		assertTrue(mengdeMed3Elementer.erLik(mengdeLik3Elementer));
		assertFalse(mengdeMed3Elementer.erLik(mengdeMed4Elementer));
		assertFalse(mengdeMed3Elementer.erLik(mengdeMedPartal));
		assertFalse(mengdeMed3Elementer.erLik(union3og4));
		assertFalse(tomMengde.erLik(mengdeMed3Elementer));
		
		tomMengde.leggTilAlleFra(mengdeMed3Elementer);
		assertTrue(mengdeMed3Elementer.erLik(tomMengde));
		
		mengdeMedOddetal.fjern(9);
		assertTrue(mengdeMedOddetal.erLik(snittOddogUnion));
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
