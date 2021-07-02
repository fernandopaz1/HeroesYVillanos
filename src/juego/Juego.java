package juego;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Juego {
	private List<Enfrentable> enfrentables;

	public Juego() {
		super();
		enfrentables = new LinkedList<Enfrentable>();
	}

	public List<Enfrentable> getQuienesVencen(Enfrentable e, Comparator<Enfrentable> c) {
		List<Enfrentable> ganadores = new LinkedList<Enfrentable>();
		for (Enfrentable retador : enfrentables) {
			Enfrentable ganador = e.enfrentar(retador, c);
			if (ganador.equals(e))
				ganadores.add(ganador);
		}
//		return ganadores;
		return enfrentables.stream().map(rival -> e.enfrentar(rival, c)).filter(winner -> !winner.equals(e)).collect(Collectors.toList());
		
	}

	public Enfrentable enfrentar(Enfrentable e1, Enfrentable e2, Comparator<Enfrentable> c) {
		return e1.enfrentar(e2, c);
	}

	public boolean addEnfrentable(Enfrentable e) {
		if (enfrentables.contains(e) || e == null)
			return false;
		return enfrentables.add(e);
	}

	public List<Personaje> ordenarPersonajes(Comparator<Enfrentable> c) {
		return enfrentables.stream().flatMap((Enfrentable e) -> e.getPersonajes().stream()).distinct().sorted(c)
				.collect(Collectors.toList());
	}
}
