package fiuba.algo3.modelo.EstadosGohan;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.VersorDireccion;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Personajes.PersonajeBueno;
import fiuba.algo3.modelo.Personajes.PersonajeMalo;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.EstadosGohan.SuperSayajinFase2;
import fiuba.algo3.modelo.excepciones.NoSePuedeTransformarPersonaje;
import fiuba.algo3.modelo.excepciones.NoSePuedeMoverPersonaje;
import fiuba.algo3.modelo.excepciones.EstadoDeTransformacionMaxima;

public class SuperSayajinFase1 implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;
    private int kiNecesario;
    private int costo;

    public SuperSayajinFase1(){
        poderPelea = 30;
        distanciaAtaque = 2;
        velocidad = 2;
        kiNecesario = 30;
        costo = 10;
    }

    @Override
    public void ataqueBasico(PersonajeMalo enemigo, Personaje personaje){
        enemigo.recibirDanio(poderPelea);
    }

    @Override
    public void puedeMoverse(int pasos){
        if(velocidad<pasos){
            throw new NoSePuedeMoverPersonaje();
        }
    }

    /*
    vamos a necesitar otro metodo de estado tansformar que reciba a dos compañeros
     */
    @Override
    public Estado transformarse(Personaje personaje1, Personaje personaje2, int ki){

        if( (!personaje1.estadoVidaCritica() || !personaje2.estadoVidaCritica()) || kiNecesario>ki) {
            throw new NoSePuedeTransformarPersonaje();
        }
        return new SuperSayajinFase2();
    }

    @Override
    public Estado transformarse(int kiActual){
        throw new NoSePuedeTransformarPersonaje();
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
    public void sumarVidaAbsorbida(){

    }

    @Override
    public int moverPorEstado(){
	return this.velocidad;	
    }

    @Override
    public void ataqueBasico(PersonajeBueno enemigo, Personaje personaje){

    }

    @Override
    public void aumentarVida(Personaje cell){

    }

    @Override
    public void ataqueEspecial(PersonajeBueno amigo, Personaje personaje){

    }

    @Override
    public void ataqueEspecial(PersonajeMalo enemigo, Personaje personaje) {

        enemigo.recibirDanio((poderPelea * 125) / 100);
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

