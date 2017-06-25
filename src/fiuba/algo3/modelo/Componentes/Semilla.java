package fiuba.algo3.modelo.Componentes;

import fiuba.algo3.modelo.Estados.Estado;

public class Semilla extends Consumible {

    private int vida;

    public Semilla(){
        turnos = 0;
        vida = 100;
    }

    @Override
    public int aumentarVida(){
        return vida;
    }

    @Override
    public Estado agregarEstado(Estado estado) {
        return estado;
    }


}