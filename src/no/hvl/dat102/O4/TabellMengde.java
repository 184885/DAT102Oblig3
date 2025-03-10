package no.hvl.dat102.O4;

public class TabellMengde<T> implements MengdeADT<T> {

	private T[] tabell;
	private int antall = tabell.length;
	
	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public boolean inneholder(T element) {
		for (int i = 0; i < antall; i++) {
			if (tabell[i].equals(element)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		for (int i = 0; i < antall; i++) {
			if (!annenMengde.inneholder(tabell[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		if (antall != annenMengde.antallElementer()) {
			return false;
		}
		for (int i = 0; i < antall; i++) {
			if (!annenMengde.inneholder(tabell[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		for (int i = 0; i < antall; i++) {
			if (annenMengde.inneholder(tabell[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		MengdeADT<T> snitt = new TabellMengde<T>();
		for (int i = 0; i < antall; i++) {
			if (annenMengde.inneholder(tabell[i])) {
				snitt.leggTil(tabell[i]);
			}
		}
		return snitt;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		MengdeADT<T> union = new TabellMengde<T>();
		for (int i = 0; i < antall; i++) {
			union.leggTil(tabell[i]);
		}
		for (int i = 0; i < annenMengde.antallElementer(); i++) {
			union.leggTil(annenMengde.tilTabell()[i]);
		}
		return union;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		MengdeADT<T> minus = new TabellMengde<T>();
		for (int i = 0; i < antall; i++) {
			if (!annenMengde.inneholder(tabell[i])) {
				minus.leggTil(tabell[i]);
			}
		}
		return minus;
	}

	@Override
	public void leggTil(T element) {
		tabell[antall] = element;
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		for (int i = 0; i < annenMengde.antallElementer(); i++) {
            leggTil(annenMengde.tilTabell()[i]);
		}
	}

	@Override
	public T fjern(T element) {
		for (int i = 0; i < antall; i++) {
            if (tabell[i].equals(element)) {
                T temp = tabell[i];
                tabell[i] = tabell[antall - 1];
                antall--;
                return temp;
            }
        }
        return null;
	}

	@Override
	public T[] tilTabell() {
		return tabell;
	}

	@Override
	public int antallElementer() {
		return antall;
	}

		
}
