package fiuba.algo3.modelo.EstadosCell;

import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.excepciones.NoSePuedeMoverPersonaje;
import fiuba.algo3.modelo.excepciones.NoSePuedeTransformarPersonaje;

public class EstadoSemiPerfecto implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;
    private int vidaAbsorbida;
    private int costo;

    public EstadoSemiPerfecto(){
        poderPelea = 40;
        distanciaAtaque = 4;
        velocidad = 3;
        vidaAbsorbida = 8;
        costo = 4;
    }

    @Override
    public void puedeMoverse(int pasos){
        if(velocidad<pasos){
            throw new NoSePuedeMoverPersonaje();
        }
    }

    @Override
    public Estado transformarse(int vidaActual){
        if (vidaAbsorbida > vidaActual){
            throw new NoSePuedeTransformarPersonaje();
        }
        return new EstadoPerfecto();
    }

    @Override
    public int costoDeTransformacion(){
        return costo;
    }

    @Override
    public Estado transformarse(Gohan gohan, int ki){
        throw new NoSePuedeTransformarPersonaje();
    }
}