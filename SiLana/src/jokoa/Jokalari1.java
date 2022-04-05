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
		int x;
		int y;
		String norabidea;
		neureOntziakKokatu(x, y, norabidea);
		aurkariarenFlota=PC.getNeureJok().getAurkariarenFlota();
		
	}
}
