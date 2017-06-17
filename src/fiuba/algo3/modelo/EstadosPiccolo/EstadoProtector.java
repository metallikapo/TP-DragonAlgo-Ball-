package fiuba.algo3.modelo.EstadosPiccolo;

import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.excepciones.EstadoDeTransformacionMaxima;
import fiuba.algo3.modelo.excepciones.NoSePuedeTransformarPersonaje;
import fiuba.algo3.modelo.excepciones.NoSePuedeMoverPersonaje;

public class EstadoProtector implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;

    public EstadoProtector(){
        poderPelea = 60;
        distanciaAtaque = 6;
        velocidad = 4;
    }

    @Override
    public void puedeMoverse(int pasos){
        if(velocidad<pasos){
            throw new NoSePuedeMoverPersonaje();
        }
    }

    @Override
    public Estado transformarse(Gohan gohan,int Ki){

        throw new EstadoDeTransformacionMaxima();
    }

    @Override
    public int costoDeTransformacion(){
        return 0;
    }

    @Override
    public Estado transformarse(int ki){
        throw new NoSePuedeTransformarPersonaje();
    }
}