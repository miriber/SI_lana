package jokoa;

public class PC extends Jokalari {

	private PC() {
		super();
	}
	
	public static Jokalari getNeureJok() {
		if (nJok==null) {
			nJok= new PC();
		}
		return nJok;
	}
	
	public void ontziakKokatu() {
		neureOntziakKokatu();
		aurkariarenFlota=Jokalari1.getNeureJok().getAurkariarenFlota();
	}
	
}
