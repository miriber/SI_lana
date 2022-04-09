package jokoa;

import java.util.ArrayList;

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
	
	@Override
	/*public void ontziakKokatu() {
		//x Tableroa-tik lortu
		//y Tableroa-tik lortu
		// norabidea Tablerotik lortu
		//ontzia ere
		int x;
		int y;
		char norabidea;
		Ontzi pOntzi;
		neureOntziakKokatu(x, y, norabidea, pOntzi);
		aurkariarenFlota=PC.getNeureJok().getAurkariarenFlota();
		
	}*/
	
/*	public void ontziakKokatu() {
		while (badagoKokatuGabekoOntzirik()) {	//ontzi guztiak kokatuta ez dauden bitartean
			//Tableroan sakatutako gelaxkaren x eta y lortu
			Tableroa tab=Tableroa.getNireTableroa();	
			int x= tab.getTablerotikOntziX();
			int y= tab.getTablerotikOntziY();
			System.out.println(x+"JOKOLARI1");
			//Aukeratutako ontzia lortu
			OntziaErabaki erabikitakoOntzi= OntziaErabaki.getNireOntziaErabaki();
			Ontzi pOntzi= erabikitakoOntzi.getAukeraketa();
			System.out.println(pOntzi+"JOKOLARI1");
			//System.out.println(pOntzi+"NORABIDEA");
			OntziNorabidea ontziNorab= OntziNorabidea.getNireOntziNorabidea();
			char orientazioa= ontziNorab.getOrientazioa();
			System.out.println(orientazioa+"JOKOLARI1");
			neureOntziakKokatu(x, y, orientazioa, pOntzi);
		}
		//TODO EXCEPTION 
		
	}*/


	public void besteJokTxanda() {
		txandaBuk();
		PC.getNeureJok().txandaHasi();		
	}

	@Override
	public void ontziakKokatu() {
		// TODO Auto-generated method stub
		//this.neureOntziakKokatu(x, y, norabidea, pOntzi);
	}
}
