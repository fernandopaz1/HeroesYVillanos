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
	
	public Enfrentable enfrentar(Enfrentable e, Comparator<Enfrentable> c) {
		
		return c.compare(this, e) > 0 ? this : e;
		//TODO preguntar que pasa con el igual
	}
	
	public List<Personaje> ordenar(Comparator c){
		
		return null;
		//TODO
	}
	
	protected List<Personaje> getPersonajes(){
		//TODO
		return null;
	}

}
