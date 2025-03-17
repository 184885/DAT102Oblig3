package no.hvl.dat102.O4.uke11;

public class Binaersoker<T> {

	public static <T extends Comparable<T>> boolean binaertSokIterativ(
			T[] tabell, T element) {
		
		int venstre = 0;
		int hoyre = tabell.length - 1;
		
		while (venstre <= hoyre) {
			
			int midtpunkt = (venstre + hoyre)/2;
			int resultat = element.compareTo(tabell[midtpunkt]);
			
			if (resultat == 0) {
				return true;
				
			} else if (resultat < 0) {
				hoyre = midtpunkt - 1;
				
			} else {
				venstre = midtpunkt + 1;
			}
		}
		return false;
	}
}
