package com.uniroma3.didia;

import static org.junit.Assert.*;
import org.junit.Test;

public class BorsaTest {
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

}
