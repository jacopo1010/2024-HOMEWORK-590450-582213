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
		if (hasAttrezzo(nomeAttrezzoSbloccaStanza) == false && direzione.equals(direzioneBloccata)) {
			return StanzaBloccata.this;
		}else {
			return super.getStanzaAdiacente(direzione);
		}
	}



	public String getDescrizione() {
		StringBuilder descrizione = new StringBuilder();
		if (hasAttrezzo(nomeAttrezzoSbloccaStanza) == false) {
			descrizione.append("La stanza ha una direzione bloccata: " + this.direzioneBloccata);
			descrizione.append("\nAttrezzo che sblocca la stanza: " + this.nomeAttrezzoSbloccaStanza);
		}else {
			descrizione.append("La stanza e' stata sbloccata attraverso: " + this.nomeAttrezzoSbloccaStanza);
		}
		descrizione.append("\nUscite: ");
		for (String direzione : super.getDirezioni())
			if (direzione!=null)
				descrizione.append(" " + direzione);
		descrizione.append("\nAttrezzi nella stanza: ");
		for (Attrezzo attrezzo : this.attrezzi) {
			if(attrezzo != null)                        //correzione 1 errore attraverso 
				descrizione.append(attrezzo.toString()+" ");
		}
		return descrizione.toString();
	}

}
