package jokoa;

public abstract class Ontzi {
	//private char norabidea;
	private int zenbatFalta; //Hondoratua izan dadin, falta diren gelaxka kopurua adierazten du
	private Egoera egoera;
	private String mota;
	
	public Ontzi (int pFalta, String pMota) {
	//	norabidea='H';
		zenbatFalta=pFalta;
		egoera=Egoera.UKITU_GABEA;
		mota=pMota;
	}
	
	/*public void aldatuNorab() {
		norabidea='B';
	}*/
	
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
