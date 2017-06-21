package fiuba.algo3.modelo.EstadosPiccolo;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.VersorDireccion;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.excepciones.EsUnChocolateException;

/**
 * Created by nico-ubuntu on 19/06/17.
 */
public class EstadoChocolate implements Estado {

    private int turnosDuracion;

    public EstadoChocolate(){
        this.turnosDuracion = 3;
    }

    public Estado decrementarDuracion(){
        if (this.turnosDuracion > 0) {
            this.turnosDuracion -= 1;
            return this;
        }else{
            return new EstadoNormal();
        }
    }

    @Override
    public void puedeMoverse(int pasos) {
        throw new EsUnChocolateException();
    }

    @Override
    public void sumarVidaAbsorbida() {
        throw new EsUnChocolateException();
    }

    @Override
    public int getPoderPelea() {
        throw new EsUnChocolateException();
    }

    @Override
    public Estado transformarse(int condicion) {
        throw new EsUnChocolateException();
    }

    @Override
    public Estado transformarse(Gohan gohan, int kiActual) {
        throw new EsUnChocolateException();
    }

    @Override
    public Estado transformarse(Personaje personaje1, Personaje personaje2, int ki) {
        throw new EsUnChocolateException();
    }

    @Override
    public int costoDeTransformacion() {
        throw new EsUnChocolateException();
    }

    @Override
    public int moverPorEstado() {
        throw new EsUnChocolateException();
    }

    public Coordenada moverArriba(VersorDireccion unVersor) {throw new EsUnChocolateException();}

}
