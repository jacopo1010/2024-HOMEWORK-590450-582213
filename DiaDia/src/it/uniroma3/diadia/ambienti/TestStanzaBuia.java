package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanzaBuia {
	StanzaBuia test1 = new StanzaBuia("test1", "lanterna");
	Attrezzo lanterna = new Attrezzo("lanterna", 3);
	
	@Test
	public void testIlluminato() {
		test1.addAttrezzo(lanterna);
		assertTrue(test1.isIlluminato());
	}
	@Test
	public void testNonIlluminato() {
		assertFalse(test1.isIlluminato());
	}
	@Test
	public void testGetDescrizione() {
		test1.addAttrezzo(lanterna);
		assertEquals("la stanza e' illuminata da: lanterna\n"
					+ "Uscite: \n"
					+ "Attrezzi nella stanza: lanterna (3kg) ", test1.getDescrizione());
	}


}
