package jokoa;

import bista.ArazoOntziKokatu;
import bista.TableroaBista;

import java.util.Observable;
import java.util.Observer;

public class Tablero extends Observable {
	private Gelaxka[][] taula;
	private static Tablero tabPC = null;
	private static Tablero tabJok = null;
	//private boolean[][] ezinJarri;
	
	//metodo eraikitzaileak 
	private Tablero() {
		taula= new Gelaxka[10][10];
		sortuTableroa();
	}
		
	//gainerako metodoak
	public static Tablero getTableroPC() {
		System.out.println("tablero --> getTableroPC");
		if (tabPC == null) {
				tabPC= new Tablero();	
		}
		return tabPC;
	}
	
	public static Tablero getTableroJok() {
		System.out.println("tablero --> getTableroJok");
		if (tabJok == null) {
				tabJok= new Tablero();	
		}
		return tabJok;
	}
	
	private void sortuTableroa() {
		System.out.println("tablero --> sortuTableroa");
		for (int i=0;i<10;i++) {
			for (int j=0; j<10;j++) {
				taula[i][j]= new Gelaxka(i,j);
			}
		}
	}
	
	public void tiroEman(int x, int y, Arma pArma) {
		System.out.println("tablero --> tiroEman");
		System.out.println(pArma);
		pArma.tiroArma(x,y);
		if (!taula[x][y].getUraDa()) {
			taula[x][y].getOntzia().aldatuEg();
		}
		egoeraAldatu();
	}
	
	
	public boolean tiroJasoDu (int x, int y) {
		System.out.println("tablero --> tiroJasoDu");
		System.out.println(x+"X,"+y+"Y");
		return taula[x][y].getTiroJaso();
	}
	public boolean begistatuDA( int x, int y) {
		System.out.println("tablero --> begistatuDa");
		return taula[x][y].getBegistatuta();
	}
	
	public Ontzi getOntzia(int x, int y) {
		System.out.println("tablero --> getOntziMota");
		return taula[x][y].getOntzia();
	}
	
	
	//TODO Exception tratatu behar
	public boolean ontziaJarri(int x, int y, Ontzi pOntzi, char norabidea, boolean aleatorio) {
		System.out.println("tablero --> ontziaJarri");
		System.out.println("tablero --> ontziaJarri --> ONTZIAK KOKATU: " + Pertsona.getNeureJok().badagoKokatuGabekoOntzirik());
		boolean tokiaDago=false;
		System.out.println("tablero--> ontziaJarri--> ONTZIA"+pOntzi);
		int tamaina=pOntzi.getOntziTamaina();
		System.out.println(pOntzi);
		System.out.println(x+" X "+y+" y ");
		System.out.println(tamaina+"tamaina, TABLERO ");
		System.out.println(norabidea);
		Jokoa jok= Jokoa.getNireJoko();
		boolean PCtx= jok.PCTxandaDa(); //Noren txanda den ere adierazten du
		if (x>=0 && y>=0) {
			if (norabidea == 'H'){
				System.out.println("HORIZONTAL");
				if (x+tamaina-1 < 10) {
					System.out.println("A");
					tokiaDago = tokiaKonprobatu(x, y, tamaina, norabidea);
					System.out.println("B");
					if (tokiaDago) {
						for (int i=0; i<tamaina; i++) {
							taula[x+i][y].ontziaJarri(pOntzi);
						}
					} else {
						System.out.println(PCtx+"PC txanda"+aleatorio);
						if (!PCtx && !aleatorio) {
							ArazoOntziKokatu arazo= new ArazoOntziKokatu();
							System.out.println("Ontzi jarri nahi duzun gelaxkaren bat jada beste ontzi batengatik okupatuta dago");
							arazo.setVisible(true);
						}
							//3 aukera:
							//ontziaNonKokatu
						// Bestela
							// modu random baten gu aukeratu
					}
					//jarrita = tokiaDago;
				} else {
					if (!PCtx && !aleatorio) {
						ArazoOntziKokatu arazo= new ArazoOntziKokatu();
						System.out.println("Matrizetik ateratzen da");
						arazo.setVisible(true);
					}
				}
			} else {
				System.out.println("VERTICAL");
				if (y+tamaina-1 < 10) {
					tokiaDago = tokiaKonprobatu(x, y, tamaina, norabidea);
					if (tokiaDago) {
						for (int i=0; i<tamaina; i++) {
							taula[x][y+i].ontziaJarri(pOntzi);
						}
					} else {
						/*if (PCtx) {
							Jokalari jokPC = PC.getNeureJok();
							jokPC.ontziakKokatu();
							System.out.println(x);
							System.out.println(y);
							System.out.println(tamaina); 
							System.out.println(norabidea);
						} else*/ if (!PCtx && !aleatorio) {
						//else {
							ArazoOntziKokatu arazo = new ArazoOntziKokatu();
							System.out.println("Ontzi jarri nahi duzun gelaxkaren bat jada beste ontzi batengatik okupatuta dago");
							arazo.setVisible(true);
						}	
					}
				//	jarrita = tokiaDago;
				} else {
					if (!PCtx && !aleatorio) {
						ArazoOntziKokatu arazo = new ArazoOntziKokatu();
						System.out.println("Matrizetik ateratzen da");
						arazo.setVisible(true);
					}
				}
			} //EXCEPTION IGUAL KANPOAN TRATATU BEHAR?? BOOLEAN BAT RETURN?
			egoeraAldatu();
		} else {
			ArazoOntziKokatu arazo= new ArazoOntziKokatu();
			arazo.setVisible(true);
		}
		return tokiaDago;
	}
	private boolean tokiaKonprobatu(int x, int y, int tamaina, char norabidea) {
		System.out.println("tablero --> tokiaKonprobatu");
		boolean emaitza = true;
		int imax, jmax, i, j;
		if (norabidea == 'H') {
			imax = x + tamaina-1;
			jmax = y ;
			while(x<=imax && emaitza) {
				if (jmax >= 0 && jmax < 10 && imax >= 0 && imax < 10) {
					emaitza= taula[imax][jmax].getUraDa();
					if (taula[imax][jmax].getEzinJarri()) {
						emaitza= !taula[imax][jmax].getEzinJarri();
					}
					imax--;
				} else {
					emaitza=false;
				}
			}
		} else {
			imax = x;
			jmax = y + tamaina-1;
			while(y<=jmax && emaitza) {
				if (jmax >= 0 && jmax < 10 && imax >= 0 && imax < 10) {
					emaitza= taula[imax][jmax].getUraDa();
					if (taula[imax][jmax].getEzinJarri()) {
						emaitza= !taula[imax][jmax].getEzinJarri();
					}
					jmax--;
				}
				else {
					emaitza=false;
				}
			}
		}
			
		if (norabidea == 'H') {
			imax = x + tamaina;
			jmax = y + 1;
		} else {
			imax = x + 1;
			jmax = y + tamaina;
		}
		i = x-1;
		while (i<=imax && emaitza) {
			j = y-1;
			while (j<=jmax && emaitza) {
				if (j >= 0 && j < 10 && i >= 0 && i < 10) {
					taula[i][j].setEzinJarri();
					System.out.println(i+"x , "+j+"y ");
				}
				j++;
			}
			i++;
		}	
		//}
		System.out.println(emaitza+"/////");
		return emaitza;
	}
	
