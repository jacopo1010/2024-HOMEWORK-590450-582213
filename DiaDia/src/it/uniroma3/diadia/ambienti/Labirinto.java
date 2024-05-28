package it.uniroma3.diadia.ambienti;

public class Labirinto {
	private Stanza stanzaVincente;
	private Stanza iniziale;

	public Labirinto() {
		this.stanzaVincente = null;
		this.iniziale = null;
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public Stanza getIniziale() {
		return iniziale;
	}

	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}

	public void setIniziale(Stanza iniziale) {
		this.iniziale = iniziale;
	}

}
