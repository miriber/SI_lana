package jokoa;



import bista.ArmamentuaAukeratu;
import bista.JadaTiroEginBista;
import bista.OntziNorabidea;
import bista.OntziaErabaki;
import bista.TableroaBista;


public class Pertsona extends Jokalari {
	
	private static Pertsona nJok1=null;
	
	private Pertsona() {
		super();
		neureTablero = Tablero.getTableroJok();
	}
	
	public static Jokalari getNeureJok() {
		System.out.println("jokalari --> getNeureJok");
		if (nJok1 == null) {
			nJok1 = new Pertsona();
		}
		return nJok1;
	}
	
	
	public void ontziakKokatu() {
		System.out.println("jokalari --> ontziakKokatu");
		TableroaBista tab = TableroaBista.getNireTableroa();
		//Tableroan sakatutako gelaxkaren x eta y lortu	
		int x = tab.getTablerotikOntziX();
		int y = tab.getTablerotikOntziY();
		//Aukeratutako ontzia lortu
		OntziaErabaki erabikitakoOntzi = OntziaErabaki.getNireOntziaErabaki();
		Ontzi pOntzi = erabikitakoOntzi.getAukeraketa();
		//Ontziaren norabidea lortu
		OntziNorabidea ontziNorab = OntziNorabidea.getNireOntziNorabidea();
		char orientazioa = ontziNorab.getOrientazioa();
		neureOntziakKokatu(x, y, orientazioa, pOntzi, false);		
	}

	@Override
	public void tiroEgin() {
		System.out.println("jokalari1 --> tiroEgin");
		TableroaBista tabBista = TableroaBista.getNireTableroa();
		Tablero aurkariTab = PC.getNeureJok().getNeureTablero();
		int x = tabBista.getTablerotikOntziX();
		int y = tabBista.getTablerotikOntziY();
		if (aurkariTab.tiroJasoDu(x, y)) {
			JadaTiroEginBista arazoa = new JadaTiroEginBista();
			arazoa.setVisible(true);
		} else {
			ArmamentuaAukeratu arm = ArmamentuaAukeratu.getNireArmamentua(false);
			Arma arma = arm.getAukeratutakoa();
			//Ontzi ontzi = aurkariTab.getOntziMota(x,y);	
			//boolean turnoPasa=false;
			aurkariTab.tiroEman(x, y, arma); //tiroJaso=true, berdin du
			neureFlota.armamentuaErabili(arma);	//behin tableroan jarrita dagoela, unekoZer gehitu pOntzi
			
			
			//if (ontzi==null) {
				//turnoPasa=true;
			//}else{
			//return turnoPasa;
		}
		
	}

	@Override
	public void erosiArma() {
		Arma pArma= ArmamentuaAukeratu.getNireArmamentua(true).getAukeratutakoa();
		Biltegia bilt= Biltegia.getNireBiltegia();
		bilt.armaErosi(pArma);
		neureFlota.gehituArma(pArma);
	}
		
			
		
}
