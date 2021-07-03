package heroesVillanosTest;

import static org.junit.Assert.*;

import java.util.List;


import main.Personaje;

public class AuxiliaresTest {

	public static void assertArrayEquals(List<Personaje> a , List<Personaje> b) {
		if(a.size() != b.size()) fail();
		for(int i=0; i<a.size(); i++) 
			assertTrue(a.get(i).equals(b.get(i)));
		
	}
	

}
