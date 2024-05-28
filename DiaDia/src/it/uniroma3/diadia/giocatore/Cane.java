package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{
	private static final String MESSAGGIO_DONO = "Bau bau, Woof, Woof";
	private static final String MESSAGGIO_SCUSE = "rwaaa ti ho tolto 1 cfu";
	private Attrezzo attrezzo;



	public Cane(String nome, String presentaz,Attrezzo attrezzo) {
		super(nome, presentaz);
		this.attrezzo = attrezzo;
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		if(this.attrezzo != null)
		this.riceviRegalo(attrezzo);
		if(this.riceviRegalo(attrezzo).equals("osso")) {
			partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo = null;
			msg = MESSAGGIO_DONO;	
		}else {
			Giocatore giocatore = partita.getGiocatore();
			partita.getGiocatore().setCfu(giocatore.getCfu()-1);
			msg = MESSAGGIO_SCUSE;
		}
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo) {
		if (attrezzo.getNome().equals("osso")) {
			return new String("osso");
		}
		return new String("Slurp,Slurp");
	}

}
