package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.EstadosGohan.EstadoNormal;


public class Gohan extends Personaje{

    private Estado estado;
    private int vidaCritica;

    public Gohan(){
        vida = 300;
        vidaCritica = 60;
        ki = 0;
        guerreroZ = true;
        estado = new EstadoNormal();
    }

    public boolean estadoVidaCritica(){
        return (vida <= vidaCritica);
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