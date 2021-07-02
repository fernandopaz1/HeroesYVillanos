package heroesVillanosTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.Atributo;
import main.AtributoSimple;
import main.ComparatorCriterioSimple;
import main.Enfrentable;
import main.Liga;
import main.Personaje;

public class LigaTest {
	Personaje batman = new Personaje("Bruce Wyane", "Batman");
	Personaje superman = new Personaje("Clark Kent", "Superman");
	Personaje aquaman = new Personaje("Aquaman","Aquaman");
	
	Personaje acertijo = new Personaje("?", "Acertijo");
	Personaje lexlutor = new Personaje("Lex Luthor", "Lex Luthor");
	
	Liga ligaDelMal = new Liga("", "Liga del mal");
	Liga ligaDelBien= new Liga("", "Liga del bien");
	
	Atributo velocidadB = new AtributoSimple(20.0f);
	Atributo velocidadS = new AtributoSimple(3000.0f);
	Atributo tecnologiaB = new AtributoSimple(3000.0f);
	Atributo tecnologiaS = new AtributoSimple(200.0f);

	Atributo vueloS = new AtributoSimple(500.0f);

	Comparator<Enfrentable> cVelocidad;
	Comparator<Enfrentable> cTecnologia;

	@Before
	public void setUp() throws Exception {
		batman.addAtributo("velocidad", new AtributoSimple(30.0f));
		batman.addAtributo("tecnologia", new AtributoSimple(3000.0f));
		batman.addAtributo("inteligencia", new AtributoSimple(3000.0f));
		superman.addAtributo("velocidad", new AtributoSimple(3000.0f));
		superman.addAtributo("tecnologia", new AtributoSimple(200.0f));
		aquaman.addAtributo("nada", new AtributoSimple(100.0f));
		

		lexlutor.addAtributo("inteligencia", new AtributoSimple(1000.0f));
		lexlutor.addAtributo("tecnologia", new AtributoSimple(3000.0f));
		acertijo.addAtributo("inteligencia", new AtributoSimple(3000.0f));

		cVelocidad = new ComparatorCriterioSimple("velocidad");
		cTecnologia = new ComparatorCriterioSimple("tecnologia");
		
		ligaDelBien.addIntegrante(batman);
		ligaDelBien.addIntegrante(superman);
		ligaDelMal.addIntegrante(acertijo);
		ligaDelMal.addIntegrante(lexlutor);
	}


	@Test
	public void agregarNullTest() {
		assertFalse(ligaDelBien.addIntegrante(null));
	}
	
	@Test
	public void agregarIntegranteRepetidoTest() {
		assertFalse(ligaDelBien.addIntegrante(batman));
	}
	
	@Test
	public void agregarIntegrantenuevoTest() {
		assertTrue(ligaDelBien.addIntegrante(aquaman));
	}
	
	@Test
	public void getValorAtributoInexistenteTest() {
		assertTrue(0.0f == ligaDelMal.getValorAtributo("nada"));
		assertTrue(0.0f == ligaDelMal.getValorAtributo(null));
	}
	
	@Test
	public void getValorAtributoExistenteTest() {
		assertTrue(2000.0f == ligaDelMal.getValorAtributo("inteligencia"));
		assertTrue(1515.0f == ligaDelBien.getValorAtributo("velocidad"));
		ligaDelBien.addIntegrante(aquaman); //agrego a aquaman que no tine velocidad
											// y el promedio baja
		assertTrue(1010.0f == ligaDelBien.getValorAtributo("velocidad"));	
	}
	
	@Test
	public void enfrentamientoAtributoInexistenteTest() {
		assertTrue(aquaman.equals(aquaman.enfrentar(ligaDelMal, new ComparatorCriterioSimple("nada"))));
	}
	
	@Test
	public void enfrentamientoAtributoExistenteTest() {
		assertTrue(ligaDelMal.equals(ligaDelBien.enfrentar(ligaDelMal, new ComparatorCriterioSimple("inteligencia"))));
		assertTrue(ligaDelBien.equals(ligaDelBien.enfrentar(ligaDelMal, new ComparatorCriterioSimple("velocidad"))));
	}

	@Test
	public void ordenarLigaAscendenteTest() {
		ligaDelBien.addIntegrante(aquaman);
		List<Personaje> ligaOrdenadaPorVelocidad = Arrays.asList(aquaman, batman, superman);
		assertArrayEquals(ligaOrdenadaPorVelocidad,ligaDelBien.ordenar(cVelocidad));
	}
	
	@Test
	public void ordenarLigaDescendenteTest() {
		ligaDelBien.addIntegrante(aquaman);
		List<Personaje> ligaOrdenadaPorVelocidad = Arrays.asList(superman, batman,aquaman);
		assertArrayEquals(ligaOrdenadaPorVelocidad,ligaDelBien.ordenar(cVelocidad.reversed()));
	}
	
	public void assertArrayEquals(List<Personaje> a , List<Personaje> b) {
		if(a.size() != b.size()) fail();
		for(int i=0; i<a.size(); i++) 
			assertTrue(a.get(i).equals(b.get(i)));
		
	}
	

}
