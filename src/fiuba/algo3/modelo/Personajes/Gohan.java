package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.EstadosGohan.*;
import fiuba.algo3.modelo.Estados.*;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Personajes.PersonajeBueno;
import fiuba.algo3.modelo.Personajes.PersonajeMalo;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.modelo.excepciones.NoSePuedeAtacarPersonajePorNoPoseerKiSuficienteException;

public class Gohan extends Personaje implements PersonajeBueno{

    private Estado estado;
    private int vidaCritica;
    private int kiNecesario;

    public Gohan(){
        vida = 300;
        vidaCritica = 60;//20% de la vida inicial
        ki = 0;
        kiNecesario = 10;//para poder realizar el ataque especial
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
        estado.ataqueBasico(unPersonaje,this);
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
        this.estado = new EstadoChocolate(estado);
    }

    public void masenko(PersonajeMalo enemigo){
        if(ki < kiNecesario){
            throw new NoSePuedeAtacarPersonajePorNoPoseerKiSuficienteException();
        }
        this.ki -= kiNecesario;
        estado.ataqueEspecial(enemigo,this);
    }
}