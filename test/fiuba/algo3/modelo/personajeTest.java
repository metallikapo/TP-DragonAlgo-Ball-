package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personaje.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class personajeTest{

    @Test
    public void test01seUbicaUnPersonajeEnCasilleroYSeLoMueve(){
        Celda celdaNacimiento = new Celda(0,0);

        Gohan gohan = new Gohan();
        gohan.naceEn(celdaNacimiento);
        gohan.seMueveHaciaLaDerecha(2);

        Celda celdaNueva = new Celda(0,2);

        assertTrue(gohan.estaUbicadoEn(celdaNueva));

    }

}