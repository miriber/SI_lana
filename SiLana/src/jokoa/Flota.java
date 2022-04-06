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
	private ArrayList<String> armamentuZer;
	private static Tablero taula;

	
	public Flota() {
		dirua=25;
		unekoOntziZer= new ArrayList<Ontzi>();
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
		for (int i=0; i<3; i++) {
			armamentuZer.add("Radarra");
			armamentuZer.add("Bonbak");
			armamentuZer.add("Misilak");
			armamentuZer.add("Ezkutuak");
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
		while (kont< limite && itr.hasNext()) {
			o= itr.next();
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
	
/*	public Ontzi lehenOntziDesb() {
		ArrayList<Ontzi> ontziMota= aukeraHauekInprima();
		Iterator<Ontzi> itr= getIteradoreaDesb();
		Ontzi emaitza=null;
		if (!ontziMota.isEmpty()) {
			emaitza= itr.next();
		}return emaitza;
	}*/
	
	public boolean ontziDenakKokatuta () {
		return ontziDesb.size()==0;
	}
	
	//TODO Hau tableroan edo hemen?
	private int getOntziTamaina (Ontzi pOntzi) {
		int tamaina;	
		if (pOntzi instanceof SuntsitzaileOntzi) {
			tamaina=1;
		}else if (pOntzi instanceof ItsaspekoOntzi) {
			tamaina=2;
		}else if (pOntzi instanceof HegazkinOntzi) {
			tamaina=3;
		}else {
			tamaina=0;	//pOntzi instanceof FragataOntzi
		}
		return tamaina;
	}
	
	public void ontziakKokatu(int x, int y, char norabidea, Ontzi pOntzi) {
		int tamaina= getOntziTamaina(pOntzi);
		System.out.println(tamaina+" tamaina");
		taula.ontziaJarri(x, y, tamaina, norabidea);
		System.out.println(tamaina+" tamaina");
		gehituOntzi (pOntzi);
		System.out.println(unekoOntziZer.size());
		// era berean kolorea aldatu behar interf graf
	}
}
