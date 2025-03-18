package no.hvl.dat102.O4;

public class TabellMengdeTest extends AbstractMengdeADTTest {

	@Override
	MengdeADT<Integer> opprettNyMengdeOfInteger() {
		return new TabellMengde<Integer>(3);
	}

	@Override
	MengdeADT<String> opprettNyMengdeOfString() {
		return new TabellMengde<String>();
	}

}
