package fiuba.algo3.modelo;

import fiuba.algo3.modelo.excepciones.*;
import fiuba.algo3.modelo.Personajes.Freezer;
import fiuba.algo3.modelo.Personajes.Goku;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Tablero;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class FreezerTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01seUbicaPersonajeFreezerEnCasilleroYSeLoMueve() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        freezer.mover(otraCoordenada);

        assertTrue(freezer.estaUbicadoEn(otraCoordenada));

    }

    @Test
    public void test02NoSePuedeUbicarGokuYFreezerEnElMismoCasillero() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);
        Celda celdaNacimiento = new Celda(unaCoordenada);
        Celda otraCelda = new Celda(otraCoordenada);
        Tablero tablero = new Tablero(4);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        tablero.colocarCeldaEnTablero(celdaNacimiento);
        tablero.colocarCeldaEnTablero(otraCelda);

        Goku goku = new Goku();
        goku.naceEn(otraCoordenada);

        freezer.mover(otraCoordenada);
        thrown.expect(CeldaOcupadaException.class);
        tablero.colocarCeldaEnTablero(otraCelda);

    }

    @Test
    public void testTransformarPersonajeFreezerEstadoSegundaForma() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            freezer.mover(otraCoordenada1);
        }

        freezer.transformarse();

        // si esta en modo segunda forma su ki disminuye 20un
        assertTrue(freezer.poseeKi(30));
    }

    @Test
    public void testNoSePuedeTransformarPersonajeFreezerEstadoSegundaForma() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        thrown.expect(NoSePuedeTransformarPersonaje.class);
        freezer.transformarse();

        assertTrue(freezer.poseeKi(0));
    }

    @Test
    public void NoSePuedeTransformarPersonajeFreezerEnEstadoDefinitivo() {

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        for (int i = 0; i < 5; i++) {
            //va a incrementar el ki
            freezer.mover(otraCoordenada1);
        }

        freezer.transformarse();

        thrown.expect(NoSePuedeTransformarPersonaje.class);
        freezer.transformarse();

        assertTrue(freezer.poseeKi(5));
    }

    @Test
    public void TransformarFreezerEstadoDefinitivoKiDisminuye() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            freezer.mover(otraCoordenada1);
        }

        freezer.transformarse();

        for (int i = 0; i < 10; i++) {
            //va a incrementar el kif
            freezer.mover(otraCoordenada1);
        }

        freezer.transformarse();
        assertTrue(freezer.poseeKi(30));
    }

    @Test
    public void AtaqueRayoMortalDeFrizzerAGohanCuesta20deKi(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        Gohan gohan =new Gohan();
        gohan.naceEn(otraCoordenada1);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            freezer.mover(otraCoordenada1);
        }
        freezer.rayoMortal(gohan);
        assertTrue(freezer.poseeKi(30));
    }

    @Test
    public void AtaqueRayoMortalDeFrizzerAGohanDisminuyeVida50porcMasQueElBasico(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        Gohan gohan =new Gohan();
        gohan.naceEn(otraCoordenada1);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            freezer.mover(otraCoordenada1);
        }
        freezer.rayoMortal(gohan);
        assertTrue(gohan.poseeVida(270));
    }



}