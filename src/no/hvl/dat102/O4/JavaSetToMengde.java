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
		return (set.size() == annenMengde.antallElementer() && erDelmengdeAv(annenMengde));

	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		for (T t : set) {
			if (annenMengde.inneholder(t)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		MengdeADT<T> snitt = new JavaSetToMengde<T>();
		for (T s : set) {
			if (annenMengde.inneholder(s)) {
				snitt.leggTil(s);
			}
		}
		return snitt;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		MengdeADT<T> union = new JavaSetToMengde<T>();
		union.leggTilAlleFra(this);
		union.leggTilAlleFra(annenMengde);
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
		if (element != null)
			set.add(element);
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		T[] leggTil = annenMengde.tilTabell();
		for (int i = 0; i < annenMengde.antallElementer(); i++) {

			set.add(leggTil[i]);
		}
	}

	@Override
	public T fjern(T element) {
		if (set.contains(element)) {
			set.remove(element);
			return element;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] tilTabell() {
		return (T[]) set.toArray();
	}

	@Override
	public int antallElementer() {
		return set.size();
	}

}
