package com.uniroma3.didia;

import static org.junit.Assert.*;

import org.junit.Test;

public class GiocatoreTest {
      Giocatore playerGiocatore = new Giocatore();
      Attrezzo app = new Attrezzo("spada", 7);
	  Borsa gucci = new Borsa();
	  
	@Test
	public void testAggiungiInborsa() {
	  playerGiocatore.setBorsa(gucci);
	  playerGiocatore.aggiungiInBorsa(app);
	  assertTrue(gucci.hasAttrezzo("spada"));
	}
   
	@Test
	public void testAggiungiInBorsaNull() {
	
	}
}
