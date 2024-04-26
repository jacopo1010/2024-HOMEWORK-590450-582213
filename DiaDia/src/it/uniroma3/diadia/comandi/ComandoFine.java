package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
	private IO io;

	public ComandoFine(IO io) {
		this.io = io;
	}

	@Override
	public void esegui(Partita partita) {
	  io.mostraMessaggio("Grazie per aver giocato!");
	  partita.setFinita();
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
		return null;
	}


}