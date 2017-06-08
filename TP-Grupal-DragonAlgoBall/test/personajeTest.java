import TPGrupalDragonAlgoBall.src.modelo.personajes.Goku;
import TPGrupalDragonAlgoBall.src.modelo.tablero.Tablero;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class personajeTest{

    @Test
    public void test01moverYVerificarPersonajeEnCasilleroNuevo(){

        Goku goku = new Goku();
        Tablero tablero = new Tablero(7); // define tablero de 7x7

        tablero.ubicarPersonaje(goku,0,0);

        assertTrue(tablero.sePuedeMoverPersonaje(goku,0,2));
    }

    @Test
    public void test02verificarQueHayaUnSoloPersonajeEnUnCasillero(){

        Goku goku = new Goku();
        Gohan gohan = new Gohan();
        Tablero tablero = new Tablero(7); // define tablero de 7x7

        tablero.ubicarPersonaje(goku,0,0);
        tablero.ubicarPersonaje(gohan,0,1);

        //exception??
        assertFalse(tablero.sePuedeMoverPersonaje(goku,0,1));
    }

    @Test
    public void test03verificarQuePersonajeNoPasePorCasilleroQueTienePersonaje(){

        Goku goku = new Goku();
        Gohan gohan = new Gohan();
        Tablero tablero = new Tablero(7); // define tablero de 7x7

        tablero.ubicarPersonaje(goku,0,0);
        tablero.ubicarPersonaje(gohan,1,1);

        //exception
        assertFalse(tablero.sePuedeMoverPersonaje(goku,2,2));

    }

    @Test
    public void test04verificarTransformacion(){

        Goku goku = new Goku();
        Tablero tablero = new Tablero(7);

        tablero.ubicarPersonaje(goku,0,0);
        goku.modificarKi(20);

        assertTrue(goku.sePuedeTransformar());
    }

    @Test
    public void test05verificarUbicacionDespuesDeLaTransformacion(){

        Goku goku = new Goku();
        Tablero tablero = new Tablero(7);

        tablero.ubicarPersonaje(goku,0,0);
        goku.modificarKi(20);

        goku.transformar();

        assertTrue(tablero.sePuedeMoverPersonaje(goku,3,3));
    }

    @Test
    public void test06inicializarPartida(){

        Jugador jugador1 = new Jugador("1");
        Jugador jugador2 = new Jugador("2");
        //Puede existir una interfaz equipo
        EquipoZ equipo1 = new EquipoZ();
        EquipoEnemigo equipo2 = new EquipoEnemigo();
        Tablero tablero = new Tablero(7);

        jugador1.asignarEquipo(equipo1);
        jugador2.asignarEquipo(equipo2);

        tablero.inicializarTablero(equipo1,equipo2);

        assertTrue(tablero.esGuerreroZ(0,0));
        assertTrue(tablero.esGuerreroZ(0,1));
        assertTrue(tablero.esGuerreroZ(1,0));
        assertTrue(tablero.esEnemigo(6,6));
        assertTrue(tablero.esEnemigo(5,6));
        assertTrue(tablero.esEnemigo(6,5));
    }

    @Test
    public void test07verificarAtaqueBasicoSegunDistancia(){

        //Puede existir una interfaz equipo
        Tablero tablero = new Tablero(7);
        Goku goku = new Goku();
        Cell cell = new Cell();

        tablero.ubicarPersonaje(goku,0,0);
        tablero.ubicarPersonaje(cell,3,3);

        int distancia = tablero.calcularDistancia(goku,cell);
        int vidaCell = cell.getPuntosVida();
        goku.ataqueBasico(cell,distancia);

        assertFalse(cell.getPuntosVida()<vidaCell);

        int vidaGoku = goku.getPuntosVida();
        cell.ataqueBasico(goku,distancia);

        assertTrue(goku.getPuntosVida()<vidaGoku);

    }
}