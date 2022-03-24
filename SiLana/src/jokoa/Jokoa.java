package jokoa;

public class Jokoa {
	//atributuak
	private static Jokoa nireJokoa=null;
	
	//metodo eraikitzaileak
	private Jokoa() {}
	public static Jokoa getNireJokoa() {
		if (nireJokoa==null) {
			nireJokoa= new Jokoa();
		}return nireJokoa;
	}
	
	//gainerako metodoak
	public static void main(String[] args) {
		//arauak inprimatu (oraindik ez dugu egingo!)
		
	}
	
}
