package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personajes.*;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Tablero;
import fiuba.algo3.modelo.excepciones.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class PiccoloTest{

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01seUbicaPersonajePiccoloEnCasilleroYSeLoMueve(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(0,2);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);
            
        piccolo.mover(otraCoordenada);

        assertTrue(piccolo.estaUbicadoEn(otraCoordenada));

    }

    @Test
    public void test02NoSePuedeUbicarPiccoloYGohanEnElMismoCasillero(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(0,2);
        Celda celdaNacimiento = new Celda(unaCoordenada);
        Celda otraCelda = new Celda(otraCoordenada);
        Tablero tablero = new Tablero(4);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);
        tablero.colocarCeldaEnTablero(celdaNacimiento);
        tablero.colocarCeldaEnTablero(otraCelda);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(otraCoordenada);

        gohan.mover(otraCoordenada);
        thrown.expect(CeldaOcupadaException.class);
        tablero.colocarCeldaEnTablero(otraCelda);

    }

    @Test
    public void testTransformarPersonajePiccoloEstadoFortalecido(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(0,2);
        Coordenada otraCoordenada1 = new Coordenada(0,1);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        Gohan gohan = new Gohan();
        gohan.naceEn(otraCoordenada);

        for (int i=0; i<10; i++){
            //va a incrementar el ki
            piccolo.mover(otraCoordenada1);
        }

        piccolo.transformarse(gohan);

        // si esta en modo fortalecido su ki disminuye 20un
        assertTrue(piccolo.poseeKi(30));
    }

    @Test
    public void testNoSePuedeTransformarPersonajePiccoloEstadoFortalecido(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(0,2);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        Gohan gohan = new Gohan();
        gohan.naceEn(otraCoordenada);

        thrown.expect(NoSePuedeTransformarPersonaje.class);
        piccolo.transformarse(gohan);
    }

    @Test
    public void testNoSePuedeTransformarPersonajePiccoloEnEstadoProtector(){

        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(0,2);
        Coordenada otraCoordenada1 = new Coordenada(0,1);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        Gohan gohan = new Gohan();
        gohan.naceEn(otraCoordenada);

        for (int i=0; i<10; i++){
            //va a incrementar el ki
            piccolo.mover(otraCoordenada1);
        }

        piccolo.transformarse(gohan);

        thrown.expect(NoSePuedeTransformarPersonaje.class);
        piccolo.transformarse(gohan);
    }

    @Test
    public void testTransformarPiccoloEnEstadoProtector(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(0,2);
        Coordenada otraCoordenada1 = new Coordenada(0,1);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        Gohan gohan = new Gohan();
        gohan.naceEn(otraCoordenada);

        for (int i=0; i<10; i++){
            //va a incrementar el ki
            piccolo.mover(otraCoordenada1);
            gohan.recibirDanio(24);
        }

        piccolo.transformarse(gohan);

        piccolo.transformarse(gohan);

        assertTrue(gohan.estadoVidaCritica());
    }

}