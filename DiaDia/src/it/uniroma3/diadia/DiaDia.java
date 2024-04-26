package it.uniroma3.diadia;

import it.uniroma3.diadia.IOConsole.*;
import it.uniroma3.diadia.comandi.*;

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

	private Partita partita;

	//IOConsole ioConsole = new IOConsole();
	public IO io;

	public DiaDia(IO io) {
		this.partita = new Partita();
		this.io = io;
	}

	public void gioca() {
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);

		String istruzione;
		do {
			istruzione = io.leggiRiga();
		} while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando(istruzione, io);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
		}
		if (!this.partita.giocatoreIsVivo()) {
			io.mostraMessaggio("Hai esaurito i CFU...");
			partita.setFinita();
		}
		
		return this.partita.isFinita();
	}




	public static void main(String[] argc) {
		IO io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}

