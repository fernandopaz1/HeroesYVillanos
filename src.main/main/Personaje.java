package main;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Personaje extends Enfrentable {

	private Map<String, Atributo> atributos;

	public Personaje(String nombre, String nombreFantasia) {
		super(nombre, nombreFantasia);
		atributos = new HashMap<String, Atributo>();
	}

	@Override
	public float getValorAtributo(String key) {
		Atributo atr = atributos.getOrDefault(key, null);
		if (atr == null) return 0;
		if(atr instanceof AtributoCondicional)
			return atr.getValor(this);
		if(atr instanceof AtributoSimple)
			return atr.getValor(this);
		return 0.0f;
	}

	protected List<Personaje> getPersonajes() {
		List<Personaje> ret = new LinkedList<Personaje>();
		ret.add(this);
		return ret;
	}

	public boolean addAtributo(String k, Atributo a) {
		if (atributos.containsKey(k) || a == null)
			return false;
		atributos.put(k, a);
		return true;
	}
}
