package no.hvl.dat102.O4;

public class JavaSetToMengdeTest extends AbstractMengdeADTTest{

	@Override
	MengdeADT<Integer> opprettNyMengdeOfInteger() {
		return new JavaSetToMengde<Integer>();
	}

	@Override
	MengdeADT<String> opprettNyMengdeOfString() {
		
		return new JavaSetToMengde<String>();
	}

}
