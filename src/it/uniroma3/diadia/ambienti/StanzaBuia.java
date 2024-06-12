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
			stringa.append("\nUscite: ");
			for (String direzione : super.getDirezioni()) {
				stringa.append(" " + direzione);
			}
			stringa.append("\nAttrezzi nella stanza: ");
			attrezzi.forEach((a) -> stringa.append(a.toString()+" "));
		}
		else {
			stringa.append("qui c'è buio pesto");
		}
		return stringa.toString();
	}
	
	public Boolean isIlluminato() {
		return hasAttrezzo(nomeAttrezzoLuce);
	}

}