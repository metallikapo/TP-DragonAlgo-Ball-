package fiuba.algo3.modelo.Juego;

import java.util.concurrent.ThreadLocalRandom;

public class Partida {
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorActual;

    public Partida(String nombreJugador1, String nombreJugador2){
        this.jugador1 = new Jugador(nombreJugador1);
        this.jugador2 = new Jugador(nombreJugador2);
        primerTurnoAleatorio();
    }


    private void primerTurnoAleatorio() {
        this.jugadorActual = (ThreadLocalRandom.current().nextInt(0,2) == 1)? this.jugador2 : this.jugador1;
    }

    public void finTurno() {
        this.jugadorActual = (this.jugadorActual.equals(this.jugador1))? this.jugador2 : this.jugador1;
    }
}
