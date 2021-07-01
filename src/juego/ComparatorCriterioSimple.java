package juego;

import java.util.Comparator;

public class ComparatorCriterioSimple implements Comparator<Enfrentable>{

	private String atributo;
	
	@Override
	public int compare(Enfrentable e1, Enfrentable e2) {
		return (int) Math.signum(e1.getValorAtributo(atributo)-e2.getValorAtributo(atributo));
		//TODO Fijarse bien si esto puede mejorar
	}

}
