package fiuba.algo3.modelo.Estados;

import fiuba.algo3.modelo.Personajes.Gohan;

public interface Estado {

    public abstract void puedeMoverse(int pasos);

    public abstract Estado transformarse(int condicion);

    public abstract Estado transformarse(Gohan gohan, int kiActual);

    public abstract int costoDeTransformacion();

}