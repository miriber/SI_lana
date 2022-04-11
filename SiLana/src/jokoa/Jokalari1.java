package jokoa;

import bista.ArmamentuaAukeratu;
import bista.OntziNorabidea;
import bista.OntziaErabaki;
import bista.Tableroa;


public class Jokalari1 extends Jokalari {
	
	private Jokalari1() {
		super();
	}
	
	public static Jokalari getNeureJok() {
		if (nJok==null) {
			nJok= new Jokalari1();
		}
		return nJok;
	}
	
	
	public void ontziakKokatu() {
		Tableroa tab=Tableroa.getNireTableroa();
		//Tableroan sakatutako gelaxkaren x eta y lortu	
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
	public void tiroJaso() {
		Tableroa tab= Tableroa.getNireTableroa();
		int x=tab.getTablerotikOntziX();
		int y=tab.getTablerotikOntziY();
		ArmamentuaAukeratu arm= ArmamentuaAukeratu.getNireArmamentua();
		Arma arma= arm.getAukeratutakoa();
		Ontzi ontzi = neureTablero.getOntziMota(x,y);	
		neureTablero.tiroJaso(x,y);
		if (arma instanceof Bonba) {
			ontzi.zenbatFaltaKenBat();
		}else if(arma instanceof Misila){
			ontzi.zenbatFaltaZero();
		}
		ontzi.aldatuEg();	
		if (ontzi.getEgoera(Egoera.HONDORATUTA)) {
			neureFlota.ontziaKendu(ontzi);				
		}
			
	}
		
}
