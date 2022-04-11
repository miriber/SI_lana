package jokoa;

public class OntziFactory {
	private static OntziFactory nOntziFact=null;
	
	private OntziFactory() {}
	
	public static OntziFactory getNireOntziFact() {
		if (nOntziFact==null) {
			nOntziFact=new OntziFactory();
		} return nOntziFact;
	}
	
	public Ontzi createOntzi (int mota, char pNorab){
		switch(mota) {
			case 1: return new FragataOntzi(pNorab);
			case 2: return new SuntsitzaileOntzi(pNorab);
			case 3: return new ItsaspekoOntzi(pNorab);
			case 4: return new HegazkinOntzi(pNorab);
			default: return null;
		}
	}
}
