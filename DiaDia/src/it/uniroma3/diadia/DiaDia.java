package it.uniroma3.diadia;


import java.util.Scanner;

import org.hamcrest.text.IsEqualIgnoringCase;

import it.uniroma3.diadia.IOConsole.IOConsole;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "inventario"};

	private Partita partita;
	
	IOConsole ioConsole = new IOConsole();

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		ioConsole.mostraMessaggio(MESSAGGIO_BENVENUTO);
		
		String istruzione;
		do {
			istruzione = ioConsole.leggiRiga();
		} while (!processaIstruzione(istruzione));
		/*String istruzione; 
		Scanner scannerDiLinee;

		
		scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));*/
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome() != null) {
			switch (comandoDaEseguire.getNome()) {
			case "fine":
				this.fine(); 
				return true;
			case "vai":
				this.vai(comandoDaEseguire.getParametro());
				break;
			case "aiuto":
				this.aiuto();
				break;
			case "prendi":
				this.prendi(comandoDaEseguire.getParametro());
				break;
			case "posa":
				this.posa(comandoDaEseguire.getParametro());
				break;
			case "inventario":
				this.inventario();
				break;
			default:
				ioConsole.mostraMessaggio("Comando sconosciuto");
				break;
			}
		}
		if (this.partita.vinta()) {
			ioConsole.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		StringBuilder s = new StringBuilder();
		for(int i=0; i< elencoComandi.length; i++) 
			s.append(elencoComandi[i]+" ");
		ioConsole.mostraMessaggio(s.toString());
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			ioConsole.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			ioConsole.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		ioConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		ioConsole.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
    
	/**
	 * metodo usato come comando 
	 * dall'utente che prende un attrezzo e lo mette nella borsa
	 * e rimuove l'attrezzo dalla stanza corrente.
	 * @param nomeAttrezzo
	 */
	private void prendi(String nomeAttrezzo) {
		if(nomeAttrezzo == null)
			ioConsole.mostraMessaggio("Quale attrezzo vuoi prendere? ");
		Attrezzo appAttrezzo = null;
		appAttrezzo = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if (appAttrezzo == null) 
			ioConsole.mostraMessaggio("Attrezzo inesistente!");
		else {
			this.partita.getGiocatore().aggiungiInBorsa(appAttrezzo);
			this.partita.getStanzaCorrente().removeAttrezzo(appAttrezzo);
			ioConsole.mostraMessaggio("hai messo l'attrezzo in borsa!");
		}
	}
    
	/**
	 * metodo usato come comando dall'utente
	 * che gli permette di rimuovere un attrezzo dalla borsa
	 * e metterlo nella stanza corrente.
	 * @param nomeAttrezzo
	 */
	private void posa(String nomeAttrezzo) {
		if(nomeAttrezzo == null)
			ioConsole.mostraMessaggio("Quale attrezzo vuoi posare? ");
		Attrezzo appAttrezzo = null;
		appAttrezzo = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if (appAttrezzo == null) 
			ioConsole.mostraMessaggio("Attrezzo inesistente!");
		else {
			this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			this.partita.getStanzaCorrente().addAttrezzo(appAttrezzo);
			ioConsole.mostraMessaggio("hai posato l'attrezzo!");
		}
	}
	
	private void inventario() {
		ioConsole.mostraMessaggio("Apri la tua borsa e trovi:");
		ioConsole.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
	}


	
	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}