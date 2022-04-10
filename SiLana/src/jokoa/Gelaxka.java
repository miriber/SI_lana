package jokoa;

public class Gelaxka {
	private int i; //errenkada adierazten du
	private int j;	//zutabea adierazten du: 
	private boolean tiroJaso;//TODO STATE PATROIA ERABILI
	private Ontzi ontziMota; 
	//private ArrayList<Observador> observadores= new ArrayList<Observador>();

	public Gelaxka (int x, int y) {
		i=x;
		j=y;
		tiroJaso=false;
		ontziMota=null;	//Hasiera baten gelaxka guztiak ura dira
	}
	
	
	public void ontziaJarri(Ontzi pOntzi) {
		ontziMota=pOntzi;
	}
	
	public boolean ontziMotaBera(Ontzi pOntzi) {
		return ontziMota==pOntzi;
	}
	
	public void tiroJaso() {
		tiroJaso=true;
	}
	
	public boolean getTiroJaso() {
		return tiroJaso;
	}
	
	public boolean getUraDa() {
		return ontziMota==null;
	}
	
}
