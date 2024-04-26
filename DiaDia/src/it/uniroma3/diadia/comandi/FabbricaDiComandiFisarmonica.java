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
			nomeComando = scannerDiParole.next();// prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next(); // seconda parola: eventuale param.
		
		switch (nomeComando) {
		case "fine":
			comando = new ComandoFine();
			break;
		case "vai":
			comando = new ComandoVai(parametro, io);
			break;
		case "aiuto":
			comando = new ComandoAiuto();
			break;
		case "posa":
			comando = new ComandoPosa(parametro);
			break;
		case "inventario":
			comando = new ComandoInventario();
			break;
		case "prendi":
			comando = new ComandoPrendi(parametro, io);
			break;
		case "guarda":
			comando = new ComandoGuarda();
			break;
		default:
			comando = new ComandoNonValido();
			break;
		}
		comando.setParametro(parametro);
		return comando;
	}

}
