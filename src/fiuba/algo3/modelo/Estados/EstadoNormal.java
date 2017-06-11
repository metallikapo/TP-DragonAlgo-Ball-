package fiuba.algo3.modelo.Estados;

import fiuba.algo3.modelo.Estados.EstadoGuerreroZ;

public class EstadoNormal implements EstadoGuerreroZ {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;

    public EstadoNormal(){
        poderPelea = 20;
        distanciaAtaque = 2;
        velocidad = 2;
    }

    @Override
    public int getVelocidad(){
        return velocidad;
    }

    @Override
    public void setPoderPelea(int poder){
        poderPelea = poder;
    }

}