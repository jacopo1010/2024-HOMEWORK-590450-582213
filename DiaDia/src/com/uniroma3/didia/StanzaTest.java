package com.uniroma3.didia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StanzaTest {
	Stanza stanzaTest = new Stanza("Test");
	Attrezzo attrezzoTest = new Attrezzo("Testing", 1);
	
	@Test
	public void testRemoveAttrezzo() {
		stanzaTest.addAttrezzo(attrezzoTest);
		assertTrue(stanzaTest.removeAttrezzo(attrezzoTest));
	}

}
