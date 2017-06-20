package fiuba.algo3.modelo.EstadosGohan;

import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.EstadosGohan.SuperSayajinFase1;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.excepciones.NoSePuedeTransformarPersonaje;
import fiuba.algo3.modelo.excepciones.NoSePuedeMoverPersonaje;

public class EstadoNormal implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;
    private int kiNecesario;

    public EstadoNormal(){
        poderPelea = 15;
        distanciaAtaque = 2;
        velocidad = 2;
        kiNecesario = 10;
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
    en este caso no va a estar implementado
    if (kiNecesario > kiActual){
            throw new NoSePuedeTransformarPersonaje();
        }
        return new EstadoSuperSayajinFase1();
     */

    @Override
    public Estado transformarse(Personaje personaje1, Personaje personaje2, int ki){
        if(kiNecesario>ki){
            throw new NoSePuedeTransformarPersonaje();
        }
        return new SuperSayajinFase1();
    }

    @Override
    public Estado transformarse(int kiActual){
        throw new NoSePuedeTransformarPersonaje();
    }

    @Override
    public int costoDeTransformacion(){
        return 0;
    }

    @Override
    public Estado transformarse(Gohan gohan, int ki){
        throw new NoSePuedeTransformarPersonaje();
    }

    @Override
    public void sumarVidaAbsorbida(){

    }


    public int moverPorEstado(){
	return this.velocidad;	
    }
}

