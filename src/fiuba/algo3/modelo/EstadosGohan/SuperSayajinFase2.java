package fiuba.algo3.modelo.EstadosGohan;

import fiuba.algo3.modelo.Estados.Estado;

public class SuperSayajinFase2 implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;

    public SuperSayajinFase2(){
        poderPelea = 100;
        distanciaAtaque = 4;
        velocidad = 3;
    }

    @Override
    public int getVelocidad(){
        return velocidad;
    }

}