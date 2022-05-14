package jokoa;

import java.util.ArrayList;
import java.util.Random;

import bista.ArmamentuaAukeratu;
import bista.JadaTiroEginBista;
import bista.TableroaBista;

public class PC extends Jokalari {
	
	private Random random;
	private char[] norabideAukerak;
	private static PC nJokPC=null;
	

	private PC() {
		super();
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		neureTablero = Tablero.getTableroPC();
		random= new Random();
		norabideAukerak="HB".toCharArray(); //H--> Horizontala
							//B--> Bertikala
	}
	
	public static Jokalari getNeureJok() {
		System.out.println("pc --> getNeureJok");
		if (nJokPC==null) {
			nJokPC= new PC();
		}
		return nJokPC;
	}
	
	public void hasieraketaOndo() {
		System.out.println("pc --> hasieraketaOndo");
		System.out.println();
	}
	
	/*public void ontziakKokatu() {
		System.out.println("pc --> ontziakKokatu");
		int x,y;
		char norabidea;
		while (badagoKokatuGabekoOntzirik()) {
			x = random.nextInt(100);	//matrizeko buttonak 0-tik 100-ra arteko balioak izango balute moduan jokatu
			y = x%10; //hondarra ateratzeko, honek y-ren balioa emango du
			x = x/10;
			norabidea = norabideAukerak[random.nextInt(2)];
			Ontzi[] ontziPosibleak=super.ontziPosibleakItzuli();
			neureOntziakKokatu(x,y,norabidea, ontziPosibleak[0]);	
		}
	}*/
	
	public void ontziakKokatu() {
		super.aleatorioOntziakKokatu();
	}

	@Override
	public void tiroEgin() {
		System.out.println("pc --> tiroEgin");
		TableroaBista tabBista = TableroaBista.getNireTableroa();
		Tablero aurkariTab = Pertsona.getNeureJok().getNeureTablero();
		int x = random.nextInt(100);	//matrizeko buttonak 0-tik 100-ra arteko balioak izango balute moduan jokatu
		int y = x%10; //hondarra ateratzeko, honek y-ren balioa emango du
		x = x/10;
		System.out.println("X: "+x+", Y: "+y);
		if (aurkariTab.tiroJasoDu(x, y)) {
			tiroEgin();
		} else {
			ArrayList<Arma> armamentua= PC.getNeureJok().armaPosibleakItzuli();
			Arma arma = armamentua.get(random.nextInt(armamentua.size()));
			//Ontzi ontzi = aurkariTab.getOntziMota(x,y);	
			//boolean turnoPasa=false;
			aurkariTab.tiroEman(x,y, arma);
		}
	}

	@Override
	public void erosiArma() {
		ArrayList <Arma> armaPos=Biltegia.getNireBiltegia().lortuDiruHorrekinArmaPosibleak(neureFlota.getDirua());
		int zenbAlt=random.nextInt(armaPos.size());
		Biltegia.getNireBiltegia().armaErosi(armaPos.get(zenbAlt));
		neureFlota.gehituArma(armaPos.get(zenbAlt));
	}


	
}
