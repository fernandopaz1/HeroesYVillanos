package heroesVillanosTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.AtributoSimple;
import main.ComparatorCompuesto;
import main.ComparatorCriterioSimple;
import main.Enfrentable;
import main.Juego;
import main.Liga;
import main.Personaje;

public class JuegoTest {

	Personaje batman = new Personaje("Bruce Wyane", "Batman");
	Personaje superman = new Personaje("Clark Kent", "Superman");
	Personaje aquaman = new Personaje("Aquaman", "Aquaman");

	Personaje lexlutor = new Personaje("Lex Luthor", "Lex Luthor");

	Liga ligaDelMal = new Liga("", "Liga del mal");
	Liga ligaDelBien = new Liga("", "Liga del bien");
	Liga ligaAquatica = new Liga("", "peces");

	Comparator<Enfrentable> cInteligencia = new ComparatorCriterioSimple("inteligencia");
	Comparator<Enfrentable> cNado = new ComparatorCriterioSimple("nada");

	ComparatorCompuesto comparaNadoLuegoInteli = new ComparatorCompuesto(Arrays.asList(cNado, cInteligencia));
	Juego j = new Juego();

	@Before
	public void setUp() throws Exception {
		batman.addAtributo("velocidad", new AtributoSimple(30.0f));
		batman.addAtributo("inteligencia", new AtributoSimple(3000.0f));
		superman.addAtributo("velocidad", new AtributoSimple(3000.0f));
		superman.addAtributo("inteligencia", new AtributoSimple(200.0f));
		aquaman.addAtributo("nada", new AtributoSimple(100.0f));

		lexlutor.addAtributo("inteligencia", new AtributoSimple(1000.0f));


		ligaDelBien.addIntegrante(batman);
		ligaDelBien.addIntegrante(superman);
		ligaDelMal.addIntegrante(lexlutor);
		ligaAquatica.addIntegrante(aquaman);

		j.addEnfrentable(ligaDelBien);
		j.addEnfrentable(ligaDelMal);
		j.addEnfrentable(lexlutor);
		j.addEnfrentable(superman);
		j.addEnfrentable(batman);
		j.addEnfrentable(aquaman);
	}

	@Test
	public void agregarEnfrentableNullTest() {
		assertFalse(j.addEnfrentable(null));
	}

	@Test
	public void agregarRepetidoTest() {
		assertFalse(j.addEnfrentable(ligaDelBien));
		;
	}

	@Test
	public void agregarNuevaLigaTest() {
		assertTrue(j.addEnfrentable(ligaAquatica));
		;
	}

	@Test
	public void getQuienesVencenNingunoTest() {
		List<Enfrentable> ganadores = j.getQuienesVencen(aquaman, cNado);
		assertEquals(0, ganadores.size());
	}

	@Test
	public void getQuienesVencenTodosTest() {
		List<Enfrentable> ganadores = j.getQuienesVencen(aquaman, cInteligencia);
		assertTrue(ganadores.contains(batman));
		assertTrue(ganadores.contains(superman));
		assertTrue(ganadores.contains(lexlutor));
		assertTrue(ganadores.contains(ligaDelBien));
		assertTrue(ganadores.contains(ligaDelMal));
		assertFalse(ganadores.contains(aquaman));
	}

	@Test
	public void ordenarPorInteligenciaDescendenteTest() {
		List<Personaje> ordenadosPorInteligencia = Arrays.asList(batman, lexlutor, superman, aquaman);
		List<Personaje> resultado = j.ordenarPersonajes(cInteligencia.reversed());
		AuxiliaresTest.assertArrayEquals(ordenadosPorInteligencia, resultado);
	}

	@Test
	public void ordenarPorInteligenciaAscendenteTest() {
		List<Personaje> ordenadosPorInteligencia = Arrays.asList(aquaman, superman, lexlutor, batman);
		List<Personaje> resultado = j.ordenarPersonajes(cInteligencia);
		AuxiliaresTest.assertArrayEquals(ordenadosPorInteligencia, resultado);
	}

	@Test
	public void ordenarPorNadoLuegoInteligenciaAscendenteTest() {
		List<Personaje> ordenadosPorInteligencia = Arrays.asList(superman, lexlutor, batman, aquaman);
		List<Personaje> resultado = j.ordenarPersonajes(comparaNadoLuegoInteli);
		AuxiliaresTest.assertArrayEquals(ordenadosPorInteligencia, resultado);
	}

}
