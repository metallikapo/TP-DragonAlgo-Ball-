package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Juego.Celda;
import fiuba.algo3.modelo.Juego.Tablero;
import fiuba.algo3.modelo.Juego.Ubicacion;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Estados.*;

public class Goku extends Personaje {

    private EstadoGuerreroZ estado;

    public Goku(){
        vida = 500;
        ki = 0;
        estado = new EstadoNormal();
    }

    public Goku(Tablero tablero, Ubicacion ubicacion) {
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