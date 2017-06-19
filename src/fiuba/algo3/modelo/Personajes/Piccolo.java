package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Estados.*;
import fiuba.algo3.modelo.EstadosPiccolo.*;

public class Piccolo extends Personaje {

    private Estado estado;

    public Piccolo(){

        vida = 500;
        ki =0;
        vidaCritica = 150; //30% de la vida inicial
        estado = new EstadoNormal();
    }

    public void transformarse(Gohan gohan){
        estado = estado.transformarse(gohan,this.ki);
        this.ki-= estado.costoDeTransformacion();
    }
/*
    public void ataqueBasico(Personaje enemigo){
        this.ki -= 5;
        this.atacar(enemigo, 10);
    }

    public void makankosappo(Personaje enemigo){
        this.ki -= 10;
        this.atacar(enemigo, 30);
    }

    @Override
    private void  atacar(PersonajeBueno amigo, int danio){
        throw new FuegoAmigoException();
    }

    @Override
    private void  atacar(PersonajeMalo enemigo, int danio) {
        enemigo.recibirDanio(danio);
    }
*/
}