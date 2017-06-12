package fiuba.algo3.modelo.EstadosPiccolo;

import fiuba.algo3.modelo.Estados.Estado;

public class EstadoFortalecido implements Estado {
    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;
    private boolean guerreroZ;

    public EstadoFortalecido(){
        poderPelea = 40;
        distanciaAtaque = 4;
        velocidad = 3;
    }

    @Override
    public int getVelocidad(){
        return velocidad;
    }

}