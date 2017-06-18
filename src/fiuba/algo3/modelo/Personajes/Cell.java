package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.EstadosCell.*;

public class Cell extends Personaje{

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


}