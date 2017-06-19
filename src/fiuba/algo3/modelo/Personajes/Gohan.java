package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.EstadosGohan.*;
import fiuba.algo3.modelo.excepciones.*;

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

    public void ataqueBasico(Personaje enemigo){
        this.ki -= 10;
        this.atacar(enemigo,20);
    }

    public void masenko(Personaje enemigo){
        this.ki -= 20;
        this.atacar(enemigo,40);
    }

    @Override
    private void  atacar(PersonajeBueno amigo, int danio){
        throw new FuegoAmigoException();
    }

    @Override
    private void  atacar(PersonajeMalo enemigo, int danio) {
        enemigo.recibirDanio(danio);
    }
}