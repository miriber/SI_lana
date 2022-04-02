package jokoa;

public abstract class Ontzi {
	private String norabidea;
	//TODO El norabidea es necesario guardarlo?
	private int zenbatFalta; //Hondoratua izan dadin, falta diren gelaxka kopurua adierazten du
	private Egoera egoera;
	
	public Ontzi (int pFalta) {
		norabidea="Horizontal";
		zenbatFalta=pFalta;
		egoera=Egoera.UKITU_GABEA;
	}
	
	public void aldatuNorab() {
		norabidea="Bertikal";
	}
	
	public boolean getEgoera(Egoera pEgo) {
		return egoera==pEgo;
	}
	
	public Egoera getIzena() {
		return egoera;
	}
	
	public boolean oraindikGuztiakEz() {
		return zenbatFalta==0;
	}
	public void aldatuEg() {
		//boolean jadaKlik;
		//if (!jadaKlik) {
			//jadaKlik=true;
		//FLOTAN EGIN
			if (egoera==Egoera.UKITU_GABEA) {
				zenbatFalta--;
				if (zenbatFalta==0) {
					egoera=Egoera.HONDORATUTA;
				}else {
					egoera=Egoera.UKITUTA;
				}
			}else if (egoera==Egoera.UKITUTA) {
				zenbatFalta--;
			}
	}
	
}
