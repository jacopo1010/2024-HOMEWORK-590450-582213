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
		StanzaBloccata aulaN12 = new StanzaBloccata("Aula N12", "nord", "osso");
		StanzaBuia aulaN9 = new StanzaBuia("Aula N9", "lanterna");
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
		aulaN11.impostaStanzaAdiacente("nord", aulaN9);
		biblioteca.impostaStanzaAdiacente("ovest", aulaN12);
		aulaN12.impostaStanzaAdiacente("nord", bagno);
		aulaN12.impostaStanzaAdiacente("ovest", aulaN9);
		aulaN9.impostaStanzaAdiacente("est", aulaN12);
		aulaN9.impostaStanzaAdiacente("sud", aulaN11);
		aulaN9.impostaStanzaAdiacente("ovest", bagno);
		bagno.impostaStanzaAdiacente("est", aulaN9);
		bagno.impostaStanzaAdiacente("sud", aulaN12);
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
