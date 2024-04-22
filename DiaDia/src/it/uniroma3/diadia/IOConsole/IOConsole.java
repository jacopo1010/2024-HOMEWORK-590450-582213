package it.uniroma3.diadia.IOConsole;
import java.util.Scanner;
import it.uniroma3.diadia.IO;

public class IOConsole implements IO{
	/**
	 * Stampa nella console un messaggio
	 * @param msg
	 */
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	
	/**
	 * Legge gli input nella console
	 * @return
	 */
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		return riga;
	}
}
