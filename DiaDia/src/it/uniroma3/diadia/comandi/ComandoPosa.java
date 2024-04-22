package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private String nomeAttrezzo;

	public ComandoPosa(String attrezzo) {
		this.nomeAttrezzo = attrezzo;
	}

	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo == null)
			System.out.println("Quale attrezzo vuoi posare ?");
		Attrezzo appAttrezzo = null;
		appAttrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if (appAttrezzo == null) {
			System.out.println("attrezzo inesistente");
		}
		else {
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			partita.getStanzaCorrente().addAttrezzo(appAttrezzo);
			System.out.println("Hai posato l'attrezzo");
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
