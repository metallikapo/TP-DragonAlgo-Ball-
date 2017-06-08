/**
 * Created by nico on 07/06/17.
 */

//import org.junit.Test;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsPrimeraEntrega {
    @Test
    public void testPunto1(){
        //Nace Goku
        //Goku se mueve
        //Verificar que Goku esta en la posicion ultima.
        Celda celdaNacimiento = new Celda(1,1);

        Goku goku = new Goku();
        Goku goku.nace(celdaNacimiento);
        goku.seMueveHaciaLaDerecha(2);

        Celda celdaVerificacion = new Celda(1,3);
        assertEquals(goku.posicion(),celdaVerificacion);
    }

}
