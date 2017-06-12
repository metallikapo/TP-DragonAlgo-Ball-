package fiuba.algo3.modelo.EstadosFreezer;

import fiuba.algo3.modelo.Estados.Estado;

public class EstadoDefinitivo implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;

    public EstadoDefinitivo(){
        poderPelea = 50;
        distanciaAtaque = 3;
        velocidad = 6;

    }

    @Override
    public int getVelocidad(){
        return velocidad;
    }

}