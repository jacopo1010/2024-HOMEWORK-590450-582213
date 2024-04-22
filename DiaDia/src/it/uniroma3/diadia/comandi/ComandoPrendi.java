package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private String nomeAttrezzo;

	public ComandoPrendi(String nomeAttrezzo) {
		this.nomeAttrezzo = nomeAttrezzo;
	}

	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo == null)
		System.out.println("Quale attrezzo vuoi prendere ?");
		Attrezzo appAttrezzo = null;
		appAttrezzo = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if (appAttrezzo == null) 
			System.out.println("Attrezzo inesistente");
		else {
			partita.getGiocatore().aggiungiInBorsa(appAttrezzo);
			partita.getStanzaCorrente().removeAttrezzo(appAttrezzo);
			System.out.println("Hai inserito l'attrezzo in borsa");
		}

	}

	@Override
	public void setParametro(String parametro) {
		 
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

}
