package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
*/

public class Stanza {
	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	
	private String nome;
    protected ArrayList<Attrezzo> attrezzi;
    private HashMap<String, Stanza> stanzeAdiacenti;
    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.stanzeAdiacenti = new HashMap<String, Stanza>(NUMERO_MASSIMO_DIREZIONI);
        this.attrezzi = new ArrayList<Attrezzo>();
    }

    /**
     * Imposta una stanza adiacente.
     * Sostituisce la stanza precedentemente inserita se la direzione della nuova stanza è uguale
     * @param direzione in cui sara' posta la stanza adiacente.
     * @param stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
    	stanzeAdiacenti.put(direzione, stanza);
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
		return stanzeAdiacenti.get(direzione);
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public ArrayList<Attrezzo> getAttrezzi() {
        return this.attrezzi;
    }

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
    	return attrezzi.add(attrezzo);
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
    	risultato.append("\nUscite: ");
    	stanzeAdiacenti.forEach((k,v) -> risultato.append(" " + k));  //per ogni elemento aggiunge alla stringa il key
    	risultato.append("\nAttrezzi nella stanza: ");
    	attrezzi.forEach((a) -> risultato.append(" " + a.getNome())); //per ogni elemento aggiunge alla stringa il nome
    	return risultato.toString();
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		for (Attrezzo attrezzo : attrezzi) {
			if (attrezzo.getNome().equals(nomeAttrezzo))
				return true;
		}
		return false;
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo.getNome().equals(nomeAttrezzo))
				return attrezzo;
		}
		return null;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		return attrezzi.remove(attrezzo);
	}


	public String[] getDirezioni() {
	    return stanzeAdiacenti.keySet().toArray(new String[0]); //prende SET di chiavi e le trasforma in ARRAY di String[]
    }

}
