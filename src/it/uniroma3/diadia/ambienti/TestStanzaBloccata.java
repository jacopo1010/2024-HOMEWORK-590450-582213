package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanzaBloccata {

	StanzaBloccata test1 = new StanzaBloccata("test1", "nord","osso");
	Stanza appStanza = new Stanza("app1");

	@Test
	public void testStanzaConOggettoChiave() {
		Attrezzo osso = new Attrezzo("osso", 100);
		test1.addAttrezzo(osso);
		test1.impostaStanzaAdiacente("nord", appStanza);
		assertEquals(appStanza, test1.getStanzaAdiacente("nord"));
	}

	@Test
	public void testStanzaSenzaOggetto() {
       test1.impostaStanzaAdiacente("nord", appStanza);
       assertEquals(test1, test1.getStanzaAdiacente("nord"));
	}

}
