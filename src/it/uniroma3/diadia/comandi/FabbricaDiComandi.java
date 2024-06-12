package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.IO;

public interface FabbricaDiComandi {

	public Comando costruisciComando(String istruzione, IO io) throws Exception;
}
