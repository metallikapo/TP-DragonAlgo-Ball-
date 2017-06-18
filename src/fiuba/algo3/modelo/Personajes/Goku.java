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

}