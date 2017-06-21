package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Personajes.PersonajeMalo;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.EstadosFreezer.*;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.modelo.excepciones.NoSePuedeAtacarPersonajePorNoPoseerKiSuficienteException;

public class Freezer extends Personaje implements PersonajeMalo{

    private Estado estado;
    private int kiNecesario;

    public Freezer() {

        vida = 400;
        ki = 0;
        kiNecesario = 20; //para realizar el ataque especial
        estado = new EstadoNormal();
    }


    public void transformarse() {
        estado = estado.transformarse(this.ki);
        this.ki -= estado.costoDeTransformacion();
    }

    @Override
    public void ataqueBasico(PersonajeMalo amigo) {
        throw new FuegoAmigoException();
    }

    @Override
    public void ataqueBasico(PersonajeBueno enemigo) {
        estado.ataqueBasico(enemigo,this);
    }

    public void rayoMortal(PersonajeBueno enemigo){
        if(this.ki < kiNecesario){
            throw new NoSePuedeAtacarPersonajePorNoPoseerKiSuficienteException();
        }
        this.ki -= kiNecesario;
        estado.ataqueEspecial(enemigo,this);
    }

    public void rayoMortal(PersonajeMalo amigo){
        throw new FuegoAmigoException();
    }

    @Override
    public void volverAlEstadoAnterior(Estado estado){

    }

    @Override
    public Coordenada moverArriba() {
        Coordenada unaCoordenada = this.estado.moverArriba(this.versorPersonaje);
        return unaCoordenada;
    }

    @Override
    public Coordenada moverAbajo(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        return unaCoordenada;
    }

    @Override
    public Coordenada moverAIzquierda(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        return unaCoordenada;
    }
    @Override
    public Coordenada moverADerecha(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        return unaCoordenada;
    }
    @Override
    public Coordenada moverASuperiorIzquierda(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        return unaCoordenada;
    }
    @Override
    public Coordenada moverASuperiorDerecha(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        return unaCoordenada;
    }
    @Override
    public Coordenada moverAInferiorIzquierda(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        return unaCoordenada;
    }
    @Override
    public Coordenada moverAIzquierdaDerecha(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        return unaCoordenada;
    }

}