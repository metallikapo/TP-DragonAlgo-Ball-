package fiuba.algo3.modelo.Personajes;

public interface PersonajeMalo {

    public abstract void ataqueBasico(PersonajeMalo unPersonaje);

    public abstract void ataqueBasico(PersonajeBueno unPersonaje);

    public abstract void recibirDanio(int danio);

}