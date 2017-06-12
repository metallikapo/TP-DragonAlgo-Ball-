package fiuba.algo3.modelo.EstadosPiccolo;

import fiuba.algo3.modelo.Estados.Estado;

public class EstadoProtector implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;
    private boolean guerreroZ;

    public EstadoProtector(){
        poderPelea = 60;
        distanciaAtaque = 6;
        velocidad = 4;
    }

    @Override
    public int getVelocidad(){
        return velocidad;
    }


}