package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoRegala implements Comando{

	private String nomeAttrezzo;

	private IO io;

	public ComandoRegala(String nomeAttrezzo, IO io) {
		this.nomeAttrezzo = nomeAttrezzo;
		this.io = io;
	} 

	@Override
	public void esegui(Partita partita) {
		if(partita.getStanzaCorrente().getPersonaggio() == null) {
			io.mostraMessaggio("Non c'e nessun personaggio all'"
					+ "interno della stanza");
		}else {
			if(nomeAttrezzo == null)
				io.mostraMessaggio("Quale attrezzo vuoi regalare ? ");
			Attrezzo appAttrezzo = null;
			appAttrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			if (appAttrezzo == null) 
				io.mostraMessaggio("Attrezzo inesistente");
			else {
				partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
				io.mostraMessaggio("Hai regalato l'attrezzo al personagio:"+ partita.getStanzaCorrente().getPersonaggio().getNome());
				partita.getStanzaCorrente().getPersonaggio().riceviRegalo(appAttrezzo);
				partita.getStanzaCorrente().getPersonaggio().agisci(partita);
			}
		}
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

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
