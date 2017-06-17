package fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Tablero;
import fiuba.algo3.modelo.excepciones.CeldaOcupadaException;

public class TableroTest {
	
	/*
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void test01LanzarExcepcionCuandoUnaCeldaEstaOcupada(){
        Coordenada unaCoordenada = new Coordenada(1,2);
        
        Celda unaCelda = new Celda(unaCoordenada);
        Celda otraCelda = new Celda(unaCoordenada);
        
        Tablero tablero = new Tablero(6);
        tablero.colocarCeldaEnTablero(unaCelda);
        
        thrown.expect(CeldaOcupadaException.class);
        tablero.colocarCeldaEnTablero(otraCelda);
          
	}
	*/
	
	@Test
	public void nada(){
		assertEquals(1,1);
	}
	
}

