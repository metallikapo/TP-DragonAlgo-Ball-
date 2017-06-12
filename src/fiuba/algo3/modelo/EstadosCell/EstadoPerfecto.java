package fiuba.algo3.modelo.EstadosCell;

import fiuba.algo3.modelo.Estados.Estado;

public class EstadoPerfecto implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;

    public EstadoPerfecto(){
        poderPelea = 80;
        distanciaAtaque = 4;
        velocidad = 4;
    }

    @Override
    public int getVelocidad(){
        return velocidad;
    }

}