	/*private boolean tokiaKonprobatu(int x, int y, int tamaina, char norabidea) {
		System.out.println("tablero --> tokiaKonprobatu");
		boolean emaitza = true;
		int imax, jmax, j=y-1, i=x-1 ;
		if (i<0) {
			i=0;
		}if (j<0) {
			j=0;
		}
		if (norabidea == 'H') {
			imax = x + tamaina;
			jmax= y+1;
			if (jmax>9) {
				jmax=9;
			}
			if (imax>9) {
				imax=9;
			}
			System.out.println(jmax+"jmax"+j);
			System.out.println(imax+"imax"+i);
			while (j<=jmax && emaitza) {
				while(i<=imax && emaitza) {
					if (imax >= 0 && imax < 10) {
						emaitza= taula[imax][jmax].getUraDa() && !taula[imax][jmax].getEzinJarri();
						System.out.println("======="+taula[imax][jmax].getUraDa());
						System.out.println("%%%%%%%%%"+taula[imax][jmax].getEzinJarri());
						//if (taula[imax][jmax].getEzinJarri()) {
									//emaitza= !taula[imax][jmax].getEzinJarri();
								//}
						imax--;
					} else {
						emaitza=false;
					}
				}
				jmax--;
				imax=x + tamaina;
				if (imax>9) {
					imax=9;
				}
			}
		} else {
			jmax =  y + tamaina;
			imax=x+1;
			if (imax>9) {
				imax=9;
			}
			if (jmax>9) {
				jmax=9;
			}
			System.out.println(jmax+"jmax"+j);
			System.out.println(imax+"imax"+i);
			while (i<=imax && emaitza) {
				while(y<=jmax && emaitza) {
					if (jmax >= 0 && jmax < 10) {
						emaitza= taula[imax][jmax].getUraDa() && !taula[imax][jmax].getEzinJarri();
							/*if (taula[imax][jmax].getEzinJarri()) {
								emaitza= !taula[imax][jmax].getEzinJarri();
							}*/
					/*	jmax--;
					}else {
						emaitza=false;
					}
				}
				jmax=y+tamaina;
				if (jmax>9) {
					jmax=9;
				}
				imax--;
			}
		}		
		System.out.println(emaitza+"/////");
		return emaitza;
	}*/
	
	public boolean[][] getUraDa(){
		System.out.println("tablero --> getUraDa");
        boolean[][] emaitza= new boolean[10][10];
        for (int i = 0; i <10; i++) {
            for (int j = 0; j < 10; j++) {
                emaitza[i][j]=taula[i][j].getUraDa();
            }
        } return emaitza;	
	}
	public Gelaxka getGelaxka(int x, int y) {
		System.out.println("tablero --> getGelaxka");
		System.out.println(x+"X "+y+"y");
		return taula[x][y];
	}
	
	//---------- Observablearekin zerikusia
	
	public void egoeraAldatu() {
		System.out.println("tablero --> egoeraAldatu");
        setChanged();
        notifyObservers();
    }
	
}
