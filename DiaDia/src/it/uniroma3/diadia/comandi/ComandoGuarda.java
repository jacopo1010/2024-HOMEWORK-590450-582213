package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoGuarda implements Comando {
	private IO io;
	
	public ComandoGuarda(IO io) {
		this.io = io;
	}
	
	@Override
	public void esegui(Partita partita) {
	Stanza guardaStanza = partita.getStanzaCorrente();
	io.mostraMessaggio(guardaStanza.toString());
    io.mostraMessaggio("Cfu in possesso: " + partita.getGiocatore().getCfu());
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
