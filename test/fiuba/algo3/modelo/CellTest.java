package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personajes.Goku;
import fiuba.algo3.modelo.Personajes.Cell;
import fiuba.algo3.modelo.Personajes.MajinBoo;
import fiuba.algo3.modelo.excepciones.*;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Tablero;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class CellTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01seUbicaPersonajeCellEnCasilleroYSeLoMueve() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);

        cell.mover(otraCoordenada);

        assertTrue(cell.estaUbicadoEn(otraCoordenada));

    }

    @Test
    public void test02NoSePuedeUbicarMajinBooYCellEnElMismoCasillero() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);
        Celda celdaNacimiento = new Celda(unaCoordenada);
        Celda otraCelda = new Celda(otraCoordenada);
        Tablero tablero = new Tablero(4);


        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);

        tablero.colocarCeldaEnTablero(celdaNacimiento);
        tablero.colocarCeldaEnTablero(otraCelda);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(otraCoordenada);

        cell.mover(otraCoordenada);
        thrown.expect(CeldaOcupadaException.class);
        tablero.colocarCeldaEnTablero(otraCelda);

    }

    @Test
    public void TransformarPersonajeEstadoSemiPerfectoAbsorbeVidaVerificaLaAbsorcion() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);

        Goku goku = new Goku();
        goku.naceEn(otraCoordenada1);

        for (int i=0; i<4; i++){
            cell.mover(otraCoordenada1);
            cell.absorber(goku);
        }

        cell.transformarse();

        assertTrue(cell.poseeVida(580));
    }

    @Test
    public void NoSePuedeTransformarPersonajeSemiPerfectoPorNoAbsorberVida() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);

        thrown.expect(NoSePuedeTransformarPersonaje.class);
        cell.transformarse();
    }

    @Test
    public void NoSePuedeTransformarPersonajeEstadoPerfectoExcepcion() {

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);
        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);

        Goku goku = new Goku();
        goku.naceEn(otraCoordenada1);

        for (int i = 0; i < 4; i++) {
            //va a incrementar el ki
            cell.mover(otraCoordenada1);
            cell.absorber(goku);
        }

        cell.transformarse();

        thrown.expect(NoSePuedeTransformarPersonaje.class);
        cell.transformarse();
    }

    @Test
    public void TransformarEstadoPerfectoAbsorbeVidaDeGokuVerificaSiSumoLaSuya() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);
        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);

        Goku goku = new Goku();
        goku.naceEn(otraCoordenada1);

        for (int i = 0; i < 4; i++) {
            cell.mover(otraCoordenada1);
            cell.absorber(goku);
        }

        cell.transformarse();

        for (int i = 0; i < 8; i++) {
            cell.mover(otraCoordenada1);
            cell.absorber(goku);
        }
        cell.transformarse();

        assertTrue(cell.poseeVida(740));
    }

    @Test
    public void testCellAbsorbeVidaDeGoku4VecesEnEstadoNormal() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);
        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);

        Goku goku = new Goku();
        goku.naceEn(otraCoordenada1);

        for (int i = 0; i < 4; i++) {
            cell.mover(otraCoordenada1);
            cell.absorber(goku);
        }

        cell.transformarse();

        assertTrue(goku.poseeVida(420));
    }

    @Test
    public void cellNoPuedeAbsorberVidaPOrFaltaDeKi(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);
        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);

        Goku goku = new Goku();
        goku.naceEn(otraCoordenada1);

        thrown.expect(NoSePuedeAbsorberPersonajeException.class);
        cell.absorber(goku);

        assertTrue(cell.poseeKi(0));
        assertTrue(goku.poseeKi(500));
    }

    @Test
    public void CellNoPuedeAbsorberVidaDeMajinBooNoProduceDanio(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);
        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);

        MajinBoo majinBoo = new MajinBoo();
        majinBoo.naceEn(otraCoordenada1);

        cell.mover(unaCoordenada);

        try{
            cell.absorber(majinBoo);
        }catch (FuegoAmigoException ignored){

        }

        assertTrue(majinBoo.poseeVida(300));
    }

    @Test
    public void testCellNaceEnUnaCeldaYseMueveArribaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = cell.moverArriba();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 5);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 7);
    }

    @Test
    public void testCellNaceEnUnaCeldaYseMueveAbajoAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = cell.moverAbajo();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 5);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 3);
    }

    @Test
    public void testCellNaceEnUnaCeldaYseMueveAAIzquierdaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = cell.moverAIzquierda();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 3);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 5);
    }

    @Test
    public void testCellNaceEnUnaCeldaYseMueveADerechaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = cell.moverADerecha();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 7);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 5);
    }

    @Test
    public void testCellNaceEnUnaCeldaYseMueveASuperiorIzquierdaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = cell.moverASuperiorIzquierda();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 3);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 7);
    }

    @Test
    public void testCellNaceEnUnaCeldaYseMueveASuperiorDerechaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = cell.moverASuperiorDerecha();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 7);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 7);
    }

    @Test
    public void testCellNaceEnUnaCeldaYseMueveAInferiorIzquierdaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = cell.moverAInferiorIzquierda();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 3);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 3);
    }

    @Test
    public void testCellNaceEnUnaCeldaYseMueveAInferiorDerechaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = cell.moverAInferiorDerecha();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 7);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 3);
    }


}