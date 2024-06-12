package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoInventario extends AbstractComando implements Comando{
	private IO io;
	
	public ComandoInventario(IO io) {
		this.io = io;
	}

	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Apri la tua borsa e trovi: ");
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "inventario";
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

}
