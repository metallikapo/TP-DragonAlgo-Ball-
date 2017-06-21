package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.EstadosMajinBoo.*;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.modelo.excepciones.NoSePuedeConvertirAlPersonajeEnEstadoChocolateException;

public class MajinBoo extends Personaje implements PersonajeMalo{

    private Estado estado;
    private int kiNecesario;

    public MajinBoo() {

        vida = 300;
        ki = 0;
        kiNecesario = 30; //para convertir en chocolate
        estado = new EstadoNormal();
    }

    public void transformarse(){
        estado = estado.transformarse(this.ki);
        this.ki -= estado.costoDeTransformacion();

    }

    public void convertirEnChocolate(PersonajeBueno enemigo) {
        if (this.ki<kiNecesario) {
            throw new NoSePuedeConvertirAlPersonajeEnEstadoChocolateException();
        }
        enemigo.convertimeEnChocolate();
    }

    public void convertirEnChocolate(PersonajeMalo amigo){
        throw new FuegoAmigoException();
    }

    @Override
    public void ataqueBasico(PersonajeMalo amigo) {
        throw new FuegoAmigoException();
    }

    @Override
    public void ataqueBasico(PersonajeBueno unPersonaje) {
        estado.ataqueBasico(unPersonaje,this);
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