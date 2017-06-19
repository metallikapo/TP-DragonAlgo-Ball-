package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.EstadosGoku.*;

public class Goku extends Personaje implements PersonajeBueno{

    private Estado estado;

    public Goku(){
        vida = 500;
        ki = 0;
        vidaCritica = 150;
        estado = new EstadoNormal();

    }

    public void transformarse(){
        estado = estado.transformarse(this.ki);
        this.ki -= estado.costoDeTransformacion();
    }

    public void  ataqueBasico(Personaje enemigo){
        this.ki -= 10;
        this.atacar(enemigo, 20);
    }

    public void kamekameha(Personaje enemigo){
        this.ki -= 20;
        this.atacar(enemigo, 50)
    }

    @Override
    private void  atacar(PersonajeBueno amigo, int danio){
        throw new FuegoAmigoException();
    }

    @Override
    private void  atacar(PersonajeMalo enemigo, int danio) {
        enemigo.recibirDanio(danio)
    }
}