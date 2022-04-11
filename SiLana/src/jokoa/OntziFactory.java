package jokoa;

public class OntziFactory {
	private static OntziFactory nOntziFact=null;
	
	private OntziFactory() {}
	
	public static OntziFactory getNireOntziFact() {
		if (nOntziFact==null) {
			nOntziFact=new OntziFactory();
		} return nOntziFact;
	}
	
	public Ontzi createOntzi (int mota /*,char pNorab*/){
		switch(mota) {
			case 1: return new FragataOntzi();
			case 2: return new SuntsitzaileOntzi();
			case 3: return new ItsaspekoOntzi();
			case 4: return new HegazkinOntzi();
			default: return null;
		}
	}
}
