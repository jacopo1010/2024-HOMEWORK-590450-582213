package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza{
	private String nomeAttrezzoLuce;

	public StanzaBuia(String nome, String nomeAttrezzo) {
		super(nome);
		this.nomeAttrezzoLuce = nomeAttrezzo;
	}

	public String getDescrizione() {
		StringBuilder stringa = new StringBuilder();
		if (isIlluminato()) {
			stringa.append("la stanza e' illuminata da: " + this.nomeAttrezzoLuce);
		}
		else {
			stringa.append("la stanza e' illuminata da: " + this.nomeAttrezzoLuce);
			stringa.append("\nUscite: ");
			for (String direzione : super.getDirezioni())
				if (direzione!=null)
					stringa.append(" " + direzione);
			stringa.append("\nAttrezzi nella stanza: ");
			for (Attrezzo attrezzo : this.attrezzi) {
				if(attrezzo != null)                         
					stringa.append(attrezzo.toString()+" ");
			}
			stringa.append("qui c'è buio pesto");
		}

		return stringa.toString();
	}
	
	public Boolean isIlluminato() {
		if (hasAttrezzo(nomeAttrezzoLuce) == true) {
			return true;
		}
		return false;
	}

}