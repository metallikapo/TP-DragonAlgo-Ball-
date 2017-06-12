package fiuba.algo3.modelo.EstadosMajinBoo;

import fiuba.algo3.modelo.Estados.Estado;

public class EstadoBooMalo implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;
    private boolean guerreroZ;

    public EstadoBooMalo(){
        poderPelea = 50;
        distanciaAtaque = 2;
        velocidad = 3;

    }

    @Override
    public int getVelocidad(){
        return velocidad;
    }

}