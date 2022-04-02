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
	private ArrayList<String> armamentuZer;
	private static Tablero taula;
	// ontzi kopuru egokia daudela ziurtatu
	
	public Flota() {
		dirua=25;
		ontziZer= new ArrayList<Ontzi>();
		ontziDesb= new ArrayList<Ontzi>();
		zenbat= new HashMap <Ontzi, Integer>();
		armamentuZer= new ArrayList<String>();
		taula= taula.getNireTablero();
		ontziakSortu();
	}
	
	private Iterator<String> getIteradoreA(){
		return armamentuZer.iterator();
	}
	
	private Iterator<Ontzi> getIteratorO(){
		return ontziZer.iterator();
	}
	
	/* public void inprimatuZenbat()
	 * 
	 */
	
	private void ontziakSortu() {
		OntziFactory nFact = OntziFactory.getNireOntziFact();
		Ontzi berria= nFact.createOntzi(4);
		//hegazkin ontzi bat
		zenbat.put(berria, 1);
		//4 Fragata izango ditugu
		berria= nFact.createOntzi(1);
		zenbat.put(berria, 4);
		// hiru suntsitzaile
		berria= nFact.createOntzi(2);
		zenbat.put(berria, 3);
		//bi itsaspeko
		berria= nFact.createOntzi(3);
		zenbat.put(berria, 2);
	}
	
	public void gehituOntz(Ontzi pOntzi) {
		ontziZer.add(pOntzi);
	}
	private boolean motaHonetakoOntzirikBadagoKokatuGabe (Ontzi pOntzi) {
		int kont=0;
		int limite=zenbat.get(pOntzi);
		Iterator<Ontzi> itr= getIteratorO();
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
		Iterator<Ontzi> itr= ontziDesb.iterator();
		Ontzi o;
		while (itr.hasNext()) {
			o=itr.next();
			if (!motaHonetakoOntzirikBadagoKokatuGabe (o)) {
				ontziDesb.remove(o);
			}
		}
		return ontziDesb;
	}
	
	
	
	public void ontziakKokatu() {
		// ontziaAukeratu metodotik lortuko dugu tamaina
		//String norabidea= ontziarenNorabidea
		//x, y--> Buttonetik atera--> ontziaNonKokatu
		int x;
		int y;
		taula.ontziaJarri(x, y, tamaina, norabidea);
		// era berean kolorea aldatu behar interf graf
	}
}
