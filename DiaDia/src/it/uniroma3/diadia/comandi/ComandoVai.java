package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando{
	private String direzione;
	
	private IO io;

	public ComandoVai(String direzione, IO io) {
		this.direzione = direzione;
		this.io = io;
	}

	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(direzione == null) {
			io.mostraMessaggio("Dove vuoi andare ? devi specificare una direzione!");
			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if (prossimaStanza == null) {
			io.mostraMessaggio("Direzione inesistente!");
		}
		else {
			partita.setStanzaCorrente(prossimaStanza);
			io.mostraMessaggio(partita.getStanzaCorrente().getNome());
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
			System.out.println(partita.getGiocatore().getCfu());
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
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
