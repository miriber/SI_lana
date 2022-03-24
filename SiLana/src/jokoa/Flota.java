package jokoa;

import java.util.ArrayList;
import java.util.Iterator;

public class Flota {
	private int dirua;
	private ArrayList<Ontzi> ontziZer;
	private ArrayList<String> armamentuZer;
	private static Tablero taula;
	// ontzi kopuru egokia daudela ziurtatu
	
	public Flota() {
		dirua=25;
		ontziZer= new ArrayList<Ontzi>();
		armamentuZer= new ArrayList<String>();
		taula= taula.getNireTablero();
	}
	
	private Iterator<String> getIteradoreA(){
		return armamentuZer.iterator();
	}
	
	private Iterator<Ontzi> getIteratorO(){
		return ontziZer.iterator();
	}
	
	public void ontziakKokatu() {

	}
}
