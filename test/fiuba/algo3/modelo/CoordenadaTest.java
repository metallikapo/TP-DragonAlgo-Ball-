package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Componentes.Coordenada;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoordenadaTest {
	
	@Test
	public void crearUnaCoordenada(){
		Coordenada unaCoordenada = new Coordenada(2,3);
		
		assertEquals(unaCoordenada.getCoordenadaX(), 2);
		assertEquals(unaCoordenada.getCoordenadaY(), 3);
	}

	@Test
	public void compararDosCoordenadas(){
		Coordenada unaCoordenada = new Coordenada(0, 0);
		Coordenada otraCoordenada = new Coordenada(1,0);
		Coordenada mismaCoordenada = new Coordenada(0,0);

		assertFalse(unaCoordenada.esLaMismaCoordenada(otraCoordenada));
		assertTrue(unaCoordenada.esLaMismaCoordenada(mismaCoordenada));
	}

}
