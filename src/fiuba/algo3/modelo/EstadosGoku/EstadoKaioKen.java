package fiuba.algo3.modelo.EstadosGoku;

import fiuba.algo3.modelo.Estados.Estado;

public class EstadoKaioKen implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;

    public EstadoKaioKen(){
        poderPelea = 40;
        distanciaAtaque = 4;
        velocidad = 3;
    }

    @Override
    public int getVelocidad(){
        return velocidad;
    }

}