package jokoa;

public class Gelaxka {
	private int i; //errenkada adierazten du
	private int j;	//zutabea adierazten du: 
	private boolean tiroJaso;//TODO STATE PATROIA ERABILI
	private boolean begistatu;
	private Ontzi ontzia; 
	private int ozkolaBizitza;
	private boolean ezinJarri; //ontzien inguruan ura dagoela ziurtatzeko
	//private ArrayList<Observador> observadores= new ArrayList<Observador>();

	public Gelaxka (int x, int y) {
		i=x;
		j=y;
		tiroJaso=false;
		ontzia=null;	//Hasiera baten gelaxka guztiak ura dira
		ezinJarri=false; //hasiera baten gelaxka guztietan jarri daiteke ontzia 
		begistatu= false;
	}
	
	
	public void ontziaJarri(Ontzi pOntzi) {
		System.out.println("gelaxka --> ontziaJarri");
		ontzia=pOntzi;
	}
	
	public boolean ontziMotaBera(Ontzi pOntzi) {
		System.out.println("gelaxka --> ontziMotaBera");
		return ontzia==pOntzi;
	}
	
	public void tiroJaso() {
		System.out.println("gelaxka --> tiroJaso");
		tiroJaso=true;
	}
	public boolean begistatuta() {
		System.out.println("gelaxka --> begistatuta");
		return begistatu= true;
		
	}
	public boolean getBegistatuta() {
		System.out.println("gelaxka --> getBegistatuta");
		return begistatu;
		
	}
	public int ozkola() {
		System.out.println("gelaxka --> ozkola");
		return ozkolaBizitza=2;
		
	}
	public int setOzkolaBizitza(int x) {
		return ozkolaBizitza=x;
	}
	public int getOzkolaBizitza() {
		System.out.println("gelaxka --> getOzkolaBizitza");
		return ozkolaBizitza;
		
	}
	
	public boolean getTiroJaso() {
		System.out.println("gelaxka --> getTiroJJaso");
		return tiroJaso;
	}
	
	public boolean getUraDa() {
		System.out.println("gelaxka --> getUraDa");
		return ontzia==null;
	}
	
	public boolean getEzinJarri() {
		System.out.println("gelaxka --> getEzinJarri");
		return ezinJarri;
	}
	
	public void setEzinJarri() {
		System.out.println("gelaxka --> setEzinJarri");
		ezinJarri=true;
	}
	
	public Ontzi getOntzia() {
		System.out.println("gelaxka --> getOntziMota");
		return ontzia;
	}
}
