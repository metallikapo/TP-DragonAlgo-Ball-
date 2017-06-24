package fiuba.algo3.modelo.Componentes;

public abstract class Consumible {

    protected int duracion;
    protected Coordenada coordenada;

    public abstract int aumentarVida();

    public void posicionarEn(Coordenada otraCoordenada){
        this.coordenada = otraCoordenada;
    }
}