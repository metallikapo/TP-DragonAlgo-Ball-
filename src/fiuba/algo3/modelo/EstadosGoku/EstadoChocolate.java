package fiuba.algo3.modelo.EstadosGoku;

import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.excepciones.EsUnChocolateException;

/**
 * Created by nico-ubuntu on 19/06/17.
 */
public class EstadoChocolate implements Estado {
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
}
