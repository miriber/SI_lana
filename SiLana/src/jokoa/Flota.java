package jokoa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Flota {
	private int dirua;
	private ArrayList<Ontzi> ontziZer;
	private ArrayList<Ontzi> ontziDesb;
	Map<Ontzi,  Integer> zenbat;
	//TODO OntziLista klasea sortu?
	private ArrayList<String> armamentuZer;
	private static Tablero taula;
	// ontzi kopuru egokia daudela ziurtatu
	
	public Flota() {
		dirua=25;
		ontziZer= new ArrayList<Ontzi>();
		ontziDesb= new ArrayList<Ontzi>();
		zenbat= new HashMap <Ontzi, Integer>();
		ontziakSortu();
		armamentuZer= new ArrayList<String>();
		armamentuaGehitu();
		taula= Tablero.getNireTablero();
	}
	
	/*private Iterator<String> getIteradoreA(){
		return armamentuZer.iterator();
	}*/
	
	private Iterator<Ontzi> getIteradoreaO(){
		return ontziZer.iterator();
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
		for (int i=0; i<3; i++) {
			armamentuZer.add("Radarra");
			armamentuZer.add("Bonbak");
			armamentuZer.add("Misilak");
			armamentuZer.add("Ezkutuak");
		}
	}
	
	public void gehituOntz(Ontzi pOntzi) {
		ontziZer.add(pOntzi);
	}
	private boolean motaHonetakoOntzirikBadagoKokatuGabe (Ontzi pOntzi) {
		int kont=0;
		int limite=zenbat.get(pOntzi);
		Iterator<Ontzi> itr= getIteradoreaO();
		Ontzi o;
		boolean inprima=true;
		while (kont< limite && itr.hasNext()) {
			o= itr.next();
			if (o.getEgoera(pOntzi.getIzena())) {
				kont++;
			}
		} if (kont==limite) {
			inprima=false;
		}
		return inprima;
	}
	
	public ArrayList<Ontzi> aukeraHauekInprima(){
		Iterator<Ontzi> itr= getIteradoreaDesb();
		Ontzi o;
		while (itr.hasNext()) {
			o=itr.next();
			if (!motaHonetakoOntzirikBadagoKokatuGabe (o)) {
				ontziDesb.remove(o);
			}
		}
		return ontziDesb;
	}
	
	public boolean ontziDenakKokatuta () {
		return ontziDesb.size()==0;
	}
	
	//TODO Hau tableroan edo hemen?
	private int getOntziTamaina (Ontzi pOntzi) {
		int tamaina;	
		if (pOntzi instanceof SuntsitzaileOntzi) {
			tamaina=2;
		}else if (pOntzi instanceof ItsaspekoOntzi) {
			tamaina=3;
		}else if (pOntzi instanceof HegazkinOntzi) {
			tamaina=4;
		}else {
			tamaina=1;	//pOntzi instanceof FragataOntzi
		}
		return tamaina;
	}
	
	public void ontziakKokatu(int x, int y, char norabidea, Ontzi pOntzi) {
		int tamaina= getOntziTamaina(pOntzi);
		taula.ontziaJarri(x, y, tamaina, norabidea);
		// era berean kolorea aldatu behar interf graf
	}
}
