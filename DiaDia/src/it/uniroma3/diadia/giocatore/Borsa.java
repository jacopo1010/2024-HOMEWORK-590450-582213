package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	private int pesoMax;
	private Iterator<Attrezzo> it;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<Attrezzo>();
	}
	
	/**
	 * Aggiunge un attrezzo nella borsa
	 * @param attrezzo
	 * @return
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax()) {
			return false;
		}
		return attrezzi.add(attrezzo);
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		it = attrezzi.iterator();
		while(it.hasNext()) {
			a = it.next();
			if (a.getNome().equals(nomeAttrezzo)) {
				return a;
			}
		}
		return null;
	}

	public int getPeso() {
		int peso = 0;
		it = attrezzi.iterator();
		while(it.hasNext()) {
			peso += it.next().getPeso();
		}
		return peso;
	}
	
	public boolean isEmpty() {
		return attrezzi.isEmpty();
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	 /**
	  * Prende il nome dell'attrezzo che si vuole rimuovere e elimina il primo trovato
	  * @param nomeAttrezzo
	  * @return Attrezzo rimosso
	  */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		it = attrezzi.iterator();
		while(it.hasNext()) {
			a = it.next();
			if (a.getNome().equals(nomeAttrezzo)) {
				attrezzi.remove(a);
				return a;
			}
		}
		return null;
	}
	
	/**
	 * Crea una stringa con il contenuto della borsa e il suo peso
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (this.isEmpty()) {
			s.append("Borsa vuota");
		}
		else {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			attrezzi.forEach((a) -> s.append(a.toString()+" "));
		}
		return s.toString();
	}
	
	/**
	 * Restituisce la lista degli attrezzi nella borsa ordinati per peso e quindi, a parità di peso, per nome
	 */
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> sorted = attrezzi;
		sorted.sort((o1, o2) -> o1.getPeso() - o2.getPeso());
		return sorted;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		Comparator<Attrezzo> comparatorePerNome = Comparator.comparing(Attrezzo::getNome);  //Comparatore che serve al SortedSet per ordinare per nome
		SortedSet<Attrezzo> sorted = new TreeSet<>(comparatorePerNome);
        sorted.addAll(attrezzi);
		return sorted;
	}
}