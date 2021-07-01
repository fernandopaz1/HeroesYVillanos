package juego;

public class AtributoSimple implements Atributo{
	
	private float value;
	

	public AtributoSimple(float value) {
		super();
		this.value = value;
	}


	@Override
	public float getValor(Enfrentable e) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setValor(float value) {
		this.value = value;
		//TODO ver excepciones
	}

}
