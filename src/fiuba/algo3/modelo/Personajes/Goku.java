package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Personajes.PersonajeMalo;
import fiuba.algo3.modelo.Personajes.PersonajeBueno;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.EstadosGoku.*;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;

public class Goku extends Personaje implements PersonajeBueno{

    private Estado estado;

    public Goku(){
        vida = 500;
        ki = 0;
        vidaCritica = 150;
        estado = new EstadoNormal();

    }

    public void transformarse(){
        estado = estado.transformarse(this.ki);
        this.ki -= estado.costoDeTransformacion();

    }

    @Override
    public void ataqueBasico(PersonajeMalo enemigo){
        if (this.estadoVidaCritica()) {
            enemigo.recibirDanio(estado.getPoderPelea()+ (estado.getPoderPelea()*20)/100);
        } else{
            enemigo.recibirDanio(estado.getPoderPelea());
        }
    }

    @Override
    public void ataqueBasico(PersonajeBueno amigo){
        throw new FuegoAmigoException();
    }

    @Override
    public void ataqueEspecial(PersonajeMalo enemigo){
        if (this.estadoVidaCritica()) {
            enemigo.recibirDanio((estado.getPoderPelea()*120)/100);

            //no puedo aplicarle el 50% mas de daño porque recibirDanio no soporta un double
            //enemigo.recibirDanio((estado.getPoderPelea()*1.5) + (estado.getPoderPelea()*20)/100);
        } else{
            enemigo.recibirDanio(estado.getPoderPelea());
        }
    }

    @Override
    public void ataqueEspecial(PersonajeBueno amigo){
        throw new FuegoAmigoException();
    }

    @Override
    public void convertimeEnChocolate() {
        this.estado = new EstadoChocolate();
    }


    @Override
    public Coordenada moverArriba() {
        Coordenada unaCoordenada = this.estado.moverArriba(this.versorPersonaje);
        return unaCoordenada;
    }
}