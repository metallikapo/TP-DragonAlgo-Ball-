package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personajes.Goku;
import fiuba.algo3.modelo.Personajes.Freezer;
import fiuba.algo3.modelo.Componentes.Coordenada;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AtaquesIntegracionTest {

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
}