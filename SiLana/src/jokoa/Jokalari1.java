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
		neureOntziakKokatu();
		aurkariarenFlota=PC.getNeureJok().getAurkariarenFlota();
		
	}
}
