package fiuba.algo3.modelo.Personajes;

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
    public void recibirDanio(int danio){
        this.vida -= danio;
    }

    @Override
    public void ataqueBasico(PersonajeBueno enemigo){

        enemigo.recibirDanio(estado.getPoderPelea());
    }

    @Override
    public void ataqueBasico(PersonajeMalo companiero){
        throw new FuegoAmigoException();
    }

}