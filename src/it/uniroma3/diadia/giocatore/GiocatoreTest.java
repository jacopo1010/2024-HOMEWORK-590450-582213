package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;
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
	  assertEquals(app, gucci.getAttrezzo(app.getNome()));
	}
   
	@Test
	public void testAggiungiInBorsaNull() {
		 playerGiocatore.setBorsa(gucci);
		 playerGiocatore.aggiungiInBorsa(app);
		 assertNotNull(gucci.hasAttrezzo(app.getNome()));
	}
	
	@Test
	public void testAggiungiInBorsaAttrezzoSbagliato() {
		 playerGiocatore.setBorsa(gucci);
		 playerGiocatore.aggiungiInBorsa(app);
		 assertFalse(gucci.hasAttrezzo("Martello"));
	}
}
