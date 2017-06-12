package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.EstadosCell.*;

public class Cell extends Personaje{

    private EstadoNormal estado;

    public Cell(){

        vida = 500;
        ki = 0;
        guerreroZ = false;
        estado = new EstadoNormal();
    }

    @Override
    public void seMueveHaciaLaDerecha(int pasos){
        if((estado.getVelocidad()) >= pasos){
            celda.incrementarColumna(pasos);
        }
    }

    @Override
    public boolean esGuerreroZ(){
        return guerreroZ;
    }

}