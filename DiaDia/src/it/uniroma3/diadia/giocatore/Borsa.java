package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	public Borsa() { 
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10];
		this.numeroAttrezzi = 0;
	}
	
	/**
	 * Aggiunge un attrezzo nella borsa
	 * @param attrezzo
	 * @return
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];
		return a;
	}

	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();
		return peso;
	}
	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
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
		int j = 0;
		Attrezzo a = null;
		Attrezzo[] arrayApp = new Attrezzo[10];
		boolean ver = false;
		for (int i = 0; i < attrezzi.length; i++) {
			if (ver == false && attrezzi[i] != null && attrezzi[i].getNome().equals(nomeAttrezzo)) {
				a = attrezzi[i];
				i++;
				ver = true;
				this.numeroAttrezzi--;
			} 
			arrayApp[j] = attrezzi[i];
			j++;
		}
		attrezzi = arrayApp;
		return a;
	}
	
	/**
	 * Crea una stringa con il contenuto della borsa e il suo peso
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i = 0; i < this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}