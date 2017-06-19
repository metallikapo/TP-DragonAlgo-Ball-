package fiuba.algo3.modelo.EstadosGohan;

import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.excepciones.NoSePuedeTransformarPersonaje;
import fiuba.algo3.modelo.excepciones.EstadoDeTransformacionMaxima;
import fiuba.algo3.modelo.excepciones.NoSePuedeMoverPersonaje;

public class SuperSayajinFase2 implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;
    private int costo;

    public SuperSayajinFase2(){
        poderPelea = 100;
        distanciaAtaque = 4;
        velocidad = 3;
        costo = 30;
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
    /*
    vamos a necesitar otro metodo de estado tansformar que reciba a dos compañeros
    en este caso va a lanzar una excepcion
     */

    @Override
    public  Estado transformarse(Personaje personaje1, Personaje personaje2, int ki){
        throw new EstadoDeTransformacionMaxima();
    }

    @Override
    public Estado transformarse(int kiActual){
        //aca tambien tendría que lanzar una excepcion
        throw new NoSePuedeTransformarPersonaje();
    }

    @Override
    public int costoDeTransformacion(){
        return costo;
    }

    @Override
    public Estado transformarse(Gohan gohan, int ki){
        throw new EstadoDeTransformacionMaxima();
    }

}