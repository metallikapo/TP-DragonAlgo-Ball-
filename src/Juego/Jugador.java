import Equipos.EquipoZ
        Equipos.EquipoEnemigo;

public class Jugador{
    private String nombre;
    private EquipoZ equipo;

    Jugador(String nombreJugador){
        nombre = nombreJugador;
    }

    public void asignarEquipo(Equipo equipoNuevo){
        equipo = equipoNuevo;
    }
}