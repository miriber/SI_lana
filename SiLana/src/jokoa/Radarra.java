package jokoa;

public class Radarra extends Arma {
	public Radarra() {
		super("Radarra");
	}
	public void tiroArma(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("Radarra --> tiroArma");
		Tablero unekoTab=super.getAurkariarenTab();
		Gelaxka unekoGelaxka= unekoTab.getGelaxka(x, y);
		unekoGelaxka.tiroJaso();
		int xMax = x + 1 ;
		int yMax = y + 1 ;
		if (xMax>9) {
			xMax=9;
		}
		if (yMax>9) {
			yMax=9;
		}
		int i = x-1;
		if (i<0) {
			i=0;
		}
		while (i<=xMax) {
			int j = y-1;
			if (j<0) {
				j=0;
			}
			while (j<=yMax ) {
				if (j >= 0 && j < 10 && i >= 0 && i < 10) {
					unekoGelaxka.begistatuta();
				}
				j++;
				if (j<10) {
					unekoGelaxka=unekoTab.getGelaxka(i, j);
				}
			}
			i++;
			j--;
			if (i<10) {
				unekoGelaxka=unekoTab.getGelaxka(i, j);
			}
		}
	}
	@Override
	public boolean klaseBerekoa(String pArma) {
		// TODO Auto-generated method stub
		return pArma.contentEquals("Radarra");
	}
}
