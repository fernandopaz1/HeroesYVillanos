package juego;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Liga extends Enfrentable {
	
	private List<Enfrentable> integrantes;
	
	public Liga(String nombre, String nombreFantasia, List<Enfrentable> integrantes) {
		super(nombre, nombreFantasia);
		this.integrantes = new ArrayList<Enfrentable>();
		this.integrantes.addAll(integrantes);
		//TODO
	}

	public Liga(String nombre, String nombreFantasia) {
		super(nombre, nombreFantasia);
		this.integrantes = new ArrayList<Enfrentable>();
	}
	
	public boolean addIntegrante(Enfrentable e) {
		return integrantes.add(e);
		//TODO
	}
	
	public float getValorAtributo(String key) {
		return 0;
		//TODO
	}

}
