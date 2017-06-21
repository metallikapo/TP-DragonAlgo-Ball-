package fiuba.algo3.modelo;


import fiuba.algo3.modelo.excepciones.*;
import fiuba.algo3.modelo.Personajes.Cell;
import fiuba.algo3.modelo.Personajes.Freezer;
import fiuba.algo3.modelo.Personajes.MajinBoo;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Tablero;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class MajinBooTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01seUbicaPersonajeMajinBooEnCasilleroYSeLoMueve() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(unaCoordenada);

        majinboo.mover(otraCoordenada);

        assertTrue(majinboo.estaUbicadoEn(otraCoordenada));

    }

    @Test
    public void test02NoSePuedeUbicarMajinBooYFreezerEnElMismoCasillero() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);
        Celda celdaNacimiento = new Celda(unaCoordenada);
        Celda otraCelda = new Celda(otraCoordenada);
        Tablero tablero = new Tablero(4);


        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        tablero.colocarCeldaEnTablero(celdaNacimiento);
        tablero.colocarCeldaEnTablero(otraCelda);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(otraCoordenada);

        freezer.mover(otraCoordenada);
        thrown.expect(CeldaOcupadaException.class);
        tablero.colocarCeldaEnTablero(otraCelda);

    }

    @Test
    public void testTransformarPersonajeEstadoBooMaloDisminuyeKi() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(unaCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            majinboo.mover(otraCoordenada1);
        }

        majinboo.transformarse();

        // si esta en modo fortalecido su ki disminuye 20un
        assertTrue(majinboo.poseeKi(30));
    }

    @Test
    public void testNoSePuedeTransformarPersonajeEstadoBooMaloExcepcion() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(unaCoordenada);

        thrown.expect(NoSePuedeTransformarPersonaje.class);
        majinboo.transformarse();
    }

    @Test
    public void testNoSePuedeTransformarPersonajeEstadoBooOriginalExcepcion() {

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);
        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(unaCoordenada);

        for (int i = 0; i < 5; i++) {
            //va a incrementar el ki
            majinboo.mover(otraCoordenada1);
        }

        majinboo.transformarse();

        thrown.expect(NoSePuedeTransformarPersonaje.class);
        majinboo.transformarse();
    }

    @Test
    public void testTransformarEstadoBooOriginalDisminuyeKi() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(unaCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            majinboo.mover(otraCoordenada1);
        }

        majinboo.transformarse();

        for (int i = 0; i < 10; i++) {
            //va a incrementar el kif
            majinboo.mover(otraCoordenada1);
        }

        majinboo.transformarse();

        assertTrue(majinboo.poseeKi(30));
    }

    @Test
    public void MajinbooNoPuedeAtacarAUnCompanieroEquipoNoProduceDanio(){

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(otraCoordenada1);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            majinboo.mover(otraCoordenada1);
        }
        thrown.expect(FuegoAmigoException.class);
        majinboo.ataqueBasico(cell);

        assertTrue(cell.poseeVida(500));

    }

}