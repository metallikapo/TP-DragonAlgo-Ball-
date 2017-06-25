package fiuba.algo3.modelo.Componentes;

import fiuba.algo3.modelo.Estados.Estado;

public class Nada extends Consumible {

    @Override
    public int aumentarVida() {
        return 0;
    }

    @Override
    public Estado agregarEstado(Estado estado) {
        return null;
    }
}