package com.uniroma3.didia;

import static org.junit.Assert.*;
import org.junit.Test;

public class StanzaTest {
	Stanza stanzaTest1 = new Stanza("St1");
	Stanza stanzaTest2 = new Stanza("St2");
	Stanza stanzaTest3 = new Stanza("St3");
	Attrezzo attrezzoTest1 = new Attrezzo("Attrezzo1", 1);
	Attrezzo attrezzoTest2 = new Attrezzo("Attrezzo2", 2);
	Attrezzo attrezzoTest3 = new Attrezzo("Attrezzo3", 1);
	
	@Test
	public void testRemoveAttrezzoUno() {
		stanzaTest1.addAttrezzo(attrezzoTest1);
		assertTrue(stanzaTest1.removeAttrezzo(attrezzoTest1));
	}
	@Test
	public void testRemoveAttrezzoDue() {
		stanzaTest1.addAttrezzo(attrezzoTest1);
		stanzaTest1.addAttrezzo(attrezzoTest2);
		assertTrue(stanzaTest1.removeAttrezzo(attrezzoTest2));
	}
	@Test
	public void testRemoveAttrezzoVuoto() {
		assertFalse(stanzaTest1.removeAttrezzo(attrezzoTest2));
	}
	
	@Test
	public void testHasAttrezzo() {
		stanzaTest1.addAttrezzo(attrezzoTest1);
		stanzaTest1.addAttrezzo(attrezzoTest2);
		assertTrue(stanzaTest1.hasAttrezzo("Attrezzo1"));
	}
	@Test
	public void testHasAttrezzoVuoto() {
		assertFalse(stanzaTest1.hasAttrezzo("Attrezzo1"));
	}
	@Test
	public void testHasAttrezzoAltraStanzaPiena() {
		stanzaTest2.addAttrezzo(attrezzoTest3);
		stanzaTest2.addAttrezzo(attrezzoTest2);
		assertFalse(stanzaTest1.hasAttrezzo("Attrezzo1"));
	}

}
