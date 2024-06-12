package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Giocatore {
	private int cfu;
	static final private int CFU_INIZIALI = 20;
	private Borsa borsa;
	
	public Giocatore() {
	  this.cfu = CFU_INIZIALI;
	  this.borsa = new Borsa();
	}
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;	
	}

	public Borsa getBorsa() {
		return borsa;
	}
	
	public void aggiungiInBorsa(Attrezzo attr) {
		 this.borsa.addAttrezzo(attr);
	}

	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}
	
}
