package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.EstadosMajinBoo.*;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;

public class MajinBoo extends Personaje implements PersonajeMalo{

    private Estado estado;

    public MajinBoo() {

        vida = 300;
        ki = 0;
        estado = new EstadoNormal();
    }

    /*
    @Override
    public void seMueveHaciaLaDerecha(int pasos){
        estado.puedeMoverse(pasos);
        celda.incrementarColumna(pasos);
        ki+=kiPorTurno;
    }
*/
    public void transformarse(){
        estado = estado.transformarse(this.ki);
        this.ki -= estado.costoDeTransformacion();

    }

    public void convertirEnChocolate(PersonajeBueno enemigo) {
        enemigo.convertimeEnChocolate();
    }

    @Override
    public void ataqueBasico(PersonajeMalo amigo) {
        throw new FuegoAmigoException();
    }

    @Override
    public void ataqueBasico(PersonajeBueno unPersonaje) {

    }

    @Override
    public void ataqueEspecial(PersonajeMalo unPersonaje) {
        throw new FuegoAmigoException();
    }

    @Override
    public void ataqueEspecial(PersonajeBueno unPersonaje) {

    }

    @Override
    public Coordenada moverArriba() {
        Coordenada unaCoordenada = this.estado.moverArriba(this.versorPersonaje);
        return unaCoordenada;
    }
}