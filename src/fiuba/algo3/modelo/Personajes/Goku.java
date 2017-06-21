package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Personajes.PersonajeMalo;
import fiuba.algo3.modelo.Personajes.PersonajeBueno;
import fiuba.algo3.modelo.Estados.*;
import fiuba.algo3.modelo.EstadosGoku.*;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.modelo.excepciones.NoSePuedeAtacarPersonajePorNoPoseerKiSuficienteException;

public class Goku extends Personaje implements PersonajeBueno{

    private Estado estado;
    private int kiNecesario;
    private int porcentaje;

    public Goku(){
        vida = 500;
        ki = 0;
        kiNecesario = 20; //para realizar el Kamehameha
        porcentaje = 50; //causa un 50% mas que el ataque basico
        vidaCritica = 150;
        estado = new EstadoNormal();

    }

    public void transformarse(){
        estado = estado.transformarse(this.ki);
        this.ki -= estado.costoDeTransformacion();

    }

    @Override
    public void ataqueBasico(PersonajeMalo enemigo){
        estado.ataqueBasico(enemigo,this);
    }

    @Override
    public void ataqueBasico(PersonajeBueno amigo){
        throw new FuegoAmigoException();
    }


    public void kamehameha(PersonajeMalo enemigo){
        if(ki<kiNecesario){
            throw new NoSePuedeAtacarPersonajePorNoPoseerKiSuficienteException();
        }
        estado.ataqueEspecial(enemigo,this);
        this.ki -= kiNecesario;
    }

    public void kamehameha(PersonajeBueno amigo){
        throw new FuegoAmigoException();
    }

    @Override
    public void convertimeEnChocolate() {
        this.estado = new EstadoChocolate(estado);
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