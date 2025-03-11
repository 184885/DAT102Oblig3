package no.hvl.dat102.O4;

public class HobbyMatchMain {
	public static void main(String args[]) {
		System.out.print(match(new Person("Ola", "Fotball", "Data"), new Person("Kari", "Fotball")));
	}
	
	static double match(Person a, Person b) {
		// match = antallFelles - (antallKunHosA + antallKunHosB)/antallTotalt
		TabellMengde<Integer> felles = new TabellMengde<Integer>();
		TabellMengde<Integer> kunHosA = new TabellMengde<Integer>();
		TabellMengde<Integer> kunHosB = new TabellMengde<Integer>();
		TabellMengde<Integer> totalt = new TabellMengde<Integer>();
		for (int i = 0; i < a.getHobby().antallElementer(); i++) {
			if (b.inneholderHobby(a.getHobby())) {
				felles.leggTil(i);
			} else {
				kunHosA.leggTil(i);
			}
			totalt.leggTil(i);
		}
		
		for (int i = 0; i < b.getHobby().antallElementer(); i++) {
			if (!a.inneholderHobby(b.getHobby())) {
				kunHosB.leggTil(i);
			}
			totalt.leggTil(i);
		}
		
		return felles.antallElementer() - (kunHosA.antallElementer() + kunHosB.antallElementer()) / totalt.antallElementer();
	}
}


