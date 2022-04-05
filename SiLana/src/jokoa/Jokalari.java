package jokoa;

public abstract class Jokalari {
	private Flota neureFlota ;
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
	
	public Flota getNeureFlota() {
		return neureFlota;
	}
	
	protected void neureOntziakKokatu(int x, int y, char norabidea, Ontzi pOntzi) {
		// ontziaAukeratu metodotik lortuko dugu tamaina
		//String norabidea= ontziarenNorabidea
		//x, y--> Buttonetik atera--> ontziaNonKokatu
		//pOntzi agian hobe tamaina itzultzen badu Tableroa
		neureFlota.ontziakKokatu(x,y,norabidea,pOntzi);
	}
	
	public abstract void ontziakKokatu();
	
	public Flota getAurkariarenFlota() {
		return aurkariarenFlota;
	}
	
	public void txandaBuk() {
		bereTxandaBuk=false;
	}
	
	public void txandaHasi() {
		bereTxandaBuk=true;
	}
	
	public boolean getTxanda() {
		return bereTxandaBuk;
	}
	
	protected boolean badagoKokatuGabekoOntzirik() {
		return !neureFlota.ontziDenakKokatuta();
	}
}
