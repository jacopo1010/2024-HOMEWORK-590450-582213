package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanzaMagica {
	Stanza stanzaMagica1 = new StanzaMagica("StM1");
	Stanza stanzaMagica2 = new StanzaMagica("StM2", 1);
	Stanza stanzaMagica3 = new StanzaMagica("StM3", 0);
	Attrezzo attrezzoTest1 = new Attrezzo("Attrezzo1", 1);
	Attrezzo attrezzoTest2 = new Attrezzo("Attrezzo2", 2);
	Attrezzo osso = new Attrezzo("osso", 1);
	
	@Test
	public void testStM1() {
		stanzaMagica1.addAttrezzo(attrezzoTest1);
		stanzaMagica1.addAttrezzo(attrezzoTest2);
		stanzaMagica1.addAttrezzo(attrezzoTest1);
		stanzaMagica1.addAttrezzo(attrezzoTest1);
		stanzaMagica1.addAttrezzo(osso);
		stanzaMagica1.addAttrezzo(attrezzoTest2);
		assertTrue(stanzaMagica1.hasAttrezzo("osso"));
		assertTrue(stanzaMagica1.hasAttrezzo("Attrezzo1"));
		assertTrue(stanzaMagica1.hasAttrezzo("Attrezzo2"));
		assertTrue(stanzaMagica1.hasAttrezzo("1ozzerttA"));
		assertTrue(stanzaMagica1.hasAttrezzo("2ozzerttA"));
	}
	@Test
	public void testStM2() {
		stanzaMagica2.addAttrezzo(attrezzoTest1);
		stanzaMagica2.addAttrezzo(attrezzoTest2);
		assertTrue(stanzaMagica2.hasAttrezzo("Attrezzo1"));
		assertFalse(stanzaMagica2.hasAttrezzo("1ozzerttA"));
		assertTrue(stanzaMagica2.hasAttrezzo("2ozzerttA"));
	}
	@Test
	public void testStM3() {
		stanzaMagica3.addAttrezzo(attrezzoTest1);
		stanzaMagica3.addAttrezzo(attrezzoTest2);
		assertFalse(stanzaMagica3.hasAttrezzo("Attrezzo1"));
		assertTrue(stanzaMagica3.hasAttrezzo("1ozzerttA"));
		assertTrue(stanzaMagica3.hasAttrezzo("2ozzerttA"));
	}

}
