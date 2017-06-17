package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.EstadosGoku.*;

public class Goku extends Personaje {

    private Estado estado;

    public Goku(){
        vida = 500;
        ki = 0;
        estado = new EstadoNormal();

    }

    public void transformarse(){
        estado.transformarse(this.ki);
        this.ki -= estado.costoDeTransformacion();
        estado = new EstadoNormal();

    }
    /*
    @Override
    public void seMueveHaciaLaDerecha(int pasos){
        if(estado.getVelocidad() >= pasos){
            celda.incrementarColumna(pasos);
        }
>>>>>>> 4f8935d11c62d77d3c6868ae79fef16cff484a94
    }

    @Override
    public void seMueveHaciaLaDerecha(int pasos){
        estado.puedeMoverse(pasos);
        celda.incrementarColumna(pasos);
        ki+=kiPorTurno;
    }
    
    */
}