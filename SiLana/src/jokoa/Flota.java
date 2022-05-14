package jokoa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import bista.OntziNorabidea;
import bista.TableroaBista;

public class Flota {
	private int dirua;
	private ArrayList<Ontzi> unekoOntziZer;
	private ArrayList<Ontzi> ontziDesb;
	//Ez da hobeto OntziZer klasea sortzea?
	private Map<String,  Integer> ontziKont;
	private Map<String, Integer> armamentuKont;
	private ArrayList<Arma> armamentuZer;
	
	public Flota() {
		dirua=25;
		unekoOntziZer= new ArrayList<Ontzi>();
		ontziDesb= new ArrayList<Ontzi>();
		ontziKont= new HashMap<String, Integer>();
		ontziakSortu();
		armamentuKont=  new HashMap<String, Integer>();
		armamentuZer= new ArrayList<Arma>();
		armamentuaGehitu();
	}
	
	//Iteradoreak
	
	private Iterator<Arma> getIteradoreArma(){
		return armamentuZer.iterator();
	}
	
	private Iterator<Ontzi> getIteradoreaUnekoOntzi(){
		return unekoOntziZer.iterator();
	}
	
	private Iterator<Ontzi> getIteradoreaOntziDesb(){
		return ontziDesb.iterator();
	}
	
	//Hasieraketarako balio duten metodoak
	private void ontziakSortu() {
		System.out.println("flota --> ontziakSortu");
		OntziFactory nFact = OntziFactory.getNireOntziFact();
		OntziNorabidea on= OntziNorabidea.getNireOntziNorabidea();
		Ontzi berria= nFact.createOntzi(4);
		//hegazkin ontzi bat
		ontziKont.put(berria.getMota(), 1);
		ontziDesb.add(berria);
		//bi itsaspeko
		berria= nFact.createOntzi(3);
		ontziKont.put(berria.getMota(), 2);
		ontziDesb.add(berria);
		// hiru suntsitzaile
		berria= nFact.createOntzi(2);
		ontziKont.put(berria.getMota(), 3);
		ontziDesb.add(berria);
		//4 Fragata izango ditugu
		berria= nFact.createOntzi(1);
		ontziKont.put(berria.getMota(), 4);
		ontziDesb.add(berria);	
	}
	
	private void armamentuaGehitu() {
		System.out.println("flota --> armamentuaGehitu");
		Arma a;
		a=new Radarra();
		armamentuZer.add(a);
		armamentuKont.put(a.getArma(),3);
		a= new Bonba();
		armamentuZer.add(a);
		armamentuKont.put(a.getArma(),30);
		a= new Misila();
		armamentuKont.put(a.getArma(),3);
		armamentuZer.add(a);
		a=new Ezkutua();
		armamentuKont.put(a.getArma(),3);
		armamentuZer.add(a);
	}
	//Gainerako metodoak: ontziarekin zerikusia
	
	public int motaHonetakoZenbatOntziGelditu (Ontzi pOntzi) {
		int emaitza;
		if  (ontziKont.get(pOntzi.getMota())==null) {
			emaitza=0;
		}else {
			emaitza=ontziKont.get(pOntzi.getMota());
		}
		return emaitza;
	}
	
	public void gehituOntzi(Ontzi pOntzi) {
		System.out.println("flota --> gehituOntzi");
		unekoOntziZer.add(pOntzi);
		System.out.println(ontziKont.get(pOntzi.getMota()));
		ontziKont.put(pOntzi.getMota(), ontziKont.get(pOntzi.getMota())-1);
		if (ontziKont.get(pOntzi.getMota())==0){
			ontziKont.remove(pOntzi.getMota());
			Iterator <Ontzi> itr=getIteradoreaOntziDesb();
			boolean aurkitua=false;
			Ontzi o=null;
			while (itr.hasNext()&&!aurkitua) {
				o=itr.next();
				if (o.getMotaBera(pOntzi.getMota())) {
					aurkitua=true;
				}
			}
			if (aurkitua) {
				ontziDesb.remove(o);
			}
			
		}
		System.out.println(ontziKont.get(pOntzi.getMota()));
		/*if (unekoOntziZer.size()==10) {
			motaHonetakoLimiteaPasa();
		}*/
		//System.out.println(unekoOntziZer.size()+" unekoOntziTamaina, FLOTA");
	}
	
	
	public ArrayList<Ontzi> lortuOntziPosibleak(){
		return ontziDesb;
	}

	
	public ArrayList<String> lortuOntziPosibleMotak() {
		System.out.println("flota --> lortuOntziPosibleMotak");
		//motaHonetakoLimiteaPasa();
		Iterator<Ontzi> itr= getIteradoreaOntziDesb();
		Ontzi o;
		ArrayList<String> emaitza= new ArrayList<String>();	
		while (itr.hasNext()) {
			o=itr.next();
			emaitza.add(o.getMota());
		}
		return emaitza;
	}
	
	public boolean ontziDenakKokatuta () {
		//Kokatu gabeko ontzirik dagoen jakiteko balio du
		System.out.println("flota --> ontziDenakKokatuta");
		return ontziDesb.size()==0;
	}

	public boolean ontziDenakAurkituta() {
		//Ontzi denak hondoratuta izan direla jakiteko balio du
		System.out.println("flota --> ontziDenakAurkituta");
		return unekoOntziZer.size()==0;
	}
	
	public void ontziaKendu(Ontzi pOntzi) {
		
		System.out.println("flota --> ontziaKendu");
		unekoOntziZer.remove(pOntzi);
	}
	
	
	//Gainerako metodoak: armarekin zerikusia
	
	//TODO public void armamentuaErosi: add
	public ArrayList<Arma> lortuArmaPosibleak(){
		return armamentuZer;
	}
	
	public void armamentuaErabili(Arma a) {
		System.out.println("flota --> armamentuaErabili");
		System.out.println(a);
		System.out.println(armamentuKont.get(a.getArma()));
		armamentuKont.put(a.getArma(), armamentuKont.get(a.getArma())-1);
		System.out.println(armamentuKont.get(a.getArma()));
		if (armamentuKont.get(a.getArma())==0) {
			armamentuZer.remove(a);
		}
		System.out.println(armamentuKont.get(a.getArma()));
	}
	
	public ArrayList<String> lortuArmaPosibleMotak() {
		// Eskuan artean dituen arma desberdinen izenak itzultzen du, array eran
		System.out.println("flota --> lortuArmaPosibleMotak");
		Arma a;
		ArrayList<String> emaitza= new ArrayList<String>();
		Iterator<Arma> itr= getIteradoreArma();
		while (itr.hasNext()) {
			a=itr.next();
			emaitza.add(a.getArma());
			System.out.println("$$$$lortuArmaPosibleak"+a.getArma());
		}
		return emaitza;
	}
	
	//Gainerako metodoak: Biltegiarekin zerikusia
	public int getDirua() {
		return dirua;
	}
	
	public void gehituArma(Arma a) {
		System.out.println(armamentuKont.get(a.getArma()));
		armamentuKont.put(a.getArma(), armamentuKont.get(a.getArma())+1);
		System.out.println(armamentuKont.get(a.getArma()));
		if (armamentuKont.get(a.getArma())==1){
			armamentuZer.add(a);
		}
	}

}