package jokoa;

public class Misila extends Arma {
	public Misila() {
		super("Misila");
	}
	public void tiroArma(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("Misila --> tiroArma");
		int i=x, j=y;
		Tablero unekoTab=super.getAurkariarenTab();
		Gelaxka unekoGelaxka= unekoTab.getGelaxka(x, y);
		unekoGelaxka.tiroJaso();
		boolean kanpoan = unekoGelaxka.getUraDa();
		if (!kanpoan) {
			unekoGelaxka.getOntzia().zenbatFaltaZero();
			char norabidea = unekoGelaxka.getOntzia().getNorabidea();
			while (!kanpoan && i>0 && j>0) {
				if (norabidea=='H') {
					i--;
				}else {
					j--;
				}
				unekoGelaxka=unekoTab.getGelaxka(i, j);
				kanpoan=unekoGelaxka.getUraDa();
				if (!kanpoan) {
					unekoGelaxka.tiroJaso();
				}
			}
			kanpoan=false;
			i=x;
			j=y;
			while (!kanpoan && i<9 && j<9) {
				if (norabidea=='H') {
					i++;
				}else {
					j++;
				}
				unekoGelaxka=unekoTab.getGelaxka(i, j);
				kanpoan=unekoGelaxka.getUraDa();
				if (!kanpoan) {
					unekoGelaxka.tiroJaso();
				}
			}
		}
	}		/*while (!kanpoan && j>0) {
					j--;
					unekoGelaxka=unekoTab.getGelaxka(i, j);
					kanpoan=unekoGelaxka.getUraDa();
					if (!kanpoan) {
						unekoGelaxka.tiroJaso();
					}
				}
				if (j!=0) {
					kanpoan=false;
				}
				j=y;
				while ()
			}
		}
		
	
			while (!kanpoan) {
				if (norabidea == 'H' && i > 0) {
					i--;
					unekoGelaxka=unekoTab.getGelaxka(i, j);
					if(!unekoGelaxka.getUraDa()) {
						unekoGelaxka.tiroJaso();
					}else {
						kanpoan = true;
					}
					
				} else if (norabidea == 'B' && j > 0) {
					j--;
					unekoGelaxka=unekoTab.getGelaxka(i, j);
					if(!unekoGelaxka.getUraDa()) {
						unekoGelaxka.tiroJaso();
					}else {
						kanpoan = true;
					}
				} else {
					kanpoan = true;
				}
			}
			kanpoan = false;
			i=x;
			j=y;
			while (!kanpoan) {
				if (norabidea == 'H' && i < 9) {
					i++;
					unekoGelaxka=unekoTab.getGelaxka(i, j);
					if(!unekoGelaxka.getUraDa()) {
						unekoGelaxka.tiroJaso();
					}else {
						kanpoan = true;
					}
					
				} else if (norabidea == 'B' && j < 9) {
					j++;
					unekoGelaxka=unekoTab.getGelaxka(i, j);
					if(!unekoGelaxka.getUraDa()) {
						unekoGelaxka.tiroJaso();
					}else {
						kanpoan = true;
					}
					
				} else {
					kanpoan = true;
				}
			}
			unekoGelaxka.getOntzia().zenbatFaltaZero();	
		}
	}*/
	@Override
	public boolean klaseBerekoa(String pArma) {
		// TODO Auto-generated method stub
		return pArma.contentEquals("Misila");
	}
}
