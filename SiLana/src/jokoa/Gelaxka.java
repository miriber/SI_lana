package jokoa;

public class Gelaxka {
	private int i; //errenkada adierazten du
	private int j;	//zutabea adierazten du: 
	private boolean uraDa;
	private boolean tiroJaso;
	private String ontziMota;
	//private ArrayList<Observador> observadores= new ArrayList<Observador>();

	public Gelaxka (int x, int y) {
		i=x;
		j=y;
		uraDa=true;
		tiroJaso=false;
		ontziMota=null;
	}
	
	public void ontziaJarri() {
		uraDa=false;
	}
	
	public void ontziMotaAldatu(Ontzi pOntzi) {
		if (pOntzi instanceof FragataOntzi) {
			ontziMota="Fragata";
		}else if (pOntzi instanceof SuntsitzaileOntzi) {
			ontziMota="Suntsitzailea";
		} else if (pOntzi instanceof HegazkinOntzi) {
			ontziMota="Hegazkina";
		}else {
			ontziMota="Itsaspekoa";
		}
	}
	
	public boolean ontziMotaBera(Ontzi pOntzi) {
		return ontziMota==pOntzi.getMota();
	}
	public void tiroJaso() {
		tiroJaso=false;
	}
	
	public boolean getTiroJaso() {
		return tiroJaso;
	}
	
	public boolean getUraDa() {
		return uraDa;
	}
	
}
