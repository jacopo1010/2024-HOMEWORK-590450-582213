package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole.IOConsole;

public class TestFabbricaFisarmonica {
	Partita partita = new Partita();
	IO io = new IOConsole();
	
	@Test
	public void testPrendi() {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando("prendi", io);
		assertEquals("prendi", comandoDaEseguire.getNome());
	}

}
