package fiuba.algo3.modelo.EstadosFreezer;

import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.excepciones.NoSePuedeTransformarPersonaje;
import fiuba.algo3.modelo.excepciones.EstadoDeTransformacionMaxima;
import fiuba.algo3.modelo.excepciones.NoSePuedeMoverPersonaje;

public class EstadoDefinitivo implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;
    private int costo;

    public EstadoDefinitivo(){
        poderPelea = 50;
        distanciaAtaque = 3;
        velocidad = 6;
        costo = 50;

    }

    @Override
    public int getPoderPelea(){
        return poderPelea;
    }

    @Override
    public void puedeMoverse(int pasos){
        if(velocidad<pasos){
            throw new NoSePuedeMoverPersonaje();
        }
    }

    @Override
    public Estado transformarse(int kiActual){
        throw new EstadoDeTransformacionMaxima();
    }

    @Override
    public int costoDeTransformacion(){
        return costo;
    }

    @Override
    public Estado transformarse(Gohan gohan, int ki){
        throw new NoSePuedeTransformarPersonaje();
    }

    @Override
    public Estado transformarse(Personaje personaje1, Personaje personaje2, int ki){
        throw new NoSePuedeTransformarPersonaje();
    }
}