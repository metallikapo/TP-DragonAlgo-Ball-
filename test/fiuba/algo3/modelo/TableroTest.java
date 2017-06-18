package fiuba.algo3.modelo;

<<<<<<< HEAD
=======

import fiuba.algo3.modelo.excepciones.CeldaNoOcupadaException;
>>>>>>> 1fa895ef3fc9224f03e1d237c91c06c324a1425e
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Tablero;
import fiuba.algo3.modelo.excepciones.CeldaOcupadaException;

public class TableroTest {

	
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

	@Test
    public void test02LiberarCeldaNoOcupadaYRecibirExcepcion(){
	    Coordenada unaCoordenada = new Coordenada(1, 2);
	    Tablero tablero = new Tablero(6);

	    thrown.expect(CeldaNoOcupadaException.class);
	    tablero.liberarCeldaEnTablero(unaCoordenada);
    }
	
}

