package fiuba.algo3.modelo.Estados;

import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Personajes.Personaje;

public interface Estado {

    public abstract void puedeMoverse(int pasos);

    public abstract int getPoderPelea();

    public abstract Estado transformarse(int condicion);

    public abstract Estado transformarse(Gohan gohan, int kiActual);

    public abstract Estado transformarse(Personaje personaje1, Personaje personaje2, int ki);

    public abstract int costoDeTransformacion();

}