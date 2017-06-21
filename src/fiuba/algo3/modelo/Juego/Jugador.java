package fiuba.algo3.modelo.Juego;

import fiuba.algo3.modelo.Personajes.Equipo;
import fiuba.algo3.modelo.Personajes.EquipoGuerrerosZ;

public class Jugador {
    private String nombre;
    private Equipo equipo;
    private Jugador rival;

    public Jugador(String nombreJugador) {
        this.nombre = nombreJugador;
    }

    public void asignarEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void asignarRival(Jugador jugadorRival) {
        this.rival = jugadorRival;
    }

    public Jugador rival() {
        return this.rival;
    }
}
