package fiuba.algo3.modelo.EstadosCell;

import fiuba.algo3.modelo.Estados.Estado;

public class EstadoSemiPerfecto implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;

    public EstadoSemiPerfecto(){
        poderPelea = 40;
        distanciaAtaque = 4;
        velocidad = 3;
    }

    @Override
    public int getVelocidad(){
        return velocidad;
    }

}