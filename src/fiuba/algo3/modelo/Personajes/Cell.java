package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.EstadosCell.*;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.modelo.excepciones.NoSePuedeAbsorberPersonajeException;

public class Cell extends Personaje implements PersonajeMalo{

    private Estado estado;
    private int kiNecesario;

    public Cell(){

        vida = 500;
        ki = 0;
        estado = new EstadoNormal();
        kiNecesario = 5;
    }

    public void transformarse(){
        estado = estado.transformarse(this.ki);
        estado = new EstadoNormal();
    }

    @Override
    public void  ataqueBasico(PersonajeBueno enemigo){
        estado.ataqueBasico(enemigo,this);
    }

    public void absorber(PersonajeBueno enemigo){
        if (kiNecesario>this.ki){
            throw new NoSePuedeAbsorberPersonajeException();
        }
        this.ki -= 5;
        estado.ataqueBasico(enemigo,this);
        estado.aumentarVida(this);

    }

    public void absorber(PersonajeMalo amigo){
        throw new FuegoAmigoException();
    }

    @Override
    public void volverAlEstadoAnterior(Estado estado){

    }

    @Override
    public void ataqueBasico(PersonajeMalo amigo){
        throw new FuegoAmigoException();
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
    public Coordenada moverDerecha(){
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