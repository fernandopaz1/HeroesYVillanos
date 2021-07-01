package juego;

import java.util.List;
import java.util.Map;

public class Personaje extends Enfrentable {
	
	private Map<String,Atributo> atributos;
	
	public Personaje(String nombre, String nombreFantasia) {
		super(nombre, nombreFantasia);
	}
	
	@Override
	public float getValorAtributo(String key) {
		return 0;	
		//TODO
	}
	
	protected List<Personaje> getPersonajes(){
		return null;
		//TODO
	}
	
	public boolean addAtributo(String k, Atributo a) {
		return false;
		//TODO	
	}
}
