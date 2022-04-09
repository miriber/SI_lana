package jokoa;

import java.util.ArrayList;

public abstract class Jokalari {
	protected Flota neureFlota ;
	protected Tablero neureTablero;
	protected Tablero aurkariarenTableroa;
	protected static Jokalari nJok=null;
	private boolean bereTxandaBuk;
	
	public  Jokalari() {
		neureFlota= new Flota();
		neureTablero= new Tablero();
		aurkariarenTableroa= new Tablero();
		bereTxandaBuk=false;
	}
	
	
	protected void neureOntziakKokatu(int x, int y, char norabidea,Ontzi pOntzi) {
		// ontziaAukeratu metodotik lortuko dugu tamaina
		//String norabidea= ontziarenNorabidea
		//x, y--> Buttonetik atera--> ontziaNonKokatu
		//pOntzi agian hobe tamaina itzultzen badu Tableroa
		neureTablero.ontziaJarri(x, y, pOntzi, norabidea);
		neureFlota.ontziakKokatu(pOntzi);
	}
	

	public abstract void ontziakKokatu();
	
	public Tablero getAurkariarenTablero() {
		return aurkariarenTableroa;
	}
	
	protected void txandaBuk() {
		bereTxandaBuk=false;
	}
	
	public void txandaHasi() {
		bereTxandaBuk=true;
	}
	
	public  abstract void besteJokTxanda();
	
	public boolean getTxanda() {
		return bereTxandaBuk;
	}
	
	protected boolean badagoKokatuGabekoOntzirik() {
		return !neureFlota.ontziDenakKokatuta();
	}

	public Ontzi[] ontziPosibleakItzuli() {
		return neureFlota.lortuOntziPosibleak();
	}
	
}
