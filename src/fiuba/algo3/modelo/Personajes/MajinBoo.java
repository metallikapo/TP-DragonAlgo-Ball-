package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.EstadosMajinBoo.*;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;

public class MajinBoo extends Personaje implements PersonajeMalo{

    private Estado estado;

    public MajinBoo() {

        vida = 300;
        ki = 0;
        estado = new EstadoNormal();
    }

    /*
    @Override
    public void seMueveHaciaLaDerecha(int pasos){
        estado.puedeMoverse(pasos);
        celda.incrementarColumna(pasos);
        ki+=kiPorTurno;
    }
*/
    public void transformarse(){
        estado = estado.transformarse(this.ki);
        this.ki -= estado.costoDeTransformacion();
    }

    public void  ataqueBasico(Personaje enemigo){
        //faltan validaciones
        this.ki -= 10;
        this.atacar(enemigo, 15);
    }

    public void convertirEnChocolate(Personaje enemigo){
        //faltan validaciones
        this.ki -= 30;
        this.atacar(enemigo, 50);
    }

    @Override
    private void atacar(PersonajeMalo amigo, int danio){
        throw new FuegoAmigoException();
    }

    @Override
    private void atacar(PersonajeBueno enemigo, int danio){
        enemigo.recibirDanio(danio);
    }
}