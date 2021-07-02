package main;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
 
public class ComparatorCompuesto implements Comparator<Enfrentable>{
	
	private List<Comparator<Enfrentable>> comparators;
	
	public ComparatorCompuesto() {
		this.comparators = new LinkedList<Comparator<Enfrentable>>();
	}

	public ComparatorCompuesto(List<Comparator<Enfrentable>> comparators) {
		this.comparators = new LinkedList<Comparator<Enfrentable>>();
		comparators.addAll(comparators);
	}

	@Override
	public int compare(Enfrentable e1, Enfrentable e2) {
		int resultado = 0;
		for(Comparator<Enfrentable> c : comparators) { 
			resultado = c.compare(e1, e2);
			if(resultado != 0) return resultado;
		}
		return 0;
	}
	
	public boolean addComparator(Comparator<Enfrentable> c) {
		if(c == null || this.equals(c)) return false;
		return comparators.add(c);
	}
	
	public boolean addComparator(Comparator<Enfrentable> c, int index) {
		if(c ==  null || this.equals(c)) return false;
		 comparators.add(index, c);
		 return true;
	}

}
