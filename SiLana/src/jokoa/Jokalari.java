package jokoa;

import java.util.ArrayList;
import java.util.Random;

public abstract class Jokalari {
	protected Flota neureFlota ;
	protected Tablero neureTablero;
	//protected Tablero aurkariarenTableroa;
	
	public Jokalari() {
		System.out.println("yyyyyyyyyyyyyyyyyyyyyyy");
		neureFlota= new Flota();
	}
	
	protected void neureOntziakKokatu(int x, int y, char norabidea, Ontzi pOntzi, boolean aleatorio) {
		System.out.println("jokalari --> neureOntziakKokatu");
		System.out.println("jokalari--> neureOntziakKokatu --> ONTZIAK KOKATU: " + Pertsona.getNeureJok().badagoKokatuGabekoOntzirik());
		System.out.println(aleatorio);
		boolean jarrita = neureTablero.ontziaJarri(x, y, pOntzi, norabidea, aleatorio);
		if (jarrita) {
			pOntzi.setNorabidea(norabidea);
			neureFlota.gehituOntzi(pOntzi);	//behin tableroan jarrita dagoela, unekoZer gehitu pOntzi
		} 
	}
	
	public abstract void ontziakKokatu();
	// beharrezkoa da ontziakKokatu() jok1-n?? ez du balio neureOntziakKokatu public jarriz?
	
	public void aleatorioOntziakKokatu() {
		System.out.println("pc --> ontziakKokatu");
		Random random = new Random();
		char[] norabideAukerak="HB".toCharArray();
		int x,y;
		char norabidea;
		while (badagoKokatuGabekoOntzirik()) {
			x = random.nextInt(100);	//matrizeko buttonak 0-tik 100-ra arteko balioak izango balute moduan jokatu
			y = x%10; //hondarra ateratzeko, honek y-ren balioa emango du
			x = x/10;
			norabidea = norabideAukerak[random.nextInt(2)];
			ArrayList<Ontzi> ontziPosibleak=ontziPosibleakItzuli();	
			neureOntziakKokatu(x,y,norabidea, ontziPosibleak.get(0), true);	
		}
	}
	
	public Tablero getNeureTablero() {
		System.out.println("jokalari --> getNeureTablero");
		return neureTablero;
	}	
	
	public boolean badagoKokatuGabekoOntzirik() {
		System.out.println("jokalari --> badagoKokatuGabekoOntzirik");
		return !neureFlota.ontziDenakKokatuta();
	}
	
	public ArrayList<Ontzi> ontziPosibleakItzuli() {
		System.out.println("jokalari --> ontziPosibleakItzuli");
		return neureFlota.lortuOntziPosibleak();
	}
	
	public int ontziKop(Ontzi pOntzi) {
		System.out.println("jokalari--> ontziKop");
		return neureFlota.motaHonetakoZenbatOntziGelditu(pOntzi);
	}
	
	public ArrayList<String> ontziPosibleMotakItzuli() {
		System.out.println("jokalari --> ontziPosibleaMotakItzuli");
		return neureFlota.lortuOntziPosibleMotak();
	}
	
	public ArrayList<String> armaPosibleMotakItzuli() {
		System.out.println("jokalari --> armaPosibleaMotakItzuli");
		return neureFlota.lortuArmaPosibleMotak();
	}
	
	public ArrayList<Arma> armaPosibleakItzuli() {
		System.out.println("jokalari --> armaPosibleakItzuli");
		return neureFlota.lortuArmaPosibleak();
	}
	
	public abstract void tiroEgin();
	
	public boolean jokalariBatenOntziGuztiakAurkitu() {
		System.out.println("jokalari --> jokalariBatenOntziGuztiakAurkitu");
		return neureFlota.ontziDenakAurkituta();
	}
	
	//Biltegiarekin zerikusia duten metodoak
	public abstract void erosiArma();
	
	public int getDiru() {
		return neureFlota.getDirua();
	}
}
