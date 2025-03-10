package no.hvl.dat102.O4;

public class LenketMengde<T> implements MengdeADT<T> {

	private class LinearNode<T> {
		private T data;
		private LinearNode<T> neste;

		public LinearNode(T element) {
			this.data = element;
			neste = null;
		}
	}
	private LinearNode<T> forste;
	private int antall;
	
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
		LinearNode<T> aktuell = forste;
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
		LinearNode<T> aktuell = forste;
		boolean delmengde = false;
		while (aktuell != null && delmengde) {
			if (annenMengde.inneholder(aktuell.data)) {
				delmengde = true;
			}
			aktuell = aktuell.neste;
		}
		return delmengde;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		LinearNode<T> aktuell = forste;
		while (aktuell != null) {
			if (!annenMengde.inneholder(aktuell.data)) {
				return false;
			}
			aktuell = aktuell.neste;
		}
		return true;
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		LinearNode<T> aktuell = forste;
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
        LinearNode<T> aktuell = forste;
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
		T[] tab = annenMengde.tilTabell();
		MengdeADT<T> nyMengde = new LenketMengde<T>();
		for (int i = 0; i < tab.length; i++) {
			if (!inneholder(tab[i])) {
				nyMengde.leggTil(tab[i]);
			}
		}
		return nyMengde;
	}

	@Override
	public void leggTil(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		nyNode.neste = forste;
		forste = nyNode;
		antall++;
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		T[] tab = annenMengde.tilTabell();
		for (int i = 0; i < tab.length; i++) {
			leggTil(tab[i]);
		}
	}

	@Override
	public T fjern(T element) {
		if (erTom()) {
			return null;
		}
		
		LinearNode<T> aktuell = forste;
		LinearNode<T> forrige = null;
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
		T[] tab = (T[]) new Object[antall];
		LinearNode<T> aktuell = forste;
		int i = 0;
		while (aktuell != null) {
			tab[i] = aktuell.data;
			aktuell = aktuell.neste;
			i++;
		}
		return tab;
	}

	@Override
	public int antallElementer() {
		return antall;
	}
}
