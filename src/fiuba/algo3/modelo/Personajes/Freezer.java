package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.EstadosFreezer.*;

public class Freezer extends Personaje {

    private Estado estado;

    public Freezer() {

        vida = 400;
        ki = 0;
        estado = new EstadoNormal();
    }

    public void transformarse() {
        estado = estado.transformarse(this.ki);
        this.ki -= estado.costoDeTransformacion();
    }

    /*
    @Override
    public void seMueveHaciaLaDerecha(int pasos) {
        if ((estado.getVelocidad()) >= pasos) {
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