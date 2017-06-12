package fiuba.algo3.Entregas;

import fiuba.algo3.modelo.Excepciones.ErrorCaminoInvalido;
import fiuba.algo3.modelo.Excepciones.ErrorCeldaOcupada;
import fiuba.algo3.modelo.Juego.Tablero;
import fiuba.algo3.modelo.Juego.Ubicacion;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Personajes.Goku;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nico on 11/6/2017.
 */


public class PrimeraEntregaTests {
    @Test
    public void test01seUbicaPersonajeGohanEnCasilleroYSeLoMueve() {
        Tablero tablero = new Tablero();
        Ubicacion ubicacionInicial = new Ubicacion(0,0);
        Gohan gohan = new Gohan(tablero, ubicacionInicial);
        assertEquals(gohan.obtenerUbicacionActual(), ubicacionInicial);
        Ubicacion nuevaUbicacion = new Ubicacion(0, 2);
        gohan.seMueveHacia(tablero, nuevaUbicacion);
        assertEquals(gohan.obtenerUbicacionActual(), nuevaUbicacion);
    }

    @Test(expected = ErrorCeldaOcupada.class)
    public void test02Colocar2PersonajesEnMismaCeldaYLanzarExcepcion(){
        Tablero tablero = new Tablero();
        Ubicacion ubicacionInicial = new Ubicacion(0,0);
        Gohan gohan = new Gohan(tablero, ubicacionInicial);
        Goku goku = new Goku(tablero, ubicacionInicial);
    }

//    @Test(expected = ErrorCaminoInvalido.class)
//    public void test03ColocarPersonajeEnCamino(){
//        Tablero tablero = new Tablero();
//        Ubicacion ubicacionGohan = new Ubicacion(0,0);
//        Ubicacion ubicacionGoku = new Ubicacion(0,1);
//
//        Gohan gohan = new Gohan(tablero, ubicacionGohan);
//        Goku goku = new Goku(tablero, ubicacionGoku);
//
//        ubicacionGohan.setCoordenada(0,2);
//        gohan.seMueveHacia(tablero,ubicacionGohan);
//    }
}
