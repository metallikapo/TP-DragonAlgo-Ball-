package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.EstadosGohan.EstadoNormal;
import fiuba.algo3.modelo.EstadosGohan.EstadoChocolate;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;

public class Gohan extends Personaje implements PersonajeBueno{

    private Estado estado;
    private int vidaCritica;

    public Gohan(){
        vida = 300;
        vidaCritica = 60;//20% de la vida inicial
        ki = 0;
        estado = new EstadoNormal();
    }

    public boolean estadoVidaCritica(){
        return (vida <= vidaCritica);
    }

    public void transformarse(Personaje personaje1, Personaje personaje2){
        estado = estado.transformarse(personaje1,personaje2,this.ki);
        this.ki -= estado.costoDeTransformacion();
    }

    @Override
    public void ataqueBasico(PersonajeMalo unPersonaje) {

    }

    @Override
    public void ataqueBasico(PersonajeBueno unPersonaje) {
        throw new FuegoAmigoException();
    }

    @Override
    public void ataqueEspecial(PersonajeMalo unPersonaje) {

    }

    @Override
    public void ataqueEspecial(PersonajeBueno unPersonaje) {
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