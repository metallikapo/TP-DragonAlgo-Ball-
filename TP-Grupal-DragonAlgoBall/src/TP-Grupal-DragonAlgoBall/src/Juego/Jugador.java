import Equipos;

public class Jugador{
    private String nombre;
    private Equipo equipo;

    Jugador(String nombreJugador){
        nombre = nombreJugador;
    }

    public void asignarEquipo(Equipo equipoNuevo){
        equipo = equipoNuevo;
    }
}