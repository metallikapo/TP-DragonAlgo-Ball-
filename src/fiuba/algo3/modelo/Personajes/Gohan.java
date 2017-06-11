package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personajes.Celda;
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

    @Override
    public void seMueveHaciaLaDerecha(int pasos){
        if(estado.getVelocidad() >= pasos){
            celda.incrementarColumna(pasos);
        }
    }


}