package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personajes.Piccolo;
import fiuba.algo3.modelo.Personajes.Goku;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.excepciones.*;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Tablero;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class GohanTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01seUbicaPersonajeGohanEnCasilleroYSeLoMueve() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        gohan.mover(otraCoordenada);

        assertTrue(gohan.estaUbicadoEn(otraCoordenada));

    }

    @Test
    public void testTransformarPersonajeGohanEstadoSuperSayajinFase1() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        Goku goku = new Goku();
        goku.naceEn(otraCoordenada1);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            gohan.mover(unaCoordenada);
        }

        gohan.transformarse(goku, piccolo);

        // si esta en modo fortalecido su ki disminuye 10un
        assertTrue(gohan.poseeKi(40));
    }

    @Test
    public void testNoSePuedeTransformarPersonajeGohanEstadoSuperSayajinFase1() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        Goku goku = new Goku();
        goku.naceEn(otraCoordenada1);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        thrown.expect(NoSePuedeTransformarPersonaje.class);
        gohan.transformarse(goku,piccolo);
    }

    @Test
    public void testTransformarPersonajeGokuEstadoSuperSayajin2() {

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);


        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        for (int i = 0; i < 5; i++) {
            //va a incrementar el ki
            gohan.mover(otraCoordenada1);
        }

        gohan.transformarse(goku,piccolo);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            gohan.mover(otraCoordenada1);
        }

        goku.recibirDanio(350);
        piccolo.recibirDanio(350);

        gohan.transformarse(goku,piccolo);

        assertTrue(gohan.poseeKi(35));
    }

    @Test
    public void testNoSePuedeTransformarGokuEstadoSuperSayajin2UnCompañeroNotieneEstadoCritico() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);


        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        for (int i = 0; i < 5; i++) {
            //va a incrementar el ki
            gohan.mover(otraCoordenada1);
        }

        gohan.transformarse(goku,piccolo);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            gohan.mover(otraCoordenada1);
        }
        piccolo.recibirDanio(350);

        thrown.expect(NoSePuedeTransformarPersonaje.class);
        gohan.transformarse(goku,piccolo);

    }

    @Test
    public void testNoSePuedeTransformarGokuEstadoSuperSayajin2NoPoseeKiSuficiente(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);


        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        for (int i = 0; i < 5; i++) {
            //va a incrementar el ki
            gohan.mover(otraCoordenada1);
        }

        gohan.transformarse(goku,piccolo);

        piccolo.recibirDanio(350);
        goku.recibirDanio(350);

        thrown.expect(NoSePuedeTransformarPersonaje.class);
        gohan.transformarse(goku,piccolo);

    }

    

}