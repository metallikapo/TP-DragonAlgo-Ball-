import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class personajeTest{

    @Test
    public void test01verificarPersonajeEnCasilleroNuevo(){

        Jugador jugador1 = new Jugador("juagdor1");
        Jugador jugador2 = new Jugador("jugador2");
        Goku goku = new Goku();
        Tablero tablero = new Tablero(7); // define tablero de 7x7

        Casillero casillero = tablero.obtenerCasillero(1,3);
        jugador1.ubicarPersonaje(goku,casillero);

        Casillero casilleroNuevo = tablero.obtenerCasillero(0,1);

        assertTrue(goku.verificarPosicion(casilleroNuevo));
    }

    @Test
    public void test02verificarQueHayaUnSoloPersonajeEnUnCasillero(){

        Goku goku = new Goku();
        Tablero tablero = new Tablero(7); // define tablero de 7x7

        Casillero casillero = tablero.obtenerCasillero(1,3);
        //jugador1.ubicarPersonaje(goku,casillero);

        Casillero casilleroNuevo = tablero.obtenerCasillero(0,1);

        asserTrue(casilleroNuevo.estaDesocupado());
    }

    @Test
    public void test03verificarQuePersonajeNoPasePorCasilleroQueTienePersonaje(){

        Goku goku = new Goku();
        Cell cell = new Cell();
        Pasos conjuntoCeldas = new Pasos();

        Tablero tablero = new Tablero(7); // define tablero de 7x7

        Casillero casilleroGoku = tablero.obtenerCasillero(1,3);
        //jugador1.ubicarPersonaje(goku,casillero);

        Casillero casilleroCell = tablero.obtenerCasillero(0,1);
        Casillero casilleroNuevoCell = tableroObtenerCasillero(2,2);
        conjuntoCeldas.agregarPaso(casilleroCell);
        conjuntoCeldas.agregarPaso(casilleroNuevoCell);

        assertTrue(tablero.caminoDesocupado(conjuntoCeldas));

    }

    @Test
    public void test04verificarTransformacion(){

    }
}