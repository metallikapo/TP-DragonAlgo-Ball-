package fiuba.algo3.modelo.Juego;

import fiuba.algo3.modelo.Componentes.Tablero;

import java.util.concurrent.ThreadLocalRandom;

public class Partida {
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorActual;

    public Partida(String nombreJugador1, String nombreJugador2){
        this.jugador1 = new Jugador(nombreJugador1);
        this.jugador2 = new Jugador(nombreJugador2);
        this.tablero = new Tablero(10); //por ahora hardcodeado
        primerTurnoAleatorio();
    }


    private void primerTurnoAleatorio() {
        this.jugadorActual = (ThreadLocalRandom.current().nextInt(0,2) == 1)? this.jugador2 : this.jugador1;
    }

    public void finTurno() {
        this.jugadorActual = (this.jugadorActual.equals(this.jugador1))? this.jugador2 : this.jugador1;
    }


}
