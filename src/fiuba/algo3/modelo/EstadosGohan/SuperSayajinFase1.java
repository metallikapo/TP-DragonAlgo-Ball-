package fiuba.algo3.modelo.EstadosGohan;

import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.EstadosGohan.SuperSayajinFase2;
import fiuba.algo3.modelo.excepciones.NoSePuedeTransformarPersonaje;
import fiuba.algo3.modelo.excepciones.NoSePuedeMoverPersonaje;
import fiuba.algo3.modelo.excepciones.EstadoDeTransformacionMaxima;

public class SuperSayajinFase1 implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;
    private int kiNecesario;
    private int costo;

    public SuperSayajinFase1(){
        poderPelea = 30;
        distanciaAtaque = 2;
        velocidad = 2;
        kiNecesario = 30;
        costo = 10;
    }

    @Override
    public void puedeMoverse(int pasos){
        if(velocidad<pasos){
            throw new NoSePuedeMoverPersonaje();
        }
    }

    /*
    vamos a necesitar otro metodo de estado tansformar que reciba a dos compañeros
     */
    @Override
    public Estado transformarse(Personaje personaje1, Personaje personaje2, int ki){

        if( (!personaje1.estadoVidaCritica() || !personaje2.estadoVidaCritica()) || kiNecesario>ki) {
            throw new NoSePuedeTransformarPersonaje();
        }
        return new SuperSayajinFase2();
    }

    @Override
    public Estado transformarse(int kiActual){
        throw new NoSePuedeTransformarPersonaje();
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