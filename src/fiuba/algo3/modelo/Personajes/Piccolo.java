package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Estados.*;
import fiuba.algo3.modelo.EstadosPiccolo.*;

public class Piccolo extends Personaje  {

    private Estado estado;

    public Piccolo(){

        vida = 500;
        ki =0;
        vidaCritica = 150; //30% de la vida inicial
        estado = new EstadoNormal();
    }

    public void transformarse(Gohan gohan){
        estado = estado.transformarse(gohan,this.ki);
        this.ki-= estado.costoDeTransformacion();
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