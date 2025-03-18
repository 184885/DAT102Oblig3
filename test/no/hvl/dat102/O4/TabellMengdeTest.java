package no.hvl.dat102.O4;

public class TabellMengdeTest extends AbstractMengdeADTTest {

	@Override
	MengdeADT<Integer> opprettNyMengdeOfInteger() {
		return new TabellMengde<Integer>();
	}

	@Override
	MengdeADT<String> opprettNyMengdeOfString() {
		return new TabellMengde<String>();
	}

}
