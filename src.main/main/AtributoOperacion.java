package main;

public class AtributoOperacion implements Atributo {

	protected String key1;
	protected String key2;
	private Operacion operacion;

	public AtributoOperacion(String key1, String key2) {
		this.key1 = key1;
		this.key2 = key2;
	}

	/**
	 * Constructor
	 * 
	 * @param key1 nombre del primer atributo
	 * @param key2 nombre del segundo atributo
	 * @param o    Objeto tipo Operación mediante el se calcula el valor del
	 *             atributo que estamos calculando a partir de los atributos
	 *             anteriores
	 */
	public AtributoOperacion(String key1, String key2, Operacion o) {
		this.key1 = key1;
		this.key2 = key2;
		this.operacion = o;
	}

	public boolean setOperacion(Operacion o) {
		if (operacion == null)
			return false;
		this.operacion = o;
		return true;
	}

	@Override
	public float getValor(Enfrentable e) {
		float a1 = e.getValorAtributo(key1);
		float a2 = e.getValorAtributo(key2);
		float ret = 0.0f;
		try {
			ret = operacion.apply(a1, a2);
		} catch (RuntimeException e2) {
			e2.printStackTrace();
		}
		return ret;
	}

}
