package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private String nomeAttrezzo;
	
	private IO io;

	public ComandoPosa(String attrezzo, IO io) {
		this.nomeAttrezzo = attrezzo;
		this.io = io;
	}

	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo == null)
			io.mostraMessaggio("Quale attrezzo vuoi posare ?");
		Attrezzo appAttrezzo = null;
		appAttrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if (appAttrezzo == null) {
			io.mostraMessaggio("attrezzo inesistente");
		}
		else {
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			partita.getStanzaCorrente().addAttrezzo(appAttrezzo);
			io.mostraMessaggio("Hai posato l'attrezzo");
		}
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "posa";
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

}
