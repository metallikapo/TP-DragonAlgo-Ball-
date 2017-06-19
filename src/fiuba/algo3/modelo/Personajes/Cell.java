package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.EstadosCell.*;

public class Cell extends Personaje {

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
/*
    public void  ataqueBasico(Personaje enemigo){
        this.ki -= 3;
        this.atacar(enemigo, 15);
    }

    public void absorber(Personaje enemigo){
        //falta validaciones
        this.ki -= 5;
        this.atacar(enemigo, 15);
        this.vida += 15;
    }

    @Override
    private void  atacar(PersonajeMalo amigo, int danio){
        throw new FuegoAmigoException();
    }

    @Override
    private void  atacar(PersonajeBueno enemigo, int danio){
        enemigo.recibirDanio(danio);
    }*/
}