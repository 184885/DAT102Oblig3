package no.hvl.dat102.O4;

import java.util.Objects;

public class Person {

	private String navn;
	private MengdeADT<String> hobby = new TabellMengde<String>();
	
	public Person(String navn, String ... hobbyer) {
		this.navn = navn;
		for (String s : hobbyer) {
			hobby.leggTil(s);
		}
	}
	
	public String getNavn() {
		return navn;
	}
	
	public MengdeADT<String> getHobby() {
		return hobby;
	}
	
	public boolean inneholderHobby(String hobby) {
		for (int i = 0; i < this.hobby.antallElementer(); i++) {
			if (this.hobby.equals(hobby)) {
				return true;
			}
		}
		return false;
	}
	
}
