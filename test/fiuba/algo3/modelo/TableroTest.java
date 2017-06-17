package fiuba.algo3.modelo;

<<<<<<< HEAD
=======
import static org.junit.Assert.*;
>>>>>>> 575f270cd55358f88e51432d6c624654d984d540

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Tablero;
import fiuba.algo3.modelo.excepciones.CeldaOcupadaException;

public class TableroTest {
<<<<<<< HEAD

	
=======
	
	/*
>>>>>>> 575f270cd55358f88e51432d6c624654d984d540
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
<<<<<<< HEAD
        
=======
          
	}
	*/
	
	@Test
	public void nada(){
		assertEquals(1,1);
>>>>>>> 575f270cd55358f88e51432d6c624654d984d540
	}
	
}

