package jokoa;

import java.util.Random;

public class PC extends Jokalari {
	
	private Random random;
	private char[] norabideAukerak;
	

	private PC() {
		super();
		random= new Random();
		norabideAukerak="HB".toCharArray(); //H--> Horizontala
							//B--> Bertikala
	}
	
	public static Jokalari getNeureJok() {
		if (nJok==null) {
			nJok= new PC();
		}
		return nJok;
	}
	
	public void ontziakKokatu() {
		int x,y;
		char norabidea;
		while (badagoKokatuGabekoOntzirik()) {
			x=random.nextInt(100);	//matrizeko buttonak 0-tik 100-ra arteko balioak izango balute moduan jokatu
			y= x%10; //hondarra ateratzeko, honek y-ren balioa emango du
			x=x/10;
			norabidea=norabideAukerak[random.nextInt(2)];
			Ontzi[] ontziPosibleak=super.ontziPosibleakItzuli();
			neureOntziakKokatu(x,y,norabidea, ontziPosibleak[0]);	
		}
	}

	@Override
	public void aurkariarenTableroaEguneratu() {
		aurkariarenTableroa=Jokalari1.getNeureJok().getAurkariarenTablero();		
	}

	@Override
	public boolean tiroJaso() {
		int x,y;
		x=random.nextInt(100);	//matrizeko buttonak 0-tik 100-ra arteko balioak izango balute moduan jokatu
		y= x%10; //hondarra ateratzeko, honek y-ren balioa emango du
		x=x/10;
		while (aurkariarenTableroa.tiroJasoDu(x, y)) {	//gelaxka honi jada tiro egin zaio
			x=random.nextInt(100);	//matrizeko buttonak 0-tik 100-ra arteko balioak izango balute moduan jokatu
			y= x%10; //hondarra ateratzeko, honek y-ren balioa emango du
			x=x/10;
		}
		boolean txandaPasa = false;
		Arma[] armaPosibleak = armaPosibleakItzuli();
		Arma arma= armaPosibleak [random.nextInt(2)]; //2 arma desb daude: horietatik bat aukeratu aleatorioki
		Ontzi ontzi = aurkariarenTableroa.getOntziMota(x,y);
		if (ontzi==null) {
			txandaPasa=true;
		}else{
			if (arma instanceof Bonba) {
				ontzi.zenbatFaltaKenBat();
			}else if(arma instanceof Misila){
				ontzi.zenbatFaltaZero();
			}
			ontzi.aldatuEg();	
			if (ontzi.getEgoera(Egoera.HONDORATUTA)) {
				neureFlota.ontziaKendu(ontzi);				
			}
		}
		return txandaPasa;
	}
	
}
