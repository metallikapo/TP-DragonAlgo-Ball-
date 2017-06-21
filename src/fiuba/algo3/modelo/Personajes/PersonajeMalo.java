package fiuba.algo3.modelo.Personajes;

public interface PersonajeMalo {

    void ataqueBasico(PersonajeMalo unPersonaje);

    void ataqueBasico(PersonajeBueno unPersonaje);

    void recibirDanio(int cantidad);

}