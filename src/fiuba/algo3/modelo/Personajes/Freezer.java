package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Personajes.PersonajeMalo;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.EstadosFreezer.*;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;

public class Freezer extends Personaje implements PersonajeMalo{

    private Estado estado;

    public Freezer() {

        vida = 400;
        ki = 0;
        estado = new EstadoNormal();
    }


    public void transformarse() {
        estado = estado.transformarse(this.ki);
        this.ki -= estado.costoDeTransformacion();
    }

    @Override
    public void ataqueEspecial(PersonajeMalo amigo) {
        throw new FuegoAmigoException();
    }

    @Override
    public void ataqueBasico(PersonajeMalo amigo) {
        throw new FuegoAmigoException();
    }

    @Override
    public void ataqueEspecial(PersonajeBueno enemigo) {
        //codigo minimo, esto debe hacerlo el estado
        enemigo.recibirDanio(50);
    }

    @Override
    public void ataqueBasico(PersonajeBueno enemigo) {
        //codigo minimo, esto debe hacerlo el estado
        enemigo.recibirDanio(30);
    }

    @Override
    public Coordenada moverArriba() {
        Coordenada unaCoordenada = this.estado.moverArriba(this.versorPersonaje);
        return unaCoordenada;
    }
}