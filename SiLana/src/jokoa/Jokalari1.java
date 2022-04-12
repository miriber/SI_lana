package jokoa;

import bista.ArmamentuaAukeratu;
import bista.JadaTiroEginBista;
import bista.OntziNorabidea;
import bista.OntziaErabaki;
import bista.Tableroa;


public class Jokalari1 extends Jokalari {
	
	private static Jokalari1 nJok1=null;
	
	private Jokalari1() {
		super();
	}
	
	public static Jokalari getNeureJok() {
		if (nJok1==null) {
			nJok1= new Jokalari1();
		}
		return nJok1;
	}
	
	
	public void ontziakKokatu() {
		Tableroa tab=Tableroa.getNireTableroa();
		//Tableroan sakatutako gelaxkaren x eta y lortu	
		int i=0;
		System.out.println(i+"oijnjjnnhjn");
		i++;
		int x=tab.getTablerotikOntziX();
		int y=tab.getTablerotikOntziY();
		//Aukeratutako ontzia lortu
		OntziaErabaki erabikitakoOntzi= OntziaErabaki.getNireOntziaErabaki();
		Ontzi pOntzi= erabikitakoOntzi.getAukeraketa();
		//Ontziaren norabidea lortu
		OntziNorabidea ontziNorab= OntziNorabidea.getNireOntziNorabidea();
		char orientazioa= ontziNorab.getOrientazioa();
		neureOntziakKokatu(x, y, orientazioa, pOntzi);
		//TODO EXCEPTION 
		
	}
	
	@Override
	public void aurkariarenTableroaEguneratu() {
		aurkariarenTableroa=PC.getNeureJok().getAurkariarenTablero();
	}

	@Override
	public boolean tiroJaso() {
		Tableroa tab= Tableroa.getNireTableroa();
		int x=tab.getTablerotikOntziX();
		int y=tab.getTablerotikOntziY();
		if (aurkariarenTableroa.tiroJasoDu(x, y)) {
			JadaTiroEginBista arazoa= new JadaTiroEginBista();
			arazoa.setVisible(true);
		}
		ArmamentuaAukeratu arm= ArmamentuaAukeratu.getNireArmamentua();
		Arma arma= arm.getAukeratutakoa();
		Ontzi ontzi = aurkariarenTableroa.getOntziMota(x,y);	
		boolean turnoPasa=false;
		aurkariarenTableroa.tiroEman(x,y); //tiroJaso=true, berdin du
		if (ontzi==null) {
			turnoPasa=true;
		}else{
			if (arma instanceof Bonba) {
				ontzi.zenbatFaltaKenBat();
			}else if(arma instanceof Misila){
				ontzi.zenbatFaltaZero();
			}
			ontzi.aldatuEg();
			if (ontzi.getEgoera(Egoera.HONDORATUTA)) {
				neureFlota.ontziaKendu(ontzi);	
				//TODO Ez da Pc-rena kendu behar?
			}
		}
		return turnoPasa;
	}
		
			
		
}
