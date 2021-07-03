package main;

public class AtributoCondicional implements Atributo {

	private String key1;
	private String key2;
	private Atributo keyThen;
	private Atributo keyElse;

	public AtributoCondicional(String key1, String key2, Atributo keyThen, Atributo keyElse) {
		if (key1 == null || key2 == null)
			throw new IllegalArgumentException("Las keys no pueden ser null");
		if (keyThen == null || keyElse == null)
			throw new IllegalArgumentException("Los Atributos keys no pueden ser null");
		if(keyThen instanceof AtributoCondicional || keyElse instanceof AtributoCondicional)
			throw new IllegalArgumentException("Los Atributos keys no pueden de tipo AtributosCondicional");
		this.key1 = key1;
		this.key2 = key2;
		this.keyThen = keyThen;
		this.keyElse = keyElse;
	}

	/**
	 * @param e de Tipo Enfrentable
	 *
	 * @return Segun que atributo sea mayor (key1 o key2)
	 * el valor de atributo condicional se determina con el valor
	 * guardado en el atributo keyThen o keyElse
	 * 
	 * key1, key2, keyThen y keyElse son variables de instancia de 
	 * AtributoCondicional
	 * 
	 *
	 */
	@Override
	public float getValor(Enfrentable e) {
		if (e.getValorAtributo(key1) > e.getValorAtributo(key2))
			return keyThen.getValor(e);
		return keyElse.getValor(e);
	}
}
