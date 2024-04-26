package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole.IOConsole;

public class TestComandoPrendi {
	Partita partita = new Partita();
	IO io = new IOConsole();
	
	@Test
	public void test() {
		Comando prendi = new ComandoPrendi("osso", io);
		prendi.esegui(partita);
		assertNull(partita.getStanzaCorrente().getAttrezzo("osso"));
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
	}

}
