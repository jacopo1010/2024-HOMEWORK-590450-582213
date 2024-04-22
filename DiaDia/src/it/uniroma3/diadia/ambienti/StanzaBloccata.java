package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{
	private String direzioneBloccata;
	private String nomeAttrezzoSbloccaStanza;

	public StanzaBloccata(String nome,String direzioneVietata, String attrezzoSbloccante) {
		super(nome);
		this.direzioneBloccata = direzioneVietata;
		this.nomeAttrezzoSbloccaStanza = attrezzoSbloccante;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if (!hasAttrezzo(nomeAttrezzoSbloccaStanza)) {
			return super.getStanzaAdiacente(getNome());
		}else {
			return super.getStanzaAdiacente(direzione);	
		}
	}


	@Override
	public String getDescrizione() {
		StringBuilder descrizione = new StringBuilder();
		descrizione.append(this.direzioneBloccata);
		descrizione.append("\nAttrezzo che sblocca la stanza: " + this.nomeAttrezzoSbloccaStanza);
		if (hasAttrezzo(nomeAttrezzoSbloccaStanza) == false) {
			descrizione.append("\nAttrezzo che sblocca la stanza: " + this.nomeAttrezzoSbloccaStanza);
		}else {
			descrizione.append("La stanza e' stata sbloccata attraverso: " + this.nomeAttrezzoSbloccaStanza);
		}
		for (String direzione : super.getDirezioni())
			if (direzione!=null)
				descrizione.append(" " + direzione);

		return super.getDescrizione();
	}

}
