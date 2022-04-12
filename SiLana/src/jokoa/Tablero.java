package jokoa;

import bista.ArazoOntziKokatu;
import java.util.Observable;
import java.util.Observer;

public class Tablero extends Observable {
	private Gelaxka[][] taula;
	private static Tablero tab;
	
	//metodo eraikitzaileak 
	public Tablero() {
		taula= new Gelaxka[10][10];
		sortuTableroa();
	}
		
	//gainerako metodoak
	public static Tablero getTablero() {
		tab= new Tablero();
		return tab;
	}
	private void sortuTableroa() {
		for (int i=0;i<10;i++) {
			for (int j=0; j<10;j++) {
				taula[i][j]= new Gelaxka(i,j);
			}
		}
	}
	
	public void tiroEman(int x, int y) {
		taula[x][y].tiroJaso();
	}
	
	public boolean tiroJasoDu (int x, int y) {
		return taula[x][y].getTiroJaso();
	}
	
	public Ontzi getOntziMota(int x, int y) {
		return taula[x][y].getOntziMota();
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
		Jokoa jok= Jokoa.getNireJoko();
		boolean PCtx= jok.getNorIrabazi(); //Noren txanda den ere adierazten du
		if (norabidea=='H'){
			if (x+tamaina-1<10) {
				for (int i=0;!jadaBesteOntzi && i<tamaina ;i++) {
					jadaBesteOntzi=!(taula[x+i][y].getUraDa());
				} if (!jadaBesteOntzi) {
					for (int i=0; i<tamaina; i++) {
						taula[x+i][y].ontziaJarri(pOntzi);
					}
				}else {
					if (PCtx) {
						Jokalari jokPC= PC.getNeureJok();
						jokPC.ontziakKokatu();
					}else{
						System.out.println("Ontzi jarri nahi duzun gelaxkaren bat jada beste ontzi batengatik okupatuta dago");
						arazo.setVisible(true);
					}
						//3 aukera:
						//ontziaNonKokatu
					// Bestela
						// modu random baten gu aukeratu
				}
			}else {
				if (PCtx) {
					Jokalari jokPC= PC.getNeureJok();
					jokPC.ontziakKokatu();
				}else{
					System.out.println("Matrizetik ateratzen da");
					arazo.setVisible(true);
				}
			}
		}else {
			if (y+tamaina-1<10) {
				for (int i=0; !jadaBesteOntzi && i<tamaina ;i++) {
					jadaBesteOntzi=!(taula[x][y+i].getUraDa());
				} if (!jadaBesteOntzi) {
					for (int i=0; i<tamaina; i++) {
						taula[x][y+i].ontziaJarri(pOntzi);
					}
				}else {
					if (PCtx) {
						Jokalari jokPC= PC.getNeureJok();
						jokPC.ontziakKokatu();
					}else{
						System.out.println("Ontzi jarri nahi duzun gelaxkaren bat jada beste ontzi batengatik okupatuta dago");
						arazo.setVisible(true);
					}	
				}
			}else {
				if (PCtx) {
					Jokalari jokPC= PC.getNeureJok();
					jokPC.ontziakKokatu();
				}else{
					System.out.println("Matrizetik at");
					arazo.setVisible(true);
				}
			}
		} //EXCEPTION IGUAL KANPOAN TRATATU BEHAR?? BOOLEAN BAT RETURN?
		egoeraAldatu();
	}
	
	public boolean[][] getUraDa(){
        boolean[][] emaitza= new boolean[10][10];
        for (int i = 0; i <10; i++) {
            for (int j = 0; j < 10; j++) {
                emaitza[i][j]=taula[i][j].getUraDa();
            }
        } return emaitza;	
	}
	
	//---------- Observablearekin zerikusia
	
	public void egoeraAldatu() {
        setChanged();
        notifyObservers();
    }
	
}
