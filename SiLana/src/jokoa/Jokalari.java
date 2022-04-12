package jokoa;

public abstract class Jokalari {
	protected Flota neureFlota ;
	protected Tablero neureTablero;
	protected Tablero aurkariarenTableroa;
	
	public Jokalari() {
		neureFlota= new Flota();
		neureTablero= new Tablero();
		aurkariarenTableroa= new Tablero();
	}
	
	
	protected void neureOntziakKokatu(int x, int y, char norabidea,Ontzi pOntzi) {
		neureTablero.ontziaJarri(x, y, pOntzi, norabidea);
		neureFlota.gehituOntzi(pOntzi);	//behin tableroan jarrita dagoela, unekoZer gehitu pOntzi
	}
	

	public abstract void ontziakKokatu();
	// beharrezkoa da ontziakKokatu() jok1-n?? ez du balio neureOntziakKokatu public jarriz?
	
	protected Tablero getAurkariarenTablero() {
		return aurkariarenTableroa;
	}
	
	public abstract void aurkariarenTableroaEguneratu();
	
	
	public boolean badagoKokatuGabekoOntzirik() {
		return !neureFlota.ontziDenakKokatuta();
	}
	
	public Ontzi[] ontziPosibleakItzuli() {
		return neureFlota.lortuOntziPosibleak();
	}
	
	public Arma[] armaPosibleakItzuli() {
		return neureFlota.lortuArmaPosibleak();
	}
	
	public abstract void tiroEgin();
	
	public boolean jokalariBatenOntziGuztiakAurkitu() {
		return neureFlota.ontziDenakAurkituta();
	}
	
	protected void ontziaJarri (Arma arma, Ontzi ontzi) {
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
	
}
