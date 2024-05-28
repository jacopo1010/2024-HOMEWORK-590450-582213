package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestComandoPosa {
	Partita partita = new Partita(null);
	IO io = new IOConsole();
	
	@Test
	public void test() {
		Attrezzo franco = new Attrezzo("franco", 9); //Attrezzo Franco è il più potente del gioco, un goblin che pesa 9kg
		partita.getGiocatore().getBorsa().addAttrezzo(franco);
		Comando posa = new ComandoPosa("franco", io);
		posa.esegui(partita);
		assertEquals(franco, partita.getStanzaCorrente().getAttrezzo("franco"));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("franco"));
	}

}
