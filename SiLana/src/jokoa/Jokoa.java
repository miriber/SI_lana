package jokoa;

import bista.Irabazlea;
import bista.Tableroa;

public class Jokoa {
	private boolean PCTxanda;
	private Jokalari jokPC;
	private Jokalari jok1;
	private static Jokoa nJoko=null;
	
	private Jokoa() {
		PCTxanda=false;
		jokPC= PC.getNeureJok();
		jok1=Jokalari1.getNeureJok();
		System.out.println("JOK1" + jok1);
		System.out.println("JOKPC" + jokPC);
		
	}
	
	public static Jokoa getNireJoko() {
		if (nJoko==null) {
			nJoko=new Jokoa();
		}return nJoko;
	}
	
	public boolean getNorIrabazi() {	//Irabazi jFrame erabili
		return PCTxanda;
	}
	
	public static void main(String args[]) {
		Jokoa jokoa= Jokoa.getNireJoko();
		Tableroa tab= Tableroa.getNireTableroa();
		Tablero tab1= Tablero.getTablero();
		tab.tableroaIkusi();
		//while (jokoa.jok1.badagoKokatuGabekoOntzirik()) { //ontzi guztiak kokatuta ez dauden bitartean
		//	jokoa.jok1.ontziakKokatu();
		//}
		/*int i=0;
		//Ontziak Kokatu
		
		jokooa.PCTxanda=true;
		jokoa.jokPC.ontziakKokatu();
		// behin ontziak kokatuta daudela, aurkariarenTableroaEguneratu
		jokoa.jok1.aurkariarenTableroaEguneratu();
		jokoa.jokPC.aurkariarenTableroaEguneratu();
		//Partida hasi: jok1 hasiko da
		jokoa.PCTxanda=false;
		boolean jok1Bukatu= !(jokoa.jok1.jokalariBatenOntziGuztiakAurkitu());
		boolean jokPCBukatu= !(jokoa.jokPC.jokalariBatenOntziGuztiakAurkitu());
		while (!jok1Bukatu && !jokPCBukatu) { //PARTIDA NOIZ BUKATU
			//tiroEman
		//	ArmamentuaAukeratu ar= ArmamentuaAukeratu.
			//ukitu badu--> turnoa berea izaten jarraitu
			//else
				if (jokoa.PCTxanda) { //TXANDAK KONTROLATU
				//	jokoa
					jokoa.PCTxanda=false;
				}else {
					jokoa.jok1.tiroJaso();
					jokoa.PCTxanda=true;
				}
		}
		if (jok1Bukatu) {
			jokoa.PCTxanda=false;
		}else {
			jokoa.PCTxanda=true;
		}
		//Irabazlea irabazle= new Irabazlea();
		//irabazle.setVisible(true);*/
	}
	

}
