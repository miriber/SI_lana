package jokoa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Biltegia {
	private static Biltegia nBiltegia=null;			//EMA
	private ArrayList<Arma> armamentuZer;			//arma desberdinen zerrenda
	private Map<String,Integer> armamentuKont;		//armamentu bakoitzeko zenbat unitate falta diren
	private static Map<Arma,Integer> armamentuBalioDiru;	//armamentu bakoitzaren prezioa 
	
	//eraikitzailea
	private Biltegia() {
		armamentuZer= new ArrayList<Arma>();
		armamentuKont=  new HashMap<String, Integer>();
		armamentuBalioDiru=  new HashMap<Arma, Integer>();	
		armamentuaGehitu();
	}
	
	public static Biltegia getNireBiltegia() {
		if (nBiltegia==null) {
			nBiltegia= new Biltegia();
		}
		return nBiltegia;
	}
	
	//gainerako metodoa
	private Iterator<Arma> getIteratorArma(){
		return armamentuZer.iterator();
	}
	private void armamentuaGehitu() {
		//armametua hasieratuko du, bakoitzeko kantitatea eta prezioa adieraziz
		System.out.println("Biltegia --> armamentuaGehitu");
		Arma a; 
		a=new Radarra();
		armamentuZer.add(a);
		armamentuKont.put(a.getArma(),30);
		armamentuBalioDiru.put(a,2);
		a= new Bonba();
		armamentuZer.add(a);
		armamentuKont.put(a.getArma(),30);
		armamentuBalioDiru.put(a,1);
		a= new Misila();
		armamentuKont.put(a.getArma(),30);
		armamentuZer.add(a);
		armamentuBalioDiru.put(a,3);
		a=new Ezkutua();
		armamentuKont.put(a.getArma(),30);
		armamentuZer.add(a);
		armamentuBalioDiru.put(a,2);
	}
	
	public void armaErosi(Arma pArma) {
		//arma erosterakoan, bat kendu HasMap-tatik eta baldin kont hori 0 badago, armametuZer ezabatu
		System.out.println(armamentuKont.get(pArma.getArma())+"ARMAEROSI");
		armamentuKont.put(pArma.getArma(),armamentuKont.get(pArma.getArma())-1);
		System.out.println(armamentuKont.get(pArma.getArma())+"ARMAEROSI");
		
		if (armamentuKont.get(pArma.getArma())==0) {
			armamentuZer.remove(pArma);
		}
	}
	
	public ArrayList<String> diruHorrekinArmaPosibleak(int momentukoDiru){
		//jokalariak daukan dirua: momnetukoDirua
		//momentukoDiruarekin erosi ditzakeen arma aukeren izenak itzultzen ditu, array gisa
		ArrayList<String> emaitza= new ArrayList<String>();
		Iterator<Arma> itr= getIteratorArma();
		Arma a;
		Integer prezioa;
		while (itr.hasNext()) {
			a=itr.next();
			prezioa=armamentuBalioDiru.get(a);
			if (prezioa<=momentukoDiru) {
				emaitza.add(a.getArma());
			}
		}
		return emaitza;
	}
	
	public ArrayList <Arma> lortuDiruHorrekinArmaPosibleak(int momentukoDiru){
		//jokalariak daukan dirua: momnetukoDirua
				//momentukoDiruarekin erosi ditzakeen armak itzultzen ditu, array gisa
		ArrayList<Arma> emaitza= new ArrayList<Arma>();
		Iterator<Arma> itr= getIteratorArma();
		Arma a;
		Integer prezioa;
		while (itr.hasNext()) {
			a=itr.next();
			prezioa=armamentuBalioDiru.get(a);
			if (prezioa<=momentukoDiru) {
				emaitza.add(a);
			}
		}
		return emaitza;
	}
}

