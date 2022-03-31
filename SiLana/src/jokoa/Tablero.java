package jokoa;

public class Tablero {
	private Gelaxka[][] taula;
	public static Tablero nireTableroa= null;	//EMA
	
	//metodo eraikitzaileak 
	private Tablero() {
		taula= new Gelaxka[10][10];
	}
	
	public static Tablero getNireTablero() {
		if (nireTableroa==null) {
			nireTableroa= new Tablero();
		}return nireTableroa;
	}
	
	//gainerako metodoak
	private void sortuTableroa() {
		for (int i=0;i<10;i++) {
			for (int j=0; i<10;i++) {
				taula[i][j]= new Gelaxka(i,j);
			}
		}
	}
	
	public void ontziaJarri(int x, int y, int tamaina, String norabidea) {
		boolean jadaBesteOntzi=false;
		if (norabidea.contentEquals("Horizontala") ){
			if (x+tamaina<10) {
				for (int i=0;i<tamaina && !jadaBesteOntzi;i++) {
					jadaBesteOntzi=taula[x+i][y].getUraDa();
				} if (!jadaBesteOntzi) {
					for (int i=0; i<tamaina; i++) {
						taula[x+i][y].ontziaJarri();
					}
				}else {
					//ERROR: JADA BESTE ONTZI BAT
				}
			}else {
				//ERROR: MATRIZETIK AT GELDITU
			}
		}else {
			if (y+tamaina<10) {
				for (int i=0;i<tamaina && !jadaBesteOntzi;i++) {
					jadaBesteOntzi=taula[x][y+i].getUraDa();
				} if (!jadaBesteOntzi) {
					for (int i=0; i<tamaina; i++) {
						taula[x][y+i].ontziaJarri();
					}
				}else {
					//ERROR: JADA BESTE ONTZI BAT
					//aukeratu beste matrize botoi bat
				}
			}else {
				//ERROR: MATRIZETIK AT GELDITU
			}
		}
	}
	
}
