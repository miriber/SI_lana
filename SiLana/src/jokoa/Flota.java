package jokoa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Flota {
	private int dirua;
	private ArrayList<Ontzi> unekoOntziZer;
	private ArrayList<Ontzi> ontziDesb;
	//Ez da hobeto OntziZer klasea sortzea?
	private Map<Ontzi,  Integer> zenbat;
	private ArrayList<Arma> armamentuZer;

	
	public Flota() {
		dirua=25;
		unekoOntziZer= new ArrayList<Ontzi>();
		ontziDesb= new ArrayList<Ontzi>();
		zenbat= new HashMap <Ontzi, Integer>();
		ontziakSortu();
		armamentuZer= new ArrayList<Arma>();
		armamentuaGehitu();
	}
	
	/*private Iterator<String> getIteradoreA(){
		return armamentuZer.iterator();
	}*/
	
	private Iterator<Ontzi> getIteradoreaO(){
		return unekoOntziZer.iterator();
	}
	
	private Iterator<Ontzi> getIteradoreaDesb(){
		return ontziDesb.iterator();
	}
	
	private void ontziakSortu() {
		OntziFactory nFact = OntziFactory.getNireOntziFact();
		Ontzi berria= nFact.createOntzi(4);
		//hegazkin ontzi bat
		zenbat.put(berria, 1);
		ontziDesb.add(berria);
		//4 Fragata izango ditugu
		berria= nFact.createOntzi(1);
		zenbat.put(berria, 4);
		ontziDesb.add(berria);
		// hiru suntsitzaile
		berria= nFact.createOntzi(2);
		zenbat.put(berria, 3);
		ontziDesb.add(berria);
		//bi itsaspeko
		berria= nFact.createOntzi(3);
		zenbat.put(berria, 2);
		ontziDesb.add(berria);
	}
	
	private void armamentuaGehitu() {
		Arma a;
		for (int i=0; i<3; i++) {
			a=new Radarra();
			armamentuZer.add(a);
			a= new Bonba();
			armamentuZer.add(a);
			a= new Misila();
			armamentuZer.add(a);
			a=new Ezkutua();
			armamentuZer.add(a);
		}
	}
	
	private void gehituOntzi(Ontzi pOntzi) {
		unekoOntziZer.add(pOntzi);
	}
	private boolean motaHonetakoOntzirikBadagoKokatuGabe (Ontzi pOntzi) {
		int kont=0;
		int limite=zenbat.get(pOntzi);
		Iterator<Ontzi> itr= getIteradoreaO();
		Ontzi o;
		boolean inprima=true;
		while (itr.hasNext()&& kont< limite) {
			o= itr.next();
			System.out.println(o+"mota");
			System.out.println(pOntzi.getMota()+"mota2");
			if (o.getMotaBera(pOntzi.getMota())) { //pOntziren eta o-ren egoera bera
				kont++;
			}
		} if (kont==limite) {	//jada ontzi nahiko mota horretakoak
			inprima=false;
		}
		return inprima;
	}
	
	public Ontzi[] aukeraHauekInprima(){
		Iterator<Ontzi> itr= getIteradoreaDesb();
		Ontzi o;
		Ontzi[] emaitza= new Ontzi[4];	//gehienez 4 ontzi mota egongo dira
		int i=0;
		while (itr.hasNext()) {
			o=itr.next();
			if (!motaHonetakoOntzirikBadagoKokatuGabe (o)) {
				ontziDesb.remove(o);
			}else {
				emaitza[i]=o;
				i++;
			}
		}
		return emaitza;
	}
	
	public boolean ontziDenakKokatuta () {
		return ontziDesb.size()==0;
	}
	
	
	public void ontziakKokatu(Ontzi pOntzi) {
		gehituOntzi (pOntzi);
		// era berean kolorea aldatu behar interf graf
	}
}
