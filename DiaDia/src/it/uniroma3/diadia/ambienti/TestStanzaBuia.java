package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanzaBuia {
	StanzaBuia test1 = new StanzaBuia("test1", "lanterna");
	
	@Test
	public void test() {
		Attrezzo lanterna = new Attrezzo("lanterna", 100);
		test1.addAttrezzo(lanterna);
		assertTrue(test1.isIlluminato());
	}

}
