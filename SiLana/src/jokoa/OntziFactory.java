package jokoa;

public class OntziFactory {
	private static OntziFactory nOntziFact=null;
	
	private OntziFactory() {}
	
	public static OntziFactory getNireOntziFact() {
		if (nOntziFact==null) {
			nOntziFact=new OntziFactory();
		} return nOntziFact;
	}
	
	//public Ontzi createOntzi (int mota){

	//}
}
