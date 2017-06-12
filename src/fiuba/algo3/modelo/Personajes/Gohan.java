package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Juego.Tablero;
import fiuba.algo3.modelo.Juego.Celda;
import fiuba.algo3.modelo.Juego.Ubicacion;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Estados.*;

public class Gohan extends Personaje{

    private EstadoGuerreroZ estado;

    public Gohan(){
        vida = 300;
        ki = 0;
        estado = new EstadoNormal();
        estado.setPoderPelea(15);
    }

    public Gohan(Tablero tablero, int fil, int col) {
        super();
        tablero.colocarPersonaje(this, fil, col );
    }

    public Gohan(Tablero tablero, Ubicacion ubicacion) {
        super();
        tablero.colocarPersonaje(this, ubicacion);
    }

//    @Override
//    public void seMueveHaciaLaDerecha(int pasos){
//        if(estado.getVelocidad() >= pasos){
//            celda.incrementarColumna(pasos);
//        }
//    }


}