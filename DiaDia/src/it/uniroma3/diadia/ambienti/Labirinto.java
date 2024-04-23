package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	private Stanza stanzaVincente;
	private Stanza iniziale;

	public Labirinto() {
		this.stanzaVincente = new Stanza("appoggio");
		this.iniziale = new Stanza("appoggio2");
	}


	public void creaStanze() {

		/* crea gli attrezzi */
		Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);

		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		StanzaBloccata n12 = new StanzaBloccata("n12","nord", "osso");
		StanzaBuia n9 = new StanzaBuia("n9", "lanterna");
        StanzaMagica bagno = new StanzaMagica("bagno");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		//sto inserendo io non erano predefinite
		aulaN11.impostaStanzaAdiacente("nord", n9);
		biblioteca.impostaStanzaAdiacente("ovest", n12);
		n12.impostaStanzaAdiacente("nord", bagno);
		n12.impostaStanzaAdiacente("ovest", n9);
		n9.impostaStanzaAdiacente("est", n12);
		n9.impostaStanzaAdiacente("sud", aulaN11);
		n9.impostaStanzaAdiacente("ovest", bagno);
		bagno.impostaStanzaAdiacente("est", n9);
		bagno.impostaStanzaAdiacente("sud", n12);
		//quelle predefinite
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
	
		

		/* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
		this.iniziale = atrio;  
		this.stanzaVincente = biblioteca;
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
