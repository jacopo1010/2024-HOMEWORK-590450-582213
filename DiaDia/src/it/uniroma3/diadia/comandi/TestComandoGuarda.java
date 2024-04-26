package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import org.junit.Test;
import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.Partita;

public class TestComandoGuarda {
	Partita partita = new Partita();
	
	@Test
	public void test() {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando("guarda");
		comandoDaEseguire.esegui(this.partita);
		
		assert
	}

}
