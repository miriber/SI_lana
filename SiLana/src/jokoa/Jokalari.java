package jokoa;

import java.util.ArrayList;

public abstract class Jokalari {
	protected Flota neureFlota ;
	protected Flota aurkariarenFlota;
	protected static Jokalari nJok=null;
	private boolean bereTxandaBuk;
	//private String izena;
	
	public  Jokalari(/*String pIzena*/) {
		//izena=pIzena;
		neureFlota= new Flota();
		aurkariarenFlota= new Flota();
		bereTxandaBuk=false;
	}
	
	//public abstract static Jokalari getNeureJok();
	/*public static Jokalari getNeureJokalari() {
		if (nJok==null) {
			nJok= new Jokalari();
		}
		return nJok;
	}*/
	
	/*public Flota getNeureFlota() {
		return neureFlota;
	}*/
	
	protected void neureOntziakKokatu(int x, int y, char norabidea, Ontzi pOntzi) {
		// ontziaAukeratu metodotik lortuko dugu tamaina
		//String norabidea= ontziarenNorabidea
		//x, y--> Buttonetik atera--> ontziaNonKokatu
		//pOntzi agian hobe tamaina itzultzen badu Tableroa
		neureFlota.ontziakKokatu(x,y,norabidea,pOntzi);
	}
	
	public abstract void ontziakKokatu();
	
	/*public Flota getAurkariarenFlota() {
		return aurkariarenFlota;
	}*/
	
	protected void txandaBuk() {
		bereTxandaBuk=false;
	}
	
	protected void txandaHasi() {
		bereTxandaBuk=true;
	}
	
	public  abstract void besteJokTxanda();
	
	public boolean getTxanda() {
		return bereTxandaBuk;
	}
	
	public boolean badagoKokatuGabekoOntzirik() {
		return !neureFlota.ontziDenakKokatuta();
	}

	public ArrayList<Ontzi> ontziPosibleakInprima() {
		return neureFlota.aukeraHauekInprima();
	}
	
}
