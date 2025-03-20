package no.hvl.dat102.O4.uke11;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Oppgave4 {
	public static void main(String args[]) {

		int antElement = 100000; // antall elementer
		int omraade = 1000000; // verdiområde
		int tall = 376; // Tilfeldig starttal
		
		// Oppretter tabell og hashSet
		Integer[] intTab = new Integer[antElement];
		Set<Integer> hashSet = new HashSet<>(antElement);

		// Setter inn tal i tabell og hashSet
		for (int i = 0; i < antElement; i++) {
			intTab[i] = tall;
			hashSet.add(tall);

			//Endrer tal
			tall = (tall + 45713) % omraade;
		}
		
		// Sorterer tabell
		Arrays.sort(intTab);

		// Genererer tilfeldige tal
		Integer[] tilfeldig = genererTabell(omraade, 10000);
		int funnetSet = 0;
		int funnetTab = 0;

		// Tar tid på HashSet søking
		Instant start = Instant.now();
		for (int i : tilfeldig) {
			if (hashSet.contains(i)) {
				funnetSet++;
			}
		}
		Instant slutt = Instant.now();
		Duration tidSet = Duration.between(start, slutt);

		// Tar tid på binærsøking
		start = Instant.now();
		for (int i : tilfeldig) {
			if (Arrays.binarySearch(intTab, i) >= 0) {
				funnetTab++;
			}
		}
		slutt = Instant.now();
		Duration tidTab = Duration.between(start, slutt);

		skrivUtResultater(tidSet,funnetSet,"HashSet søking");
		skrivUtResultater(tidTab,funnetTab,"Binærsøking");
		
	}

	private static Integer[] genererTabell(int omrade, int antall) {
		Integer[] tab = new Integer[antall];
		Random tilfeldig = new Random();
		for (int i = 0; i < antall; i++) {
			int tall = tilfeldig.nextInt(omrade);
			tab[i] = tall;
		}
		return tab;
	}

	private static void skrivUtResultater(Duration tid, int funnet, String type) {
		System.out.println(type + " brukte " + tid + " på å finne " + funnet + " tilfeldige tal.");
	}

}
