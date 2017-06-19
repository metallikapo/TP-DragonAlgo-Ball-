package fiuba.algo3.modelo.Juego;

import fiuba.algo3.modelo.Personajes.Equipo;
import fiuba.algo3.modelo.Personajes.EquipoGuerrerosZ;

public class Jugador {
    private String nombre;
    private Equipo equipo;

    public Jugador(String nombreJugador) {
        this.nombre = nombreJugador;

    }

       public void asignarEquipo(EquipoGuerrerosZ equipo) {
        this.equipo = equipo;
    }

}
