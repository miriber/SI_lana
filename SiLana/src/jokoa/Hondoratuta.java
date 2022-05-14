package jokoa;

public class Hondoratuta extends Arma {
	public Hondoratuta() {
		super("Bonba");
	}
	
	public void tiroArma(int x, int y) {
		System.out.println("Bonba --> tiroArma");
		Tablero unekoTab=super.getAurkariarenTab();
		Gelaxka unekoGelaxka= unekoTab.getGelaxka(x, y);
		if(!unekoGelaxka.getUraDa() && unekoGelaxka.getOzkolaBizitza()==2) {
			unekoGelaxka.setOzkolaBizitza(1);
			System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL"+ "ozkolaUkituta");
		}else if(!unekoGelaxka.getUraDa() && unekoGelaxka.getOzkolaBizitza()==1) {
			unekoGelaxka.setOzkolaBizitza(0);
		}else if (unekoGelaxka.getOzkolaBizitza()==0) {
				unekoGelaxka.tiroJaso();
			if (!unekoGelaxka.getUraDa()) {
				unekoGelaxka.getOntzia().zenbatFaltaKenBat();
			}
		}
		
	}

	@Override
	public boolean klaseBerekoa(String pArma) {
		// TODO Auto-generated method stub
		return pArma.contentEquals("Bonba");
	}




}
