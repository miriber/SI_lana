package jokoa;

public class Jokoa {
	private boolean PCTxanda;
	private Jokalari jokPC;
	private Jokalari jok1;
	private static Jokoa nJoko=null;
	
	private Jokoa() {
		PCTxanda=false;
		jokPC= PC.getNeureJok();
		jok1=Jokalari1.getNeureJok();
		
	}
	
	public static Jokoa getNireJoko() {
		if (nJoko==null) {
			nJoko=new Jokoa();
		}return nJoko;
	}
	
	public static void main(String args[]) {
		//PARTIDA NOIZ HASTEN DEN
		
		//TXANDAK KONTROLATU
		
		//PARTIDA NOIZ BUKATU
	}
}
