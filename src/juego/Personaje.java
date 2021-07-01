package juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Personaje extends Enfrentable {
	
	private Map<String,Atributo> atributos;
	
	public Personaje(String nombre, String nombreFantasia) {
		super(nombre, nombreFantasia);
	}
	
	@Override
	public float getValorAtributo(String key) {
		Atributo atr = atributos.getOrDefault(key, null);
		return atr == null ? 0 : atr.getValor(this);	
		//TODO ver si se puede escribir mas sencillo
	}
	
	protected List<Personaje> getPersonajes(){
		List<Personaje> ret = new ArrayList<Personaje>();
		ret.add(this);
		return ret;
		//TODO mejorar
	}
	
	public boolean addAtributo(String k, Atributo a) {
		if(atributos.containsKey(k) || atributos == null) return false;
		atributos.put(k, a);
		return true;
	}
}
