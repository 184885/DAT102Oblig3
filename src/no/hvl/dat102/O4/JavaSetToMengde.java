package no.hvl.dat102.O4;

import java.util.HashSet;
import java.util.Set;

public class JavaSetToMengde<T> implements MengdeADT<T> {

	private Set<T> set = new HashSet<>();

	
	@Override
	public boolean erTom() {
		return set.isEmpty();
	}

	@Override
	public boolean inneholder(T element) {
		return set.contains(element);
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		for (T element : set) {
			if (!annenMengde.inneholder(element)) {
                return false;
            }
		}
		return true;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		return set.equals(annenMengde);
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		for (T element : (Set<T>) annenMengde) {
			if (inneholder(element)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		MengdeADT<T> snitt = new TabellMengde<T>();
		for (T element : (Set<T>) annenMengde) {
			if (inneholder(element)) {
				snitt.leggTil(element);
			}
		}
		return snitt;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		MengdeADT<T> union = new TabellMengde<T>();
		for (T element : set) {
			union.leggTil(element);
		}
		for (T element : (Set<T>) annenMengde) {
			union.leggTil(element);
		}
		return union;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		MengdeADT<T> minus = new TabellMengde<T>();
        for (T element : set) {
            if (!annenMengde.inneholder(element)) {
                minus.leggTil(element);
            }
        }
        return minus;
	}

	@Override
	public void leggTil(T element) {
		set.add(element);
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		for (T element : (Set<T>) annenMengde) {
			leggTil(element);
		}
	}

	@Override
	public T fjern(T element) {
		set.remove(element);
		return element;
	}

	@Override
	public T[] tilTabell() {
		return (T[]) set.toArray();
	}

	@Override
	public int antallElementer() {
		return set.size();
	}

}
