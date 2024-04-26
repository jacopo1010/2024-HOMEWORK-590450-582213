package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoGuarda implements Comando {

	@Override
	public void esegui(Partita partita) {
	Stanza guardaStanza = partita.getStanzaCorrente();
    System.out.println(guardaStanza.toString());
    System.out.println("Cfu in possesso: " + partita.getGiocatore().getCfu());
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
