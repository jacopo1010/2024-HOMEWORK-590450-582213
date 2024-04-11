package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	Borsa borsa = new Borsa();
	Attrezzo attrezzoTest1 = new Attrezzo("Attrezzo1", 1);
	Attrezzo attrezzoTest2 = new Attrezzo("Attrezzo2", 2);
	Attrezzo attrezzoTest3 = new Attrezzo("Attrezzo3", 1);
	
	@Test
	public void testRemoveAttrezzoUno() {
		borsa.addAttrezzo(attrezzoTest1);
		assertEquals(attrezzoTest1, borsa.removeAttrezzo("Attrezzo1"));
	}
	@Test
	public void testRemoveAttrezzoDue() {
		borsa.addAttrezzo(attrezzoTest1);
		borsa.addAttrezzo(attrezzoTest2);
		borsa.addAttrezzo(attrezzoTest2);
		assertEquals(attrezzoTest2, borsa.removeAttrezzo("Attrezzo2"));
		assertEquals(attrezzoTest2, borsa.getAttrezzo("Attrezzo2"));
	}
	@Test
	public void testRemoveAttrezzoVuoto() {
		assertEquals(null, borsa.removeAttrezzo("Attrezzo1"));
	}

}

