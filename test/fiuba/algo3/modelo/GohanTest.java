package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personajes.*;
import fiuba.algo3.modelo.excepciones.*;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Tablero;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
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
    public void testTransformarPersonajeGokuEstadoSuperSayajin2DisminuyeKI() {

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
    public void testNoSePuedeTransformarGokuEstadoSuperSayajin2UnCompanieroNotieneEstadoCritico() {
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

    @Test
    public void ataqueMasenkoGohanDisminuye10unKi(){

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);
        Coordenada otraCoordenada = new Coordenada(2,0);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(otraCoordenada1);

        for(int i=0; i<5 ; i++){
            gohan.mover(otraCoordenada);
        }

        gohan.masenko(majinboo);
        assertTrue(gohan.poseeKi(15));
    }

    @Test
    public void ataqueMasenkoGohanAtacaAMajibooDisminuyeVidaUn25porcMasQueBasico(){

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);
        Coordenada otraCoordenada = new Coordenada(2,0);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(otraCoordenada1);

        for(int i=0; i<5 ; i++){
            gohan.mover(otraCoordenada);
        }

        gohan.masenko(majinboo);
        assertTrue(majinboo.poseeVida(282));
    }

    @Test
    public void ataqueMasenkoAunCompanieroExcepcionNoProduceDanioNiDisminuyeSuKi() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);
        Coordenada otraCoordenada = new Coordenada(2, 0);

        Goku goku = new Goku();
        goku.naceEn(otraCoordenada1);
    }

    public void testGohanNaceEnUnaCeldaYseMueveArribaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        assertEquals(gohan.moverArriba().getCoordenadaX(), 5);
        assertEquals(gohan.moverArriba().getCoordenadaY(), 7);
    }

    @Test
    public void testGohanNaceEnUnaCeldaYseMueveAbajoAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        assertEquals(gohan.moverAbajo().getCoordenadaX(), 5);
        assertEquals(gohan.moverAbajo().getCoordenadaY(), 3);
    }

    @Test
    public void testGohanNaceEnUnaCeldaYseMueveAAIzquierdaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        assertEquals(gohan.moverAIzquierda().getCoordenadaX(), 3);
        assertEquals(gohan.moverAIzquierda().getCoordenadaY(), 5);
    }

    @Test
    public void testGohanNaceEnUnaCeldaYseMueveADerechaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        for(int i=0; i<5 ; i++){
            gohan.mover(otraCoordenada);
        }

        thrown.expect(FuegoAmigoException.class);
        gohan.masenko(goku);

        assertTrue(gohan.poseeKi(25));
        assertEquals(gohan.moverADerecha().getCoordenadaX(), 7);
        assertEquals(gohan.moverADerecha().getCoordenadaY(), 5);
    }

    @Test
    public void testGohanNaceEnUnaCeldaYseMueveASuperiorIzquierdaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        assertEquals(gohan.moverASuperiorIzquierda().getCoordenadaX(), 3);
        assertEquals(gohan.moverASuperiorIzquierda().getCoordenadaY(), 7);
    }

    @Test
    public void testGohanNaceEnUnaCeldaYseMueveASuperiorDerechaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        assertEquals(gohan.moverASuperiorDerecha().getCoordenadaX(), 7);
        assertEquals(gohan.moverASuperiorDerecha().getCoordenadaY(), 7);
    }

    @Test
    public void testGohanNaceEnUnaCeldaYseMueveAInferiorIzquierdaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        assertEquals(gohan.moverAInferiorIzquierda().getCoordenadaX(), 3);
        assertEquals(gohan.moverAInferiorIzquierda().getCoordenadaY(), 3);
    }

    @Test
    public void testGohanNaceEnUnaCeldaYseMueveAInferiorDerechaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        assertEquals(gohan.moverAInferiorDerecha().getCoordenadaX(), 7);
        assertEquals(gohan.moverAInferiorDerecha().getCoordenadaY(), 3);

    }


}