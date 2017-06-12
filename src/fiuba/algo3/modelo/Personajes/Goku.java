package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.EstadosGoku.EstadoNormal;

public class Goku extends Personaje {

    private Estado estado;

    public Goku(){
        vida = 500;
        ki = 0;
        guerreroZ = true;
        estado = new EstadoNormal();

    }

    @Override
    public void seMueveHaciaLaDerecha(int pasos){
        if(estado.getVelocidad() >= pasos){
            celda.incrementarColumna(pasos);
        }
    }

    @Override
    public boolean esGuerreroZ(){
        return guerreroZ;
    }
}