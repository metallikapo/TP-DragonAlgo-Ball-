package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personajes.Goku;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Personajes.Cell;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Tablero;
import fiuba.algo3.modelo.excepciones.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.rules.ExpectedException;


public class GokuTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01seUbicaPersonajeGokuEnCasilleroYSeLoMueve() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        goku.mover(otraCoordenada);

        assertTrue(goku.estaUbicadoEn(otraCoordenada));

    }

    @Test
    public void test02NoSePuedeUbicarGokuYGohanEnElMismoCasillero() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);
        Celda celdaNacimiento = new Celda(unaCoordenada);
        Celda otraCelda = new Celda(otraCoordenada);
        Tablero tablero = new Tablero(4);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);
        tablero.colocarCeldaEnTablero(celdaNacimiento);
        tablero.colocarCeldaEnTablero(otraCelda);

        Goku goku = new Goku();
        goku.naceEn(otraCoordenada);

        gohan.mover(otraCoordenada);
        thrown.expect(CeldaOcupadaException.class);
        tablero.colocarCeldaEnTablero(otraCelda);

    }

    @Test
    public void testTransformarPersonajeGokuEstadoKaioKenDisminuyeKi() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            goku.mover(otraCoordenada1);
        }

        goku.transformarse();

        // si esta en modo KaioKen su ki disminuye 20un
        assertTrue(goku.poseeKi(30));
    }

    @Test
    public void testNoSePuedeTransformarPersonajeGokuEstadoKaioKenExcepcion() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        thrown.expect(NoSePuedeTransformarPersonaje.class);
        goku.transformarse();
    }

    @Test
    public void testNoSePuedeTransformarPersonajeGokuEstadoSuperSayajinExcepcion() {

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        for (int i = 0; i < 5; i++) {
            //va a incrementar el ki
            goku.mover(otraCoordenada1);
        }

        goku.transformarse();

        thrown.expect(NoSePuedeTransformarPersonaje.class);
        goku.transformarse();
    }

    @Test
    public void testTransformarGokuEstadoSuperSayajinDisminuyeKi() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            goku.mover(otraCoordenada1);
        }

        goku.transformarse();

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            goku.mover(otraCoordenada1);
        }

        goku.transformarse();

        assertTrue(goku.poseeKi(30));
    }

    @Test
    public void gokuAtacaACellConKamehamehaDisminuyKIgoku(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        Cell cell = new Cell();
        cell.naceEn(otraCoordenada1);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            goku.mover(unaCoordenada);
        }

        goku.kamehameha(cell);
        assertTrue(goku.poseeKi(30));
    }

    @Test
    public void gokuAtacaConKamehamehaACellDisminuyeLaVida30unKi(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        Cell cell = new Cell();
        cell.naceEn(otraCoordenada1);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            goku.mover(unaCoordenada);
        }

        goku.kamehameha(cell);
        assertTrue(cell.poseeVida(470));
    }


    public void testGokuNaceEnUnaCeldaYseMueveArribaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        assertEquals(goku.moverArriba().getCoordenadaY(), 7);
        assertEquals(goku.moverArriba().getCoordenadaX(), 5);
    }


}