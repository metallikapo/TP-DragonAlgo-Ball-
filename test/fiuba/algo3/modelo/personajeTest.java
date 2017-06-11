package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personajes.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class personajeTest{

    @Test
    public void test01seUbicaPersonajeGohanEnCasilleroYSeLoMueve(){
        Celda celdaNacimiento = new Celda(0,0);

        Gohan gohan = new Gohan();
        gohan.naceEn(celdaNacimiento);
        gohan.seMueveHaciaLaDerecha(2);

        Celda celdaNueva = new Celda(0,2);

        assertTrue(gohan.estaUbicadoEn(celdaNueva));

    }

    @Test
    public void test02seUbicaUnPersonajeGokuEnCasilleroYSeLoMueve(){
        Celda celdaNacimiento = new Celda(0,0);

        Goku goku = new Goku();
        goku.naceEn(celdaNacimiento);
        goku.seMueveHaciaLaDerecha(2);

        Celda celdaNueva = new Celda(0,2);

        assertTrue(goku.estaUbicadoEn(celdaNueva));

    }

    @Test
    public void test01seUbicaUnPersonajePiccoloEnCasilleroYSeLoMueve(){
        Celda celdaNacimiento = new Celda(0,0);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(celdaNacimiento);
        piccolo.seMueveHaciaLaDerecha(2);

        Celda celdaNueva = new Celda(0,2);

        assertTrue(piccolo.estaUbicadoEn(celdaNueva));

    }

}