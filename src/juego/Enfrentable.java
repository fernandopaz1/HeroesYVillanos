package juego;

import java.util.Comparator;
import java.util.List;


public abstract class Enfrentable {
	
	protected String nombre;
	protected String nombreFantasia;
	
	public Enfrentable(String nombre, String nombreFantasia) {
		super();
		this.nombre = nombre;
		this.nombreFantasia = nombreFantasia;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNombreFantasia() {
		return nombreFantasia;
	}
	
	public float getValorAtributo(String key) {
		return 0;
		//TODO
	}	
	
	public Enfrentable enfrentar(Enfrentable e, Comparator c) {
		return e;
		//TODO
	}
	
	public List<Personaje> ordenar(Comparator c){
		return null;
		//TODO
	}

}
