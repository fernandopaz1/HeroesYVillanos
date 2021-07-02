package heroesVillanosTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Atributo;
import main.AtributoCondicional;
import main.AtributoSimple;
import main.Personaje;

public class AtributoCondicionalTest {

	Atributo velocidad;
	Atributo vision;
	Atributo tecnologia;
	Atributo inteligencia;
	Atributo fuerza;
	
	Personaje p = new Personaje("a", "b");
	
	@Before
	public void setUp() throws Exception {
		 velocidad = new AtributoSimple(20.0f);
		 vision = new AtributoSimple(3000.0f);
		 tecnologia = new AtributoSimple(3000.0f);
		 inteligencia = new AtributoSimple(200.0f);
		 fuerza = new AtributoSimple(300.0f);
	
		 p.addAtributo("velocidad", velocidad);
		 p.addAtributo("vision", vision);
		 p.addAtributo("tecnologia", tecnologia);
		 p.addAtributo("inteligencia", inteligencia);
		 p.addAtributo("fuerza", fuerza);
	}

	@Test(expected = IllegalArgumentException.class)
	public void keyNullTest() {
		@SuppressWarnings("unused")
		AtributoCondicional c = new AtributoCondicional(null, "velocidad", inteligencia, fuerza);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void keyNullCondicionalTest() {
		@SuppressWarnings("unused")
		AtributoCondicional c = new AtributoCondicional("vision", "velocidad", inteligencia, null);
	}
	
	@Test
	public void keyInexistenteTest() {
		AtributoCondicional c = new AtributoCondicional("inteligencia", "nada", new AtributoSimple(20.0f), new AtributoSimple(30.0f));
		assertTrue(20.0f == c.getValor(p));
	}
	
	@Test
	public void Test() {
		AtributoCondicional c = new AtributoCondicional("inteligencia", "vision", new AtributoSimple(20.0f), new AtributoSimple(30.0f));
		assertTrue(30.0f == c.getValor(p));
	}

}
