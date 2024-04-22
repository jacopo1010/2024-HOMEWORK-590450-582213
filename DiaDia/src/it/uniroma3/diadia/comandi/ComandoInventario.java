package it.uniroma3.diadia.comandi;

import java.util.Iterator;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.Partita;

public class ComandoInventario implements Comando{

	@Override
	public void esegui(Partita partita) {
	  System.out.println("Apri la tua borsa e trovi: ");
	  System.out.println(partita.getGiocatore().getBorsa().toString());
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

}
