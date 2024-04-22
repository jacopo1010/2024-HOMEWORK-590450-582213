package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza{
	private String nomeAttrezzoLuce;

	public StanzaBuia(String nome, String nomeAttrezzo) {
		super(nome);
		this.nomeAttrezzoLuce = nomeAttrezzo;
	}

	public String getDescrizione() {
		boolean v = true;
		StringBuilder stringa = new StringBuilder();
		Attrezzo appAttrezzo = null;
		for (int i = 0; i < numeroAttrezzi; ++i) {
			if(attrezzi[i].getNome().equals("lanterna")) {
				appAttrezzo = attrezzi[i];
				v = false;
			}
		}
		if(v == true)
			stringa.append("\nQui c'e' un buio pesto");
		else 
			stringa.append("\nLa stanza ora e' illuminata da" + appAttrezzo.getNome());

		return stringa.toString();
	}

}