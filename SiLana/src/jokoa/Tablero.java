package jokoa;

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
	
	public void tiroJaso(int x, int y) {
		taula[x][y].tiroJaso();
	}
	
	public Ontzi getOntziMota(int x, int y) {
		return taula[x][y].getOntziMota();
	}
	
	//TODO Exception tratatu behar
	public void ontziaJarri(int x, int y, Ontzi pOntzi, char norabidea) {
		boolean jadaBesteOntzi=false;
		int tamaina=pOntzi.getOntziTamaina();
		if (norabidea=='H'){
			if (x+tamaina-1<10) {
				for (int i=0;i<tamaina && !jadaBesteOntzi;i++) {
					System.out.println("X:"+x+"Y:"+y+"i"+i);
					System.out.println(taula[x+i][y]);
					//System.out.println(taula[x+i][y].getUraDa()+"ONTZIAJARRI");
					jadaBesteOntzi=!(taula[x+i][y].getUraDa());
				} 
				if (!jadaBesteOntzi) {
					for (int i=0; i<tamaina; i++) {
						taula[x+i][y].ontziaJarri(pOntzi);
					}
				}else {
					System.out.println("Ontzi jarri nahi duzun gelaxkaren bat jada beste ontzi batengatik okupatuta dago");
					//3 aukera:
					//ontziaNonKokatu
				// Bestela
					// modu random baten gu aukeratu
				}
			}else {
				//ERROR: MATRIZETIK AT GELDITU
				//3 aukera:
					//ontziaNonKokatu
				// Bestela
					// modu random baten gu aukeratu
			}
		}else {
			if (y+tamaina-1<10) {
				for (int i=0;i<tamaina && !jadaBesteOntzi;i++) {
					jadaBesteOntzi=!(taula[x][y+i].getUraDa());
				} if (!jadaBesteOntzi) {
					for (int i=0; i<tamaina; i++) {
						taula[x][y+i].ontziaJarri(pOntzi);
					}
				}else {
					//ERROR: JADA BESTE ONTZI BAT
					//3 aukera:
					//ontziaNonKokatu
				// Bestela
					// modu random baten gu aukeratu
				}
			}else {
				//ERROR: MATRIZETIK AT GELDITU
			}
		} //EXCEPTION IGUAL KANPOAN TRATATU BEHAR?? BOOLEAN BAT RETURN?
	}
	
//	public 
	
	//---------- Observablearekin zerikusia
	
}
