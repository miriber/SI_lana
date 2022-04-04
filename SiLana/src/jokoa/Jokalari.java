package jokoa;

public abstract class Jokalari {
	private Flota neureFlota ;
	protected Flota aurkariarenFlota;
	protected static Jokalari nJok=null;
	//private String izena;
	
	public  Jokalari(/*String pIzena*/) {
		//izena=pIzena;
		neureFlota= new Flota();
		aurkariarenFlota= new Flota();
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
	
	protected void neureOntziakKokatu() {
		neureFlota.ontziakKokatu();
	}
	
	public abstract void ontziakKokatu();
	
	public Flota getAurkariarenFlota() {
		return aurkariarenFlota;
	}
	
}
