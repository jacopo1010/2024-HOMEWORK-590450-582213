package it.uniroma3.diadia.ambienti;

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
			stringa.append("qui c'è buio pesto");
		}
		stringa.append("\nUscite: ");
		for (String direzione : super.getDirezioni())
			if (direzione!=null)
				stringa.append(" " + direzione);

		return stringa.toString();
	}
	
	public Boolean isIlluminato() {
		if (hasAttrezzo(nomeAttrezzoLuce) == true) {
			return true;
		}
		return false;
	}

}