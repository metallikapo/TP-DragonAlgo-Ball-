package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.EstadosCell.*;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;

public class Cell extends Personaje implements PersonajeMalo{

    private Estado estado;

    public Cell(){

        vida = 500;
        ki = 0;
        estado = new EstadoNormal();
    }

    public void transformarse(){
        estado = estado.transformarse(this.ki);
        estado = new EstadoNormal();
    }

    @Override
    public void  ataqueBasico(PersonajeBueno enemigo){
        enemigo.recibirDanio(estado.getPoderPelea());
    }


    public void absorber(PersonajeBueno enemigo){
        //falta validaciones
        this.ki -= 5;
        enemigo.recibirDanio(estado.getPoderPelea());
        this.vida += estado.getPoderPelea();
        estado.sumarVidaAbsorbida();
    }

/*
    public void absorber(Personaje enemigo){
        //falta validaciones
        this.ki -= 5;
        this.atacar(enemigo, 15);
        this.vida += 15;
    }
*/
    @Override
    public void ataqueBasico(PersonajeMalo amigo){
        throw new FuegoAmigoException();
    }

    /*
    @Override
    private void  atacar(PersonajeBueno enemigo, int danio){
        enemigo.recibirDanio(danio);
    }
*/
}