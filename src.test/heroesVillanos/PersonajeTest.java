package heroesVillanos;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

import main.Atributo;
import main.AtributoSimple;
import main.ComparatorCriterioSimple;
import main.Enfrentable;
import main.Personaje;

public class PersonajeTest {
	Personaje batman = new Personaje("Bruce Wyane", "Batman");
	Personaje superman = new Personaje("Clark Kent", "Superman");

	Atributo velocidadB = new AtributoSimple(20.0f);
	Atributo velocidadS = new AtributoSimple(3000.0f);
	Atributo tecnologiaB = new AtributoSimple(3000.0f);
	Atributo tecnologiaS = new AtributoSimple(200.0f);

	Atributo vueloS = new AtributoSimple(500.0f);

	Comparator<Enfrentable> cVelocidad;
	Comparator<Enfrentable> cTecnologia;
	

	@Before
	public void setUp() throws Exception {
		batman.addAtributo("velocidad", new AtributoSimple(20.0f));
		batman.addAtributo("tecnologia", new AtributoSimple(3000.0f));
		
		superman.addAtributo("velocidad", new AtributoSimple(3000.0f));
		superman.addAtributo("tecnologia", new AtributoSimple(200.0f));	
		superman.addAtributo("vuelo", new AtributoSimple(500.0f));
	
		cVelocidad = new ComparatorCriterioSimple("velocidad");
		cTecnologia = new ComparatorCriterioSimple("tecnologia");
}

	@Test(expected = IllegalArgumentException.class)
	public void rivalNullTest() {
		batman.enfrentar(null, cTecnologia);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void comparadorNullTest() {
		batman.enfrentar(superman, null);
	}
	
	@Test
	public void ganaPorVelocidadTest() {
		assertTrue(superman.equals(batman.enfrentar(superman, cVelocidad)));
	}
	
	@Test
	public void ganaPorTecnologíaTest() {
		assertTrue(batman.equals(batman.enfrentar(superman, cTecnologia)));
	}

}
