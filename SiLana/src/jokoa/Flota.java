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
	
	private void ontziakSortu() {
		OntziFactory nFact = OntziFactory.getNireOntziFact();
		Ontzi berria= nFact.createOntzi(4);
		//hegazkin ontzi bat
		ontziZer.add(berria);
		//4 Fragata izango ditugu
		for (int i=0;i<4;i++) {
			berria= nFact.createOntzi(1);
			ontziZer.add(berria);
		} 
		// hiru suntsitzaile
		for (int i=0;i<3;i++) {
			berria= nFact.createOntzi(2);
			ontziZer.add(berria);
		}
		//bi itsaspeko
		for (int i=0;i<2;i++) {
			berria= nFact.createOntzi(3);
			ontziZer.add(berria);
		}
	}
	public void ontziakKokatu() {
		ontziakSortu();
		
	}
}
