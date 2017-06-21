package fiuba.algo3.modelo.EstadosCell;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.VersorDireccion;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.Personajes.Cell;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Personajes.PersonajeBueno;
import fiuba.algo3.modelo.Personajes.PersonajeMalo;
import fiuba.algo3.modelo.excepciones.NoSePuedeAbsorberPersonajeException;
import fiuba.algo3.modelo.excepciones.NoSePuedeMoverPersonaje;
import fiuba.algo3.modelo.excepciones.NoSePuedeTransformarPersonaje;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;


public class EstadoNormal implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;
    private int vidaAbsorbida;
    private int vidaAAbsorber;

    public EstadoNormal() {
        poderPelea = 20;
        distanciaAtaque = 3;
        velocidad = 2;
        vidaAbsorbida = 0;
        vidaAAbsorber = 4;
    }

    @Override
    public void sumarVidaAbsorbida(){
        vidaAbsorbida+=1;
    }

    @Override
    public void ataqueBasico(PersonajeBueno enemigo, Personaje personaje){

        enemigo.recibirDanio(poderPelea);
    }

    @Override
    public void puedeMoverse(int pasos) {
        if (velocidad < pasos) {
            throw new NoSePuedeMoverPersonaje();
        }
    }

    @Override
    public Estado transformarse(int vidaActual) {
        if (vidaAbsorbida < vidaAAbsorber) {
            throw new NoSePuedeTransformarPersonaje();
        }
        return new EstadoSemiPerfecto();
    }

    @Override
    public int costoDeTransformacion() {

        return 0;
    }

    @Override
    public Estado transformarse(Gohan gohan, int ki){

        throw new NoSePuedeTransformarPersonaje();
    }

    @Override
    public Estado transformarse(Personaje personaje1, Personaje personaje2, int ki){
        throw new NoSePuedeTransformarPersonaje();
    }
    
    @Override
    public int moverPorEstado(){
	return this.velocidad;	
    }

    @Override
    public void ataqueBasico(PersonajeMalo enemigo, Personaje personaje){

    }

    @Override
    public void aumentarVida(Personaje cell){
        cell.aumentarVida(poderPelea);
        this.sumarVidaAbsorbida();
    }

    @Override
    public void ataqueEspecial(PersonajeMalo amigo, Personaje personaje){
        throw new FuegoAmigoException();
    }

    @Override
    public void ataqueEspecial(PersonajeBueno enemigo, Personaje personaje) {

    }

    public Coordenada moverArriba(VersorDireccion unVersor) {

        int escalar = this.velocidad;
        Coordenada unaCoordenada = new Coordenada(0,0);
        for (int contador =0; contador < escalar; contador++){
            unaCoordenada = unVersor.moverArriba();
            unVersor = new VersorDireccion(unaCoordenada);
        }
        return unaCoordenada;

    }
}
