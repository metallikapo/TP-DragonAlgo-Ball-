package fiuba.algo3.modelo.EstadosPiccolo;

import fiuba.algo3.modelo.Estados.*;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.excepciones.NoSePuedeTransformarPersonaje;
import fiuba.algo3.modelo.excepciones.NoSePuedeMoverPersonaje;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Personajes.PersonajeMalo;
import fiuba.algo3.modelo.Personajes.PersonajeBueno;

public class EstadoFortalecido implements Estado {
    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;
    private int costo;

    public EstadoFortalecido(){
        poderPelea = 40;
        distanciaAtaque = 4;
        velocidad = 3;
        costo=20;
    }

    @Override
    public void ataqueBasico(PersonajeMalo enemigo, Personaje piccolo){
        enemigo.recibirDanio(poderPelea);
    }

    @Override
    public void puedeMoverse(int pasos){
        if(velocidad<pasos){
            throw new NoSePuedeMoverPersonaje();
        }
    }

    @Override
    public Estado transformarse(Gohan gohan,int kiActual){
        if (!gohan.estadoVidaCritica()){
            throw new NoSePuedeTransformarPersonaje();
        }
        return new EstadoProtector();
    }

    @Override
    public int costoDeTransformacion(){
        return costo;
    }

    @Override
    public Estado transformarse(int ki){
        throw new NoSePuedeTransformarPersonaje();
    }

    @Override
    public Estado transformarse(Personaje personaje1, Personaje personaje2, int ki){
        throw new NoSePuedeTransformarPersonaje();
    }

    @Override
    public void sumarVidaAbsorbida(){

    }

    public int moverPorEstado(){
	return this.velocidad;	
    }

    @Override
    public void ataqueBasico(PersonajeBueno enemigo, Personaje personaje){

    }

    @Override
    public void aumentarVida(Personaje cell){

    }

    @Override
    public void ataqueEspecial(PersonajeBueno amigo, Personaje personaje){

    }

    @Override
    public void ataqueEspecial(PersonajeMalo enemigo, Personaje personaje){

    }
}

