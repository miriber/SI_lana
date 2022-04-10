package jokoa;

import bista.ArazoOntziKokatu;

public class Tablero {
	private Gelaxka[][] taula;
	
	//metodo eraikitzaileak 
	public Tablero() {
		taula= new Gelaxka[10][10];
		sortuTableroa();
	}
		
	//gainerako metodoak
	private void sortuTableroa() {
		for (int i=0;i<10;i++) {
			for (int j=0; j<10;j++) {
				taula[i][j]= new Gelaxka(i,j);
			}
		}
	}
	
	public void tiroJaso(int x, int y, Ontzi pOntzi) {
		taula[x][y].tiroJaso();
	}
	//TODO Exception tratatu behar
	public void ontziaJarri(int x, int y, Ontzi pOntzi, char norabidea) {
		boolean jadaBesteOntzi=false;
		int tamaina=pOntzi.getOntziTamaina();
		System.out.println(pOntzi);
		System.out.println(x+"X"+y+"y");
		System.out.println(tamaina+"tamaina, TABLERO ");
		System.out.println(norabidea);
		ArazoOntziKokatu arazo= new ArazoOntziKokatu();
		if (norabidea=='H'){
			if (x+tamaina-1<10) {
				for (int i=0;!jadaBesteOntzi && i<tamaina ;i++) {
					//System.out.println("X:"+x+"Y:"+y+"i"+i);
					//System.out.println(taula[x+i][y].getUraDa()+"TABLERO2");
					jadaBesteOntzi=!(taula[x+i][y].getUraDa());
				} 
				if (!jadaBesteOntzi) {
					for (int i=0; i<tamaina; i++) {
						taula[x+i][y].ontziaJarri(pOntzi);
					}
				}else {
					System.out.println("Ontzi jarri nahi duzun gelaxkaren bat jada beste ontzi batengatik okupatuta dago");
					arazo.setVisible(true);
					//3 aukera:
					//ontziaNonKokatu
				// Bestela
					// modu random baten gu aukeratu
				}
			}else {
				arazo.setVisible(true);
				//ERROR: MATRIZETIK AT GELDITU
				//3 aukera:
					//ontziaNonKokatu
				// Bestela
					// modu random baten gu aukeratu
			}
		}else {
			if (y+tamaina-1<10) {
				for (int i=0; !jadaBesteOntzi && i<tamaina ;i++) {
					//System.out.println(taula[x][y+i].getUraDa()+"TABLERO2");
					jadaBesteOntzi=!(taula[x][y+i].getUraDa());
				} if (!jadaBesteOntzi) {
					for (int i=0; i<tamaina; i++) {
						taula[x][y+i].ontziaJarri(pOntzi);
					}
				}else {
					arazo.setVisible(true);
					//ERROR: JADA BESTE ONTZI BAT
					//3 aukera:
					//ontziaNonKokatu
				// Bestela
					// modu random baten gu aukeratu
				}
			}else {
				arazo.setVisible(true);
				System.out.println("Matrizetik at");
				//ERROR: MATRIZETIK AT GELDITU
			}
		} //EXCEPTION IGUAL KANPOAN TRATATU BEHAR?? BOOLEAN BAT RETURN?
	}
	
//	public 
	
	//---------- Observablearekin zerikusia
	
}
