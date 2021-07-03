package main;

public class AtributoOperacion implements Atributo {

	protected String key1;
	protected String key2;
	private Operacion operacion;

	public AtributoOperacion(String key1, String key2) {
		if(key1 == null || key2== null)
			throw new NullPointerException("Las keys no puedes ser null");
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
		if(key1 == null || key2== null)
			throw new NullPointerException("Las keys no puedes ser null");
		if(o == null)
			throw new NullPointerException("La operación no puede ser null");
		this.key1 = key1;
		this.key2 = key2;
		this.operacion = o;
	}


	/**
	 * 
	 * @param Operacion o que queremos asignar a atributo operacion 
	 * @return Asigna la operacion al atributo solo si esta no es null
	 */
	public boolean setOperacion(Operacion o) {
		if (o == null)
			return false;
		this.operacion = o;
		return true;
	}

	@Override
	public float getValor(Enfrentable e) {
		if(operacion == null)
			throw new NullPointerException("Para obtener el valor la operacion no puede ser null");
		float a1 = e.getValorAtributo(key1);
		float a2 = e.getValorAtributo(key2);
		float ret = 0.0f;
		try {
			ret = operacion.apply(a1, a2);
		} catch (ArithmeticException e2) {
			e2.printStackTrace();
		} catch (RuntimeException e3) {
			e3.printStackTrace(); 
		}
		if(((Float) Math.abs(ret)).equals(Float.POSITIVE_INFINITY))
			throw new ArithmeticException("La operacion no soporta division por cero");
		return ret;
	}

}
