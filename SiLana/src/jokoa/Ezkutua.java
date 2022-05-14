package jokoa;

public class Ezkutua extends Arma {
	public Ezkutua() {
		super("Ezkutua");
	}
	public void tiroArma(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("Misila --> tiroArma");
		int i=x, j=y;
		Tablero unekoTab=Pertsona.getNeureJok().getNeureTablero();
		if (Jokoa.getNireJoko().PCTxandaDa()) {
			unekoTab=PC.getNeureJok().getNeureTablero();
		}
		Gelaxka unekoGelaxka= unekoTab.getGelaxka(x, y);
		if (!unekoGelaxka.getUraDa() && unekoGelaxka.getOzkolaBizitza()!=0) {
			unekoGelaxka.ozkola();
			boolean kanpoan = false;
			char norabidea = unekoGelaxka.getOntzia().getNorabidea();
			while (!kanpoan) {
				if (norabidea == 'H' && i > 0) {
					i--;
					unekoGelaxka=unekoTab.getGelaxka(i, j);
					if(!unekoGelaxka.getUraDa()) {
						unekoGelaxka.ozkola();
					}else {
						kanpoan = true;
					}
					
				} else if (norabidea == 'B' && j > 0) {
					j--;
					unekoGelaxka=unekoTab.getGelaxka(i, j);
					if(!unekoGelaxka.getUraDa()) {
						unekoGelaxka.ozkola();
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
					if(!unekoGelaxka.getUraDa()) {
						unekoGelaxka.ozkola();
					}else {
						kanpoan = true;
					}
					
				} else if (norabidea == 'B' && j < 9) {
					j++;
					if(!unekoGelaxka.getUraDa()) {
						unekoGelaxka.ozkola();
					}else {
						kanpoan = true;
					}
					
				} else {
					kanpoan = true;
				}
			}
			unekoGelaxka=unekoTab.getGelaxka(x, y);
			unekoGelaxka.getOntzia().zenbatFaltaZero();	
			//TODO AURREKO KOMANDOA GOIAN JARRI DAITEKE
		}else if(unekoGelaxka.getOzkolaBizitza()!=0) {
			unekoGelaxka.setOzkolaBizitza(0);
		}
		
		
	}
	@Override
	public boolean klaseBerekoa(String pArma) {
		// TODO Auto-generated method stub
		return pArma.contentEquals("Ezkutua");
	}
}
