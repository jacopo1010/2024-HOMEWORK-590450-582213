package it.uniroma3.diadia.ambienti;

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
		if (hasAttrezzo(nomeAttrezzoSbloccaStanza) == false && direzione.equals(direzioneBloccata)) {
			return StanzaBloccata.this;
		} else {
			return super.getStanzaAdiacente(direzione);
		}
	}

	public String getDescrizione() {
		StringBuilder s = new StringBuilder();
		if (hasAttrezzo(nomeAttrezzoSbloccaStanza)) {
			s.append("La stanza e' stata sbloccata attraverso: " + this.nomeAttrezzoSbloccaStanza);
		} else {
			s.append("La stanza ha una direzione bloccata: " + this.direzioneBloccata);
			s.append("\nAttrezzo che sblocca la stanza: " + this.nomeAttrezzoSbloccaStanza);
		}
		s.append("\nUscite: ");
		for (String direzione : super.getDirezioni())
			if (direzione!=null)
				s.append(" " + direzione);
		s.append("\nAttrezzi nella stanza: ");
		attrezzi.forEach((a) -> s.append(a.toString()+" "));
		return s.toString();
	}

}
