package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import java.util.ArrayList;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private ArrayList<Attrezzo> attrezzi;
	private int pesoMax;

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
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		attrezzi.add(attrezzo);
		return true;
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		for (Attrezzo att : attrezzi) {
			if(att.getNome().equals(nomeAttrezzo)) {
				return att;
			}
		}
		return null;
	}

	public int getPeso() {
		int peso = 0;
		for (Attrezzo att : attrezzi) {
			peso += att.getPeso();
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
		Attrezzo rimosso = null;
		for (Attrezzo att : attrezzi) {
			if(att.getNome().equals(nomeAttrezzo)) {
				rimosso = att;
				attrezzi.remove(att);
				break;
			}
		}
		return rimosso;
	}
	
	/**
	 * Crea una stringa con il contenuto della borsa e il suo peso
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (Attrezzo att : attrezzi)
				s.append(att.toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}