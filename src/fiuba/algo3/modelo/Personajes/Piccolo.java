package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Personajes.Celda;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Estados.*;

public class Piccolo extends Personaje {

    private EstadoGuerreroZ estado;

    public Piccolo(){

        vida = 500;
        ki = 0;
        estado = new EstadoNormal();
    }

    @Override
    public void seMueveHaciaLaDerecha(int pasos){
        if(estado.getVelocidad() >= pasos){
            celda.incrementarColumna(pasos);
        }
    }
}