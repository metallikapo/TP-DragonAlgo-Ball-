package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personajes.EquipoGuerrerosZ;
import fiuba.algo3.modelo.Juego.Jugador;
import org.junit.Test;

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

}