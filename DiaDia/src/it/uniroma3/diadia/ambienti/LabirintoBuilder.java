package it.uniroma3.diadia.ambienti;

import java.util.LinkedList;
import java.util.List;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder extends Labirinto{
	private Stanza memoria;
	private LinkedList<Stanza> stanze;

	public LabirintoBuilder() {
		super();
		this.memoria = null;
		this.stanze = new LinkedList<Stanza>();
	}

	public LabirintoBuilder addStanzaIniziale(String nome) {
		this.memoria = new Stanza(nome);
		this.setIniziale(memoria);
		this.stanze.add(memoria);
		return this;
	}

	public LabirintoBuilder addStanzaVincente(String nome) {
		this.memoria = new Stanza(nome);
		this.setStanzaVincente(memoria);
		this.stanze.add(memoria);
		return this;
	}

	public LabirintoBuilder addAdiacenza(String StanzaDiRiferimento,String StanzaDirezionata,String direzione){
		Stanza settare = new Stanza(StanzaDiRiferimento);
		Stanza adiacente = new Stanza(StanzaDirezionata);
		for (Stanza stanza : stanze) {
			if (stanza.getNome() == StanzaDiRiferimento) {
				settare = stanza;
			}if (stanza.getNome() == StanzaDirezionata) {
				adiacente = stanza;
			}
		}
		settare.impostaStanzaAdiacente(direzione, adiacente);
		return this;
	}

	public Labirinto getLabirinto() {
		return this;
	}

	public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
		Attrezzo attrezzoNuovo = new Attrezzo(nomeAttrezzo, peso);
		this.memoria.addAttrezzo(attrezzoNuovo);
		return this;
	}

	public LabirintoBuilder addStanzaGenerica(String nome) {
		Stanza stanza = new Stanza(nome);
		this.stanze.add(stanza);
		this.memoria = stanza;
		return this;
	}

	public LabirintoBuilder addStanzaBloccata(String nome,String direzioneVietata, String attrezzoSbloccante) {
		StanzaBloccata stanzaBloccata = new StanzaBloccata(nome, direzioneVietata, attrezzoSbloccante);
		this.memoria = stanzaBloccata;
		this.stanze.add(stanzaBloccata);
		return this;
	}

	public LabirintoBuilder addStanzaBuia(String nome, String nomeAttrezzo) {
		StanzaBuia stanzaBuia = new StanzaBuia(nome, nomeAttrezzo);
		this.memoria = stanzaBuia;
		this.stanze.add(stanzaBuia);
		return this;
	}

	public LabirintoBuilder addStanzaMagica(String nome, int soglia) {
		StanzaMagica stanzaMagica = new StanzaMagica(nome,soglia);
		this.memoria = stanzaMagica;
		this.stanze.add(stanzaMagica);
		return this;
	}

	public LinkedList<Stanza> getListaStanze() {
		return stanze;
	}
}
