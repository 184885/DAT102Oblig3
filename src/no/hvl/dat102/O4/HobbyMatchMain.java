package no.hvl.dat102.O4;

public class HobbyMatchMain {
	public static void main(String args[]) {
		Person arne = new Person("Arne", "jakt", "sykling", "venner", "data");
		Person per = new Person("Per", "venner", "sjakk", "data");
		Person paal = new Person("Pål", "data", "lese", "sport");
//		Person paal = new Person("Pål");
		
		double matchArneOgPer = match(arne, per);
		double matchPerOgArne = match(per, arne);
		double matchArneOgPaal = match(arne, paal);
		double matchPerOgPaal = match(per, paal);
		
		System.out.println("Match mellom "+ arne.getNavn() + " og " + per.getNavn() + " er "  + matchArneOgPer);
		System.out.println("Match mellom "+ per.getNavn() + " og " + arne.getNavn() + " er "  + matchPerOgArne);
		System.out.println("Match mellom " + arne.getNavn() + " og " + paal.getNavn() + " er " + matchArneOgPaal);
		System.out.println("Match mellom " + per.getNavn()+ " og " + paal.getNavn() + " er " + matchPerOgPaal);
	}

	public static double match(Person a, Person b) {
		MengdeADT<String> snittAogB = a.getHobby().snitt(b.getHobby());
		double antallFelles = snittAogB.antallElementer();
		double antallKunHosDenEne = a.getHobby().minus(b.getHobby()).antallElementer();
		double antallKunHosDenAndre = b.getHobby().minus(a.getHobby()).antallElementer();
		double antallTotalt = a.getHobby().union(b.getHobby()).antallElementer();
		double match = antallFelles - (antallKunHosDenEne + antallKunHosDenAndre) / antallTotalt;
		return match;
	}
}
