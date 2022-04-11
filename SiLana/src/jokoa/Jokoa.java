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
		tab.tableroaIkusi();
		int i=0;
		//Ontziak Kokatu
		while (jokoa.jok1.badagoKokatuGabekoOntzirik()) { //ontzi guztiak kokatuta ez dauden bitartean
			jokoa.jok1.ontziakKokatu();
			i=i+1;
			System.out.println(i);
		}
		jokoa.PCTxanda=true;
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
					jokoa.PCTxanda=false;
				}else {
					jokoa.PCTxanda=true;
				}
		}
		if (jok1Bukatu) {
			jokoa.PCTxanda=false;
		}else {
			jokoa.PCTxanda=true;
		}
		//Irabazlea irabazle= new Irabazlea();
		//irabazle.setVisible(true);
	}
	

}
