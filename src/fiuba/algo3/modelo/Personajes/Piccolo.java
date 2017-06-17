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
        estado = new EstadoNormal();
    }

    public void transformarse(Gohan gohan){
        estado = estado.transformarse(gohan,this.ki);
        this.ki-= estado.costoDeTransformacion();
    }
    
    /*

    @Override
    public void seMueveHaciaLaDerecha(int pasos){
        estado.puedeMoverse(pasos);
        celda.incrementarColumna(pasos);
        ki+=kiPorTurno;
    }

<<<<<<< HEAD

=======
    @Override
    public boolean esGuerreroZ(){
        return guerreroZ;
    }
    
    */

}