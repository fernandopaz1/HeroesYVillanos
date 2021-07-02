package main;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Liga extends Enfrentable {
	
	private List<Enfrentable> integrantes;
	
	public Liga(String nombre, String nombreFantasia, List<Enfrentable> integrantes) {
		super(nombre, nombreFantasia);
		this.integrantes = new LinkedList<Enfrentable>();
		this.integrantes.addAll(integrantes);
	}

	public Liga(String nombre, String nombreFantasia) {
		super(nombre, nombreFantasia);
		this.integrantes = new LinkedList<Enfrentable>();
	}
	
	public boolean addIntegrante(Enfrentable e){
		if(e == null || integrantes.contains(e)) return false;
		return integrantes.add(e);
	}
	
	public float getValorAtributo(String key) {
		float suma=0.0f;
		float cantidad = 0.0f;
		for(Enfrentable e : integrantes) {
			suma += e.getValorAtributo(key);
			cantidad += 1.0f;
		}
		return cantidad > 0.0f ? suma/cantidad : 0;
	}
	
	protected List<Personaje> getPersonajes(){
//		LinkedList<Personaje> personajes = new LinkedList<Personaje>();
//		for(Enfrentable e : integrantes) {
//			if(e instanceof Liga) {
//				personajes.addAll(e.getPersonajes());
//			}
//			if(e instanceof Personaje) {
//				personajes.add((Personaje) e);
//			}
//		}
		
		return integrantes.stream()
				.flatMap((Enfrentable p) -> p.getPersonajes().stream()).distinct().collect(Collectors.toList());
//		return personajes.stream().distinct().collect(Collectors.toList());		
	}

	
}
