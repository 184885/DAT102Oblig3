package no.hvl.dat102.O4;

public class LenketMengde<T> implements MengdeADT<T> {

	private class LinearNode {
		private T data;
		private LinearNode neste;

		private LinearNode(T element) {
			this.data = element;
			this.neste = null;
		}
	}

	// Objektvariabler
	private LinearNode forste;
	private int antall;

	// Konstruktør
	public LenketMengde() {
		forste = null;
		antall = 0;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode aktuell = forste;
		boolean funnet = false;
		while (aktuell != null && !funnet) {
			if (aktuell.data.equals(element)) {
				funnet = true;
			}
			aktuell = aktuell.neste;
		}
		return funnet;
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		// Sjekker at mengden ikkje inneholder fleire element enn annenMengde
		if (antall > annenMengde.antallElementer()) {
			return false;
		}
		LinearNode element = forste;
		// Sjekker at alle elementene i mengden finnes i annenMengde
		for (int i = 0; i < antall; i++) {
			if (!annenMengde.inneholder(element.data)) {
				return false;
			}
			element = element.neste;
		}
		return true;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		return (antall == annenMengde.antallElementer() && erDelmengdeAv(annenMengde));
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		LinearNode aktuell = forste;
		boolean disjunkt = true;
		while (aktuell != null && disjunkt) {
			if (annenMengde.inneholder(aktuell.data)) {
				disjunkt = false;
			}
			aktuell = aktuell.neste;
		}
		return disjunkt;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		T[] tab = annenMengde.tilTabell();
		MengdeADT<T> snitt = new LenketMengde<T>();
		for (int i = 0; i < tab.length; i++) {
			if (inneholder(tab[i])) {
				snitt.leggTil(tab[i]);
			}
		}
		return snitt;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		MengdeADT<T> union = new LenketMengde<T>();
		LinearNode aktuell = forste;
		while (aktuell != null) {
			union.leggTil(aktuell.data);
			aktuell = aktuell.neste;
		}
		T[] tab = annenMengde.tilTabell();
		for (int i = 0; i < tab.length; i++) {
			if (!inneholder(tab[i])) {
				union.leggTil(tab[i]);
			}
		}
		return union;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		// Oppretter returtabell
		MengdeADT<T> minus = new LenketMengde<T>();
		LinearNode element = forste;
		for (int i = 0; i < this.antall; i++) {
			// Sjekker at annenMengde ikkje inneholder elementet
			if (!annenMengde.inneholder(element.data)) {
				minus.leggTil(element.data);
			}
			element = element.neste;
		}
		return minus;
	}

	@Override
	public void leggTil(T element) {
		LinearNode nyNode = new LinearNode(element);
		if (!inneholder(element)&&element!=null) {
			nyNode.neste = forste;
			forste = nyNode;
			antall++;
		}
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		T[] tab = annenMengde.tilTabell();
		for (int i = 0; i < annenMengde.antallElementer(); i++) {
			leggTil(tab[i]);
		}
	}

	@Override
	public T fjern(T element) {
		if (erTom()) {
			return null;
		}

		LinearNode aktuell = forste;
		LinearNode forrige = null;
		boolean funnet = false;
		while (aktuell != null && !funnet) {
			if (aktuell.data.equals(element)) {
				funnet = true;
			} else {
				forrige = aktuell;
				aktuell = aktuell.neste;
			}
		}
		if (!funnet) {
			return null;
		}
		if (forrige == null) {
			forste = aktuell.neste;
		} else {
			forrige.neste = aktuell.neste;
		}
		antall--;
		return aktuell.data;
	}

	@Override
	public T[] tilTabell() {
		// Opprette tabell
		@SuppressWarnings("unchecked")
		T[] tab = (T[]) new Object[antall];

		// Overføre data
		LinearNode data = forste;
		for (int i = 0; i < antall; i++) {
			tab[antall - (i + 1)] = data.data; // Legger inn i motsatt rekkefølge
			data = data.neste;
		}
		return tab;
	}

	@Override
	public int antallElementer() {
		return antall;
	}
}
