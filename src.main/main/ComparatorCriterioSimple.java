package main;

import java.util.Comparator;

public class ComparatorCriterioSimple implements Comparator<Enfrentable>{

	private String atributo;
	
	public ComparatorCriterioSimple(String atributo) {
		this.atributo= atributo;
	}
	
	@Override
	public int compare(Enfrentable e1, Enfrentable e2) {
		return (int) Math.signum(e1.getValorAtributo(atributo)-e2.getValorAtributo(atributo));
		//TODO Fijarse bien si esto puede mejorar
	}

}
