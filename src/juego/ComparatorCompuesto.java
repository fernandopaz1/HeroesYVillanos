package juego;

import java.util.Comparator;
import java.util.List;

public class ComparatorCompuesto implements Comparator<Enfrentable>{
	
	private List<Comparator> comparators;

	
	
	public ComparatorCompuesto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComparatorCompuesto(List<Comparator> comparators) {
		super();
		comparators.addAll(comparators);
	}

	@Override
	public int compare(Enfrentable arg0, Enfrentable arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean addComparator(Comparator c) {
		if(c == null) return false;
		return comparators.add(c);
	}
	
	public boolean addComparator(Comparator c, int index) {
		if(c ==  null) return false;
		 comparators.add(index, c);
		 return true;
	}

}
