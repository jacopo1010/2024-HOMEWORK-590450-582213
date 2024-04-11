package com.uniroma3.didia;

import static org.junit.Assert.*;

import org.junit.Test;

public class GiocatoreTest {
      Giocatore playerGiocatore = new Giocatore();
	
	@Test
	public void testAggiungiInborsa() {
	  Attrezzo app = new Attrezzo("spada", 7);
	  Borsa gucci = new Borsa();
	  playerGiocatore.aggiungiInBorsa(app);
	  assertTrue(gucci.hasAttrezzo("spada"));
	}

}
