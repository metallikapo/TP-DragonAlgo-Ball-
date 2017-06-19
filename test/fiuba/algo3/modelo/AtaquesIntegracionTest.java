package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personajes.*;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AtaquesIntegracionTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01SeUbicaAGokuYAFreezerSeAtacanConAtaqueBasicoSegunDistancias(){

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        Freezer freezer = new Freezer();
        freezer.naceEn(otraCoordenada);

        //goku ataca a freezer
        //assert freezer recibe danio

        //freezer ataca a goku
        //assert goku recibe danio
        //goku ataca a freezer
        //freezer ataca a goku
        //assert ni goku ni freezer reciben danio

    }

    @Test
    public void test01SeUbicaAGokuYAFreezerSeAtacanConAtaqueEspecialesSegunDistancias(){

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        Freezer freezer = new Freezer();
        freezer.naceEn(otraCoordenada);

        //goku ataca a freezer
        //assert freezer recibe danio

        //freezer ataca a goku
        //assert goku recibe danio
        //goku ataca a freezer
        //freezer ataca a goku
        //assert ni goku ni freezer reciben danio

    }

    //habria que hacer las pruebas de ataque con los personajes transformados

    @Test
    public void test01SeUbicaAGokuYAGohanGokuAtacaGohanYSeProduceUnaExcepcion() {

        Coordenada posicionInicialGoku = new Coordenada(0, 0);
        Coordenada posicionInicialGohan = new Coordenada(0, 2);

        Goku goku = new Goku();
        goku.naceEn(posicionInicialGoku);

        Gohan gohan = new Gohan();
        gohan.naceEn(posicionInicialGohan);

        thrown.expect(FuegoAmigoException.class);
        goku.ataqueBasico(gohan); //me obliga castearlo
    }

    @Test
    public void test01SeUbicaACellYAFreezerCellAtacaFreezerYSeProduceUnaExcepcion() {

        Coordenada posicionInicialCell = new Coordenada(0, 0);
        Coordenada posicionInicialFreezer = new Coordenada(0, 2);

        Cell cell = new Cell();
        cell.naceEn(posicionInicialCell);

        Freezer freezer = new Freezer();
        freezer.naceEn(posicionInicialFreezer);

        thrown.expect(FuegoAmigoException.class);
        cell.ataqueBasico(freezer);
    }
}