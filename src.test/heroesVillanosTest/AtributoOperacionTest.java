package heroesVillanosTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Atributo;
import main.AtributoOperacion;
import main.AtributoSimple;
import main.Personaje;

public class AtributoOperacionTest {
	
	Personaje p = new Personaje("A", "B");
	
	@Before
	public void setUp() throws Exception {
		 p.addAtributo("velocidad", new AtributoSimple(3.0f));
		 p.addAtributo("vision", new AtributoSimple(4.0f));
		 p.addAtributo("tecnologia", new AtributoSimple(0.0f));
		 p.addAtributo("inteligencia", new AtributoSimple(3.0f));
		 p.addAtributo("fuerza", new AtributoSimple(23.0f));
	}

	@Test(expected = NullPointerException.class)
	public void AtributoOperacionSinOperacionTest() {
		AtributoOperacion atOp = new AtributoOperacion("vision", "velocidad");
		atOp.getValor(p);
	}
	
	@Test(expected = ArithmeticException.class)
	public void AtributoOperacionErrorAritmeticoTest() {
		AtributoOperacion atOp = new AtributoOperacion("vision", "tecnologia", (f1, f2)-> f1/f2);
		atOp.getValor(p);
	}
	
	@Test
	public void AtributoOperacionExitosoTest() {
		AtributoOperacion atOp = new AtributoOperacion("vision", "fuerza", (f1, f2)-> f1/f2);
		assertTrue(4.0f/23.0f == atOp.getValor(p));
	}
	
	@Test
	public void AtributoSetOperacionTest() {
		AtributoOperacion atOp = new AtributoOperacion("vision", "fuerza");
		atOp.setOperacion((f1, f2)-> f1*f2);
		assertTrue(4.0f*23.0f == atOp.getValor(p));
	}
}
