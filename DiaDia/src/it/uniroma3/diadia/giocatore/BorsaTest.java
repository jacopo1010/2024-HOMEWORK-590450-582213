package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	Borsa borsa = new Borsa();
	Attrezzo attrezzoTest1 = new Attrezzo("Attrezzo1", 1);
	Attrezzo attrezzoTest2 = new Attrezzo("Attrezzo2", 2);
	Attrezzo attrezzoTest3 = new Attrezzo("Attrezzo3", 1);
	Attrezzo attrezzoTest4 = new Attrezzo("Attrezzo4", 5);
	
	@Test
	public void testRemoveAttrezzoUno() {
		borsa.addAttrezzo(attrezzoTest1);
		assertEquals(attrezzoTest1, borsa.removeAttrezzo("Attrezzo1"));
		assertEquals(null, borsa.getAttrezzo("Attrezzo1"));
	}
	@Test
	public void testRemoveAttrezzoDue() {
		borsa.addAttrezzo(attrezzoTest1);
		borsa.addAttrezzo(attrezzoTest2);
		borsa.addAttrezzo(attrezzoTest2);
		assertEquals(attrezzoTest2, borsa.removeAttrezzo("Attrezzo2"));
		assertEquals(attrezzoTest2, borsa.getAttrezzo("Attrezzo2"));
	}
	@Test
	public void testRemoveAttrezzoVuoto() {
		assertEquals(null, borsa.removeAttrezzo("Attrezzo1"));
	}
	@Test
	public void testIsEmpty() {
		assertTrue(borsa.isEmpty());
	}
	@Test
	public void testIsEmptyConRoba() {
		borsa.addAttrezzo(attrezzoTest1);
		borsa.addAttrezzo(attrezzoTest2);
		assertFalse(borsa.isEmpty());
	}
	@Test
	public void testGetPesoVuota() {
		assertEquals(0, borsa.getPeso());
	}
	@Test
	public void testGetPesoPiena() {
		borsa.addAttrezzo(attrezzoTest4);
		borsa.addAttrezzo(attrezzoTest4);
		assertEquals(10, borsa.getPeso());
	}
	@Test
	public void testHasAttrezzoTrue() {
		//questo test è valido anche per getAttrezzo
		borsa.addAttrezzo(attrezzoTest4);
		assertTrue(borsa.hasAttrezzo("Attrezzo4"));
	}
	@Test
	public void testHasAttrezzoFalse() {
		//questo test è valido anche per getAttrezzo
		assertFalse(borsa.hasAttrezzo("Attrezzo4"));
	}
	@Test
	public void testBorsaPiena() {
		//questo test è valido anche per getAttrezzo
		borsa.addAttrezzo(attrezzoTest4);
		borsa.addAttrezzo(attrezzoTest4);
		assertFalse(borsa.addAttrezzo(attrezzoTest1));
	}
	@Test
	public void testSortedPeso() {
		List<Attrezzo> sorted = new ArrayList<Attrezzo>();
		sorted.add(attrezzoTest1);
		sorted.add(attrezzoTest3);
		sorted.add(attrezzoTest2);
		sorted.add(attrezzoTest4);
		borsa.addAttrezzo(attrezzoTest1);
		borsa.addAttrezzo(attrezzoTest2);
		borsa.addAttrezzo(attrezzoTest3);
		borsa.addAttrezzo(attrezzoTest4);
		assertEquals(sorted, borsa.getContenutoOrdinatoPerPeso());
	}
	@Test
	public void testSortedNome() {
		borsa.addAttrezzo(attrezzoTest1);
		borsa.addAttrezzo(attrezzoTest3);
		borsa.addAttrezzo(attrezzoTest4);
		borsa.addAttrezzo(attrezzoTest2);
		assertEquals("[Attrezzo1 (1kg), Attrezzo2 (2kg), Attrezzo3 (1kg), Attrezzo4 (5kg)]", borsa.getContenutoOrdinatoPerNome().toString());
	}
	@Test
	public void testSortedPesoMap() {
		Map<Integer, Set<Attrezzo>> map = new HashMap<>();
		Set<Attrezzo> set1 = new HashSet<Attrezzo>();
		Set<Attrezzo> set2 = new HashSet<Attrezzo>();
		Set<Attrezzo> set5 = new HashSet<Attrezzo>();
		set1.add(attrezzoTest1);
		set2.add(attrezzoTest2);
		set1.add(attrezzoTest3);
		set5.add(attrezzoTest4);
		map.put(1, set1);
		map.put(2, set2);
		map.put(5, set5);
		borsa.addAttrezzo(attrezzoTest1);
		borsa.addAttrezzo(attrezzoTest2);
		borsa.addAttrezzo(attrezzoTest3);
		borsa.addAttrezzo(attrezzoTest4);
		assertEquals(map, borsa.getContenutoRaggruppatoPerPeso());
	}
	
	@Test
	public void TestOrdinatoPerPesoSortedEsercizio4() {
		Borsa borsa = new Borsa();
		borsa.addAttrezzo(attrezzoTest4);
		borsa.addAttrezzo(attrezzoTest2);
		borsa.addAttrezzo(attrezzoTest1);
		borsa.addAttrezzo(attrezzoTest1);
		assertEquals("[Attrezzo1 (1kg), Attrezzo1 (1kg), Attrezzo2 (2kg), Attrezzo4 (5kg)]",borsa.getContenutoOrdinatoPerPeso().toString());
	}
}

