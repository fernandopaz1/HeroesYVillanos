package main;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;



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
	
	public abstract float getValorAtributo(String key);	
	
	/**
	 	
	 * @param e  Objeto tipo Enfrentable.
	 
	 * @param c Comparator de Enfrentable 
	 
	 * @return Devuelve el elemento mayor de acuerdo al Comparator<Enfrentable> c, si el comparador
	 * indica que son iguales entonces devuelve alguno de los dos de forma Random
	 */
	public Enfrentable enfrentar(Enfrentable e, Comparator<Enfrentable> c) {
		if(e == null)
			throw new IllegalArgumentException("No se puede efrentar Efrentable con null");
		if(c == null)
			throw new IllegalArgumentException("El comparador no puede ser null");
		int resultado = c.compare(this, e);
		if(resultado > 0) {
			return this;
		}else if(resultado == 0) {
			return Math.random() < 0.5 ? this : e;
		}else
			return e;
	}
	
	public List<Personaje> ordenar(Comparator<Enfrentable> c){
		return this.getPersonajes().stream().sorted(c).collect(Collectors.toList());
	}
	
	protected abstract List<Personaje> getPersonajes();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((nombreFantasia == null) ? 0 : nombreFantasia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enfrentable other = (Enfrentable) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (nombreFantasia == null) {
			if (other.nombreFantasia != null)
				return false;
		} else if (!nombreFantasia.equals(other.nombreFantasia))
			return false;
		return true;
	}

	
}
