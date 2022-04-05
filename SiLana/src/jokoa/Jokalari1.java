package jokoa;

public class Jokalari1 extends Jokalari {
	
	private Jokalari1() {
		super();
	}
	
	public static Jokalari getNeureJok() {
		if (nJok==null) {
			nJok= new Jokalari1();
		}
		return nJok;
	}
	
	@Override
	public void ontziakKokatu() {
		//x Tableroa-tik lortu
		//y Tableroa-tik lortu
		// norabidea Tablerotik lortu
		//ontzia ere
		int x;
		int y;
		char norabidea;
		Ontzi pOntzi;
		neureOntziakKokatu(x, y, norabidea, pOntzi);
		aurkariarenFlota=PC.getNeureJok().getAurkariarenFlota();
		
	}
}
