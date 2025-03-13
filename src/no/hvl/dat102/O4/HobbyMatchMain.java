package no.hvl.dat102.O4;

public class HobbyMatchMain {
	public static void main(String args[]) {
		System.out.println("Match Ola med Kari:" + match(new Person("Ola", "Fotball", "Data"), new Person("Kari", "Fotball")));
		System.out.println("Match Kari med Ola:" + match(new Person("Kari", "Fotball"), new Person("Ola", "Fotball", "Data")));
		System.out.println("Match Ola med Ola:" + match(new Person("Ola", "Fotball", "Data"), new Person("Ola", "Fotball", "Data")));
		System.out.println("Match Kari med Kari:" + match(new Person("Kari", "Fotball"), new Person("Kari", "Fotball")));
	}
	
	static double match(Person a, Person b) {
		// match = antallFelles - (antallKunHosA + antallKunHosB)/antallTotalt
//		TabellMengde<Integer> felles = new TabellMengde<Integer>();
//		TabellMengde<Integer> kunHosA = new TabellMengde<Integer>();
//		TabellMengde<Integer> kunHosB = new TabellMengde<Integer>();
//		TabellMengde<Integer> totalt = new TabellMengde<Integer>();
//		
//		//Legger til hobbyene til a
//		for (int i = 0; i < a.getHobby().antallElementer(); i++) {
//			if (b.inneholderHobby(a.getHobby())) {
//				felles.leggTil(i);
//			} else {
//				kunHosA.leggTil(i);
//			}
//			totalt.leggTil(i);
//		}
//		
//		//Legger til hobbyene til b
//		for (int i = 0; i < b.getHobby().antallElementer(); i++) {
//			if (!a.inneholderHobby(b.getHobby())) {
//				kunHosB.leggTil(i);
//			}
//			totalt.leggTil(i);
//		}
//		
//		return felles.antallElementer() - (kunHosA.antallElementer() + kunHosB.antallElementer()) / totalt.antallElementer();
//	}
		int antallFelles = 0;
		int antallKunHosA = 0;
		int antallKunHosB = 0;
		int antallTotalt = 0;
		
		for (int i = 0; i < a.getHobby().antallElementer(); i++) {
			if (b.getHobby().inneholder(a.hentElement(i))) {
				antallFelles++;
			} else {
				antallKunHosA++;
			}
			antallTotalt++;
		}
		
		for (int i = 0; i < b.getHobby().antallElementer(); i++) {
			if (!a.getHobby().inneholder(b.hentElement(i))) {
				antallKunHosB++;
			}
			antallTotalt++;
		}
		
		return antallFelles - (antallKunHosA + antallKunHosB) / antallTotalt;
	}
		
}


