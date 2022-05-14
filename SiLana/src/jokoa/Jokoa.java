package jokoa;

import bista.Irabazlea;
import bista.TableroaBista;


public class Jokoa {
	private boolean PCTxanda;
	private Jokalari jokPC;
	private Jokalari jok1;
	private static Jokoa nJoko=null;	//EMA
	
	//Metodo eraikitzailea
	private Jokoa() {
		PCTxanda=false;
		jokPC= PC.getNeureJok();
		jok1=Pertsona.getNeureJok();
		//System.out.println("JOK1" + jok1);
		//System.out.println("JOKPC" + jokPC);
		
	}
	public static Jokoa getNireJoko() {
		System.out.println("jokoa --> getNireJoko");
		if (nJoko==null) {
			nJoko=new Jokoa();
		}return nJoko;
	}
	
	
	public static void main(String args[]) {
		System.out.println("jokoa --> main");
		Jokoa jokoa= Jokoa.getNireJoko();
		jokoa.jokPC.ontziakKokatu();
	//	jokoa.txandaAldatu();
		TableroaBista tabBista= TableroaBista.getNireTableroa();
//		Tablero tabJok= jokoa.jok1.getNeureTablero();
		tabBista.tableroaIkusi();
		
		
		
	//	jokoa.txandakKudeatu();
		/*while (!jokoa.jok1.badagoKokatuGabekoOntzirik()) {
			jokoa.txandakKudeatu();
		}
		 * while (jokoa.jok1.badagoKokatuGabekoOntzirik()) { //ontzi guztiak kokatuta ez
		 * dauden bitartean
		 * 
		 * }
		 */
		
		//Ontziak Kokatu
		
		//jokooa.PCTxanda=true;
		// behin ontziak kokatuta daudela, aurkariarenTableroaEguneratu
		//Partida hasi: jok1 hasiko da: jokoa.PCTxanda=false;
		
		//Irabazlea irabazle= new Irabazlea();
		//irabazle.setVisible(true);*/
	}
	
	public boolean PCTxandaDa() {	//Irabazi jFrame erabili
		System.out.println("jokoa --> getTxanda");
		return PCTxanda;
	}
	
	public void txandaAldatu() {
		System.out.println("jokoa --> txandaAldatu");
	/*	boolean jokPCBukatu= !(jok1.jokalariBatenOntziGuztiakAurkitu());
		boolean jok1Bukatu= !(jokPC.jokalariBatenOntziGuztiakAurkitu());
		while (!jok1Bukatu && !jokPCBukatu) { //PARTIDA NOIZ BUKATU
			//tiroEman
		//	ArmamentuaAukeratu ar= ArmamentuaAukeratu.
			//ukitu badu--> turnoa berea izaten jarraitu
			//else
			if (PCTxanda) { //TXANDAK KONTROLATU
				jokPC.tiroEgin();
				PCTxanda=false;
			}else {
				jok1.tiroEgin();
				PCTxanda=true;
			}
		}
		if (jok1Bukatu) {
			PCTxanda=false;
		}else {
			PCTxanda=true;
		}*/
		PCTxanda = !PCTxanda;
		//return PCTxanda;
	}


}
