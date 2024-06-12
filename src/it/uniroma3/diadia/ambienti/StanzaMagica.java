package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza{
	final static private int SOGLIA_MAGICA_DEFAULT = 3;
	private int sogliaMagica;
	
	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}
	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.sogliaMagica = soglia;
	}
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if ((this.attrezzi.size() + 1) > this.sogliaMagica) {
			attrezzo = this.modificaAttrezzo(attrezzo);
		}
		attrezzi.add(attrezzo);
		return true;
	}

	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito = new StringBuilder(attrezzo.getNome());
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(), pesoX2);
		return attrezzo;
	}
}
