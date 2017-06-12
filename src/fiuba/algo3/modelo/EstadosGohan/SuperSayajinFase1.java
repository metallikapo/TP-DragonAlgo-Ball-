package fiuba.algo3.modelo.EstadosGohan;

import fiuba.algo3.modelo.Estados.Estado;

public class SuperSayajinFase1 implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;

    public SuperSayajinFase1(){
        poderPelea = 30;
        distanciaAtaque = 2;
        velocidad = 2;
    }

    @Override
    public int getVelocidad(){
        return velocidad;
    }

}