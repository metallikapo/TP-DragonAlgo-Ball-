package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personajes.EquipoGuerrerosZ;
import fiuba.algo3.modelo.Juego.Jugador;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JugadorTest {
    @Test
    public void crearJugador(){
        Jugador jugador = new Jugador("Juan");
    }


    @Test
    public void seleccionarComoEquipoGuerreroZ(){
        Jugador jugador = new Jugador("Zero");
        EquipoGuerrerosZ equipo = new EquipoGuerrerosZ();
        jugador.asignarEquipo(equipo);
    }

    @Test
    public void asignarRivalAJugador(){
        Jugador jugador1 = new Jugador("Fede");
        Jugador jugador2 = new Jugador("Mirna");
        jugador1.asignarRival(jugador2);
        jugador2.asignarRival(jugador1);

        assertEquals(jugador1, jugador2.rival());
        assertEquals(jugador2, jugador1.rival());
    }

}