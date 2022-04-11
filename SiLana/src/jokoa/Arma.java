package jokoa;

public abstract class Arma {
	
	private String a1;
	
	public Arma(String pArma) {
		a1=pArma;
	}
	
	public boolean klaseBerekoa(String pArma) {
		boolean emaitza=false;
		if (this instanceof Bonba) {
			if (pArma.equals("Bonba")) {
				emaitza=true;
			}
		}else {
			if (pArma.equals("Misila")) {
				emaitza=true;
			}
		}
		return emaitza;
	}
	
	public String getArma() {
		return a1;
	}
}
