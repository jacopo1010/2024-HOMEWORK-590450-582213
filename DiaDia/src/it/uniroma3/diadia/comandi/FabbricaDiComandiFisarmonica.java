package it.uniroma3.diadia.comandi;
import java.util.Scanner;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi{

	@Override
	public Comando costruisciComando(String istruzione, IO io) {
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();	// prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();		// seconda parola: eventuale param.
		scannerDiParole.close();					// evita resource leak chiudendo lo scanner
        if(nomeComando != null)
        	switch (nomeComando) {
        	case "fine":
        		comando = new ComandoFine(io);
        		break;
        	case "vai":
        		comando = new ComandoVai(parametro, io);
        		break;
        	case "aiuto":
        		comando = new ComandoAiuto(io);
        		break;
        	case "posa":
        		comando = new ComandoPosa(parametro, io);
        		break;
        	case "inventario":
        		comando = new ComandoInventario(io);
        		break;
        	case "prendi":
        		comando = new ComandoPrendi(parametro, io);
        		break;
        	case "guarda":
        		comando = new ComandoGuarda(io);
        		break;
        	default:
        		comando = new ComandoNonValido(io);
        		break;
        	}
        if(comando != null) comando.setParametro(parametro);
		return comando;
	}
}
