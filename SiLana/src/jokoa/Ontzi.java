package jokoa;

public abstract class Ontzi {
	
	private int zenbatFalta; //Hondoratua izan dadin, falta diren gelaxka kopurua adierazten du
	private Egoera egoera;
	private String mota;
	private char norabidea;
	
	public Ontzi (int pFalta, String pMota/* ,char pNorabide*/) {
		zenbatFalta=pFalta;
		egoera=Egoera.UKITU_GABEA;
		mota=pMota;
		//norabide=pNorabide;
	}
	
	//TODO Hau tableroan edo hemen?
	public int getOntziTamaina () {
		System.out.println("ontzi --> getOntziTamaina");
		int tamaina;	
		if (this instanceof SuntsitzaileOntzi) {
			tamaina=2;
		} else if (this instanceof ItsaspekoOntzi) {
			tamaina=3;
		} else if (this instanceof HegazkinOntzi) {
			tamaina=4;
		} else {
			tamaina=1;	//this instanceof FragataOntzi
		}
		return tamaina;
	}
	
	
	public boolean getEgoera(Egoera pEgo) {
		System.out.println("ontzi --> getEgoera");
		return egoera == pEgo;
	}
	
	public Egoera getIzena() {
		System.out.println("ontzi --> getIzena");
		return egoera;
	}
	
	public char getNorabidea() {
		System.out.println("ontzi --> getIzena");
		return norabidea;
	}
	
	public boolean getMotaBera (String pMota) {
		System.out.println("ontzi --> getMotaBera");
		return mota.equals(pMota);
	}
	
	public String getMota() {
		System.out.println("ontzi --> getMota");
		return mota;
	}
	
	public boolean oraindikGuztiakEz() {
		System.out.println("ontzi --> oraindikGuztiakEz");
		return zenbatFalta == 0;
	}
	
	public void aldatuEg() {
		System.out.println("ontzi --> aldatuEg");
		if (zenbatFalta == 0) {
			egoera = Egoera.HONDORATUTA;
		}else {
			egoera = Egoera.UKITUTA;
		}
	}
	
	public void zenbatFaltaKenBat() {
		System.out.println("ontzi --> zenbatFaltaKenBat");
		zenbatFalta --;
		
	}
	
	public void zenbatFaltaZero() {
		System.out.println("ontzi --> zenbatFaltaZero");
		zenbatFalta = 0;
	}

	public void setNorabidea(char pNorabidea) {
		norabidea = pNorabidea;
	}
}
