package fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.Componentes.Coordenada;

public class CoordenadaTest {
	
	@Test
	public void crearUnaCoordenada(){
		Coordenada unaCoordenada = new Coordenada(2,3);
		
		assertEquals(unaCoordenada.getCoordenadaX(), 2);
		assertEquals(unaCoordenada.getCoordenadaY(), 3);
	}

}
