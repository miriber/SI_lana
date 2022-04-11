package jokoa;

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
}
