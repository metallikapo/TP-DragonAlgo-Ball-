package fiuba.algo3.modelo.EstadosFreezer;

import fiuba.algo3.modelo.Estados.Estado;

public class EstadoSegundaForma implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;

    public EstadoSegundaForma(){
        poderPelea = 40;
        distanciaAtaque = 3;
        velocidad = 4;
    }

    @Override
    public int getVelocidad(){
        return velocidad;
    }

}