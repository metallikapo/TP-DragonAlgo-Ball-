package fiuba.algo3.modelo.Componentes;

public class Semilla extends Consumible {

    private int vida;

    public Semilla(){
        duracion = 0;
        vida = 100;
    }

    @Override
    public int aumentarVida(){
        return vida;
    }


}