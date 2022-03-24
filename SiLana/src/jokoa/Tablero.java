package jokoa;

public class Tablero {
	private Gelaxka[][] taula;
	public static Tablero nireTableroa= null;	//EMA
	
	//metodo eraikitzaileak 
	private Tablero() {
		taula= new Gelaxka[10][10];
	}
	
	public static Tablero getNireTablero() {
		if (nireTableroa==null) {
			nireTableroa= new Tablero();
		}return nireTableroa;
	}
	
	//gainerako metodoak
	
	
}
