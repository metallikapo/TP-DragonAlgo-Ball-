package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Estados.Estado;

public interface PersonajeBueno{

    void ataqueBasico(PersonajeMalo unPersonaje);

    void ataqueBasico(PersonajeBueno unPersonaje);

    void ataqueEspecial(PersonajeMalo unPersonaje);

    void ataqueEspecial(PersonajeBueno unPersonaje);

    void recibirDanio(int danio);

    void convertimeEnChocolate();
}