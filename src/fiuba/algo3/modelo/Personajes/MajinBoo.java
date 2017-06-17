package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.EstadosMajinBoo.*;

public class MajinBoo extends Personaje {

    private Estado estado;

    public MajinBoo() {

        vida = 300;
        ki = 0;
<<<<<<< HEAD
=======
        
>>>>>>> 4f8935d11c62d77d3c6868ae79fef16cff484a94
        estado = new EstadoNormal();
    }

    /*
    @Override
    public void seMueveHaciaLaDerecha(int pasos){
        estado.puedeMoverse(pasos);
        celda.incrementarColumna(pasos);
        ki+=kiPorTurno;
    }

    public void transformarse(){
        estado = estado.transformarse(this.ki);
        this.ki -= estado.costoDeTransformacion();

    }
	*/
}