package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private String nomeAttrezzo;
	
	private IO io;

	public ComandoPrendi(String nomeAttrezzo, IO io) {
		this.nomeAttrezzo = nomeAttrezzo;
		this.io = io;
	}

	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo == null)
		io.mostraMessaggio("Quale attrezzo vuoi prendere ?");
		Attrezzo appAttrezzo = null;
		appAttrezzo = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if (appAttrezzo == null) 
			io.mostraMessaggio("Attrezzo inesistente");
		else {
			partita.getGiocatore().aggiungiInBorsa(appAttrezzo);
			partita.getStanzaCorrente().removeAttrezzo(appAttrezzo);
			io.mostraMessaggio("Hai inserito l'attrezzo in borsa");
		}

	}

	@Override
	public void setParametro(String parametro) {
		 
	}

	@Override
	public String getNome() {
		return "prendi";
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

}
