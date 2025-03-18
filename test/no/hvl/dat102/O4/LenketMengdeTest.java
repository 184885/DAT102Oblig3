package no.hvl.dat102.O4;

public class LenketMengdeTest extends AbstractMengdeADTTest {

	@Override
	MengdeADT<Integer> opprettNyMengdeOfInteger() {
		
		return new LenketMengde<Integer>();
	}

	@Override
	MengdeADT<String> opprettNyMengdeOfString() {
		return new LenketMengde<String>();
	}


}
