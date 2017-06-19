package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Estados.Estado;

public interface PersonajeMalo {

    public abstract void atacar(PersonajeMalo unPersonaje);
    public abstract void atacar(PersonajeBueno unPersonaje);
    /*
    public abstract void ataqueBasico(PersonajeMalo unPersonaje);

    public abstract void ataqueBasico(PersonajeBueno unPersonaje);

    public abstract void ataqueEspecial(PersonajeMalo unPersonaje);

    public abstract void ataqueEspecial(PersonajeBueno unPersonaje);
    */

}