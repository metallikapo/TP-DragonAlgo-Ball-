package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.EstadosFreezer.*;

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

    public void  ataqueBasico(Personaje enemigo){
        //falta validaciones
        this.ki -= 10;
        this.atacar(enemigo, 20);
    }

    public void rayoMortal(Personaje enemigo){
        //falta validaciones
        this.ki -= 20;
        this.atacar(enemigo, 30);
    }

    @Override
    private void  atacar(PersonajeMalo amigo, int danio){
        throw new FuegoAmigoException();
    }

    @Override
    private void  atacar(PersonajeBueno enemigo, int danio){
        enemigo.recibirDanio(danio)
    }
}