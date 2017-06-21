package fiuba.algo3.modelo.EstadosFreezer;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.VersorDireccion;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Personajes.PersonajeBueno;
import fiuba.algo3.modelo.Personajes.PersonajeMalo;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.modelo.excepciones.NoSePuedeTransformarPersonaje;
import fiuba.algo3.modelo.excepciones.NoSePuedeMoverPersonaje;

public class EstadoSegundaForma implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;
    private int kiNecesario;
    private int costo;

    public EstadoSegundaForma(){
        poderPelea = 40;
        distanciaAtaque = 3;
        velocidad = 4;
        kiNecesario = 50;
        costo = 20;
    }

    public void ataqueBasico(PersonajeBueno enemigo, Personaje personaje){
        enemigo.recibirDanio(poderPelea);
    }

    @Override
    public void ataqueEspecial(PersonajeBueno enemigo, Personaje personaje){
        enemigo.recibirDanio((poderPelea*150)/100);
    }

    @Override
    public void puedeMoverse(int pasos){
        if(velocidad<pasos){
            throw new NoSePuedeMoverPersonaje();
        }
    }

    @Override
    public Estado transformarse(int kiActual){
        if (kiNecesario > kiActual){
            throw new NoSePuedeTransformarPersonaje();
        }
        return new EstadoDefinitivo();
    }

    @Override
    public int costoDeTransformacion(){
        return costo;
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
    public void ataqueEspecial(PersonajeMalo amigo, Personaje personaje) {
        throw new FuegoAmigoException();
    }

    @Override
    public Coordenada moverArriba(VersorDireccion unVersor) {

        int escalar = this.velocidad;
        Coordenada unaCoordenada = new Coordenada(0,0);
        for (int contador =0; contador < escalar; contador++){
            unaCoordenada = unVersor.moverArriba();
            unVersor = new VersorDireccion(unaCoordenada);
        }
        return unaCoordenada;

    }

    @Override
    public Coordenada moverAbajo(VersorDireccion unVersor) {

        int escalar = this.velocidad;
        Coordenada unaCoordenada = new Coordenada(0,0);
        for (int contador =0; contador < escalar; contador++){
            unaCoordenada = unVersor.moverAbajo();
            unVersor = new VersorDireccion(unaCoordenada);
        }
        return unaCoordenada;

    }
}

