package fiuba.algo3.modelo.EstadosGoku;

import fiuba.algo3.modelo.Estados.Estado;

public class EstadoSuperSayajin implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;

    public EstadoSuperSayajin(){
        poderPelea = 60;
        distanciaAtaque = 4;
        velocidad = 5;
    }

    @Override
    public int getVelocidad(){
        return velocidad;
    }

}