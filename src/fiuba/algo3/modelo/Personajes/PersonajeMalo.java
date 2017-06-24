package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Coordenada;

public interface PersonajeMalo {

    int calcularDistanciaDesde(Coordenada otraCoordenada);

    void ataqueBasico(PersonajeMalo unPersonaje);

    void ataqueBasico(PersonajeBueno unPersonaje);

    void recibirDanio(int cantidad);

}