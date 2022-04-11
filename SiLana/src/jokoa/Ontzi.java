package jokoa;

public abstract class Ontzi {
	
	private int zenbatFalta; //Hondoratua izan dadin, falta diren gelaxka kopurua adierazten du
	private Egoera egoera;
	private String mota;
//	private char norabide;
	
	public Ontzi (int pFalta, String pMota/* ,char pNorabide*/) {
		zenbatFalta=pFalta;
		egoera=Egoera.UKITU_GABEA;
		mota=pMota;
		//norabide=pNorabide;
	}
	
	//TODO Hau tableroan edo hemen?
	public int getOntziTamaina () {
		int tamaina;	
		if (this instanceof SuntsitzaileOntzi) {
			tamaina=2;
		}else if (this instanceof ItsaspekoOntzi) {
			tamaina=3;
		}else if (this instanceof HegazkinOntzi) {
			tamaina=4;
		}else {
			tamaina=1;	//this instanceof FragataOntzi
		}
		return tamaina;
	}
	
	
	public boolean getEgoera(Egoera pEgo) {
		return egoera==pEgo;
	}
	
	public Egoera getIzena() {
		return egoera;
	}
	
	public boolean getMotaBera (String pMota) {
		return mota.equals(pMota);
	}
	
	public String getMota() {
		return mota;
	}
	
	public boolean oraindikGuztiakEz() {
		return zenbatFalta==0;
	}
	
	public void aldatuEg() {
		if (zenbatFalta==0) {
			egoera=Egoera.HONDORATUTA;
		}else {
			egoera=Egoera.UKITUTA;
		}
	}
	
	public void zenbatFaltaKenBat() {
		zenbatFalta --;
		
	}
	
	public void zenbatFaltaZero() {
		zenbatFalta = 0;
	}
}
