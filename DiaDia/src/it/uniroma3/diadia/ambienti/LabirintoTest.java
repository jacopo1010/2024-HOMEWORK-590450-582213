package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

public class LabirintoTest {
	Labirinto labirinto = new Labirinto();
	
	
	@Test
	public void testStanzaVincente() {
		labirinto.creaStanze();
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
	}
	
    @Test
    public void testStanzaVincenteSbagliata() {
    	labirinto.creaStanze();
    	assertNotEquals("atrio", labirinto.getStanzaVincente().getNome());
    }
    
    @Test
    public void testStanzaVincenteNull() {
    	labirinto.creaStanze();
    	assertNotNull(labirinto.getStanzaVincente());
    }

}
