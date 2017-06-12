package fiuba.algo3.modelo.EstadosMajinBoo;

import fiuba.algo3.modelo.Estados.Estado;

public class EstadoBooOriginal implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;

    public EstadoBooOriginal(){
        poderPelea = 60;
        distanciaAtaque = 3;
        velocidad = 4;
    }

    @Override
    public int getVelocidad(){
        return velocidad;
    }


}