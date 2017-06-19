package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.EstadosGohan.*;

public class Gohan extends Personaje{

    private Estado estado;
    private int vidaCritica;

    public Gohan(){
        vida = 300;
        vidaCritica = 60;//20% de la vida inicial
        ki = 0;
        estado = new EstadoNormal();
    }

    public boolean estadoVidaCritica(){
        return (vida <= vidaCritica);
    }

    public void transformarse(Personaje personaje1, Personaje personaje2){
        estado = estado.transformarse(personaje1,personaje2,this.ki);
        this.ki -= estado.costoDeTransformacion();
    }

    
}