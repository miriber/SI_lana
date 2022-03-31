package jokoa;

public abstract class Ontzi {
	private String norabidea;
	//TODO El norabidea es necesario guardarlo?
	private int zenbatFalta; //Hondoratua izan dadin, falta diren gelaxka kopurua adierazten du
	private Egoera egoera;
	
	public Ontzi(String pNorabidea, int pFalta) {
		norabidea=pNorabidea;
		zenbatFalta=pFalta;
		egoera=Egoera.UKITU_GABEA;
	}
	
	public boolean getEgoera(Egoera pEgo) {
		return egoera==pEgo;
	}
	
	public void aldatuEg() {
		boolean jadaKlik;
		if (!jadaKlik) {
			jadaKlik=true;
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
}
