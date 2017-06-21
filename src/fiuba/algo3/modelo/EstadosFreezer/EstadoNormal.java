package fiuba.algo3.modelo.EstadosFreezer;

import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Personajes.PersonajeBueno;
import fiuba.algo3.modelo.Personajes.PersonajeMalo;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.modelo.excepciones.NoSePuedeTransformarPersonaje;
import fiuba.algo3.modelo.excepciones.NoSePuedeMoverPersonaje;

public class EstadoNormal implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;
    private int kiNecesario;

    public EstadoNormal() {
        poderPelea = 20;
        distanciaAtaque = 2;
        velocidad = 4;
        kiNecesario = 20;
    }

    @Override
    public void ataqueBasico(PersonajeBueno enemigo, Personaje personaje){
        enemigo.recibirDanio(poderPelea);
    }

    @Override
    public void ataqueEspecial(PersonajeBueno enemigo,Personaje personaje){
        enemigo.recibirDanio((poderPelea*150)/100);
    }

    @Override
    public void puedeMoverse(int pasos) {
        if (velocidad < pasos) {
            throw new NoSePuedeMoverPersonaje();
        }
    }

    @Override
    public Estado transformarse(int kiActual) {
        if (kiNecesario > kiActual) {
            throw new NoSePuedeTransformarPersonaje();
        }
        return new EstadoSegundaForma();
    }

    @Override
    public int costoDeTransformacion() {
        return 0;
    }

    @Override
    public Estado transformarse(Gohan gohan, int ki) {
        throw new NoSePuedeTransformarPersonaje();
    }

    @Override
    public Estado transformarse(Personaje personaje1, Personaje personaje2, int ki){
        throw new NoSePuedeTransformarPersonaje();
    }

    @Override
    public void sumarVidaAbsorbida(){

    }

    public int moverPorEstado(){
	return this.velocidad;	
    }

    @Override
    public void ataqueBasico(PersonajeMalo enemigo, Personaje personaje){

    }

    @Override
    public void aumentarVida(Personaje cell){

    }

    @Override
    public void ataqueEspecial(PersonajeMalo amigo, Personaje personaje){
        throw new FuegoAmigoException();
    }
}

