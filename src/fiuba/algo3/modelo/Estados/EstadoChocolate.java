package fiuba.algo3.modelo.Estados;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.VersorDireccion;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Personajes.PersonajeBueno;
import fiuba.algo3.modelo.Personajes.PersonajeMalo;
import fiuba.algo3.modelo.excepciones.PersonajeEnEstadoChocolateExcepcion;

/**
 * Created by nico-ubuntu on 19/06/17.
 */
public class EstadoChocolate implements Estado {

    private int turnosDuracion;
    private Estado estado;

    public EstadoChocolate(Estado estadoActual){
        this.turnosDuracion = 3;
        estado = estadoActual;
    }

    public Estado decrementarDuracion(){
        if (this.turnosDuracion > 0) {
            this.turnosDuracion -= 1;
            return this;
        }else{
            return estado;
        }
    }

    @Override
    public void puedeMoverse(int pasos) {
        throw new PersonajeEnEstadoChocolateExcepcion();
    }

    @Override
    public void sumarVidaAbsorbida() {
        throw new PersonajeEnEstadoChocolateExcepcion();
    }

    @Override
    public Estado transformarse(int condicion) {
        throw new PersonajeEnEstadoChocolateExcepcion();
    }

    @Override
    public Estado transformarse(Gohan gohan, int kiActual) {
        throw new PersonajeEnEstadoChocolateExcepcion();
    }

    @Override
    public Estado transformarse(Personaje personaje1, Personaje personaje2, int ki) {
        throw new PersonajeEnEstadoChocolateExcepcion();
    }

    @Override
    public int costoDeTransformacion() {
        throw new PersonajeEnEstadoChocolateExcepcion();
    }

    @Override
    public int moverPorEstado() {
        throw new PersonajeEnEstadoChocolateExcepcion();
    }


    @Override
    public void ataqueBasico(PersonajeBueno enemigo, Personaje personaje){

    }

    @Override
    public void ataqueBasico(PersonajeMalo enemigo, Personaje personaje){

        //ver esto no va a funcionar
        if (this.turnosDuracion > 0) {
            this.turnosDuracion -= 1;
            throw new PersonajeEnEstadoChocolateExcepcion();
        }

    }

    @Override
    public void aumentarVida(Personaje cell){

    }

    @Override
    public void ataqueEspecial(PersonajeMalo enemigo,Personaje personaje){
    }

    @Override
    public void ataqueEspecial(PersonajeBueno enemigo,Personaje personaje){
    }

    @Override
    public Coordenada moverArriba(VersorDireccion unVersor) {  throw new PersonajeEnEstadoChocolateExcepcion();}
    @Override
    public Coordenada moverAbajo(VersorDireccion unVersor){  throw new PersonajeEnEstadoChocolateExcepcion();}

}
