package fiuba.algo3.modelo.EstadosMajinBoo;

import fiuba.algo3.modelo.Estados.Estado;

public class EstadoNormal implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;

    public EstadoNormal(){
        poderPelea = 30;
        distanciaAtaque = 2;
        velocidad = 2;
    }

    @Override
    public int getVelocidad(){
        return velocidad;
    }


}