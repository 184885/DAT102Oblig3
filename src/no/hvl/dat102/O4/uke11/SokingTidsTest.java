package no.hvl.dat102.O4.uke11;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.time.Duration;
import java.time.Instant;

public class SokingTidsTest {
	static Random rand = new Random();
	public static void main(String[] args) {
		
		// Antall
		int antElement = 1000000;
		
		// Lager en tabell og et sett
		Set<Integer> set = new HashSet<>(antElement);
		Integer[] tabell = new Integer[antElement];
		Integer[] sammenligningsTabell = new Integer[antElement];
		
		// Fyller tabell og sett med tilfeldige tall
		for (int i = 0; i < antElement; i++) {
			tabell[i] = rand.nextInt(100000);
			sammenligningsTabell[i] = tabell[i];
			set.add(tabell[i]);
		}
		
		// Sorterer tabellen
		Arrays.sort(tabell);
		
		// Starter tiden og søker etter et tall i tabell og sett
		Instant start = Instant.now();
		for (int i = 0; i < 10000; i++) {
			Binaersoker.binaertSokIterativ(tabell, sammenligningsTabell[i]);
		}
		Instant stopp = Instant.now();
		System.out.println("Tiden det tar å binærsøke " + 10000 + " elementer i tabell med " + antElement + " elementer:" + Duration.between(start, stopp).toString());
		
		Instant start1 = Instant.now();
		for (int i = 0; i < 10000; i++) {
			set.contains(sammenligningsTabell[i]);
		}
		Instant stopp1 = Instant.now();
		System.out.println("Tiden det tar å søke " + 10000 + " elementer i HashSet på " + antElement + " elementer:" + Duration.between(start1, stopp1).toString());
	}
	
	// Genererer et tilfeldig tall
		private static int tilfeldigtall(int antElement) {
			int tall = rand.nextInt(100000);
	        for (int i = 0; i < antElement; i++) {
	        	tall = (tall + 45713) % 100000;
	        }
	        return tall;
	}
}
