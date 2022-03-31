package jokoa;

public class Gelaxka {
	private int i; //errenkada adierazten du
	private int j;	//zutabea adierazten du: 
	private boolean uraDa;
	private boolean tiroJaso;

	public Gelaxka (int x, int y) {
		i=x;
		j=y;
		uraDa=true;
		tiroJaso=false;
	}
	
	public void ontziaJarri() {
		uraDa=false;
	}
	
	
	public boolean getTiroJaso() {
		return tiroJaso;
	}
	
	public boolean getUraDa() {
		return uraDa;
	}
	
}
