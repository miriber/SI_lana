package jokoa;

public abstract class Arma {
	
	private String a1;
	
	//Metodo eraikitzailea
	public Arma(String pArma) {
		a1=pArma;
	}
	
	//Gainerako metodoak
	public abstract boolean klaseBerekoa(String pArma);
	
	public String getArma() {
		return a1;
	}
	public abstract void tiroArma(int x, int y);
	
	//TODO metodo hau hemen??
	public Tablero getAurkariarenTab() {
		//Aurkariaren tableroa itzuliko du
		Tablero unekoTab=PC.getNeureJok().getNeureTablero();
		if (Jokoa.getNireJoko().PCTxandaDa()) {
			unekoTab=Pertsona.getNeureJok().getNeureTablero();
		}
		return unekoTab;
	}
}
