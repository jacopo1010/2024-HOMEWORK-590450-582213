package it.uniroma3.diadia.IOConsole;
import java.util.Scanner;

public class IOConsole {
	
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	
	public String leggiRiga() {
		try (Scanner scannerDiLinee = new Scanner(System.in)) { //try with resources per aiutare il garbage collector a eliminare una volta finito
			String riga = scannerDiLinee.nextLine();
			return riga;
		}
	}
}
