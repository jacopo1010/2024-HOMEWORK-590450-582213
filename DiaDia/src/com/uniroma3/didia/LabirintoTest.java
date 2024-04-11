package com.uniroma3.didia;

import static org.junit.Assert.*;

import org.junit.Test;

public class LabirintoTest {
	Labirinto labirinto = new Labirinto();
	
	
	@Test
	public void testStanzaVincente() {
		labirinto.creaStanze();
		Stanza atrio = new Stanza("Atrio");
		Stanza biblioteca = new Stanza("Biblioteca");
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		assertEquals(biblioteca.getNome(), labirinto.getStanzaVincente().getNome());
	}

}
