package fiuba.algo3.modelo.EstadosGohan;

import fiuba.algo3.modelo.Estados.*;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.VersorDireccion;
import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.EstadosGohan.SuperSayajinFase1;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Personajes.PersonajeBueno;
import fiuba.algo3.modelo.Personajes.PersonajeMalo;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.excepciones.NoSePuedeTransformarPersonaje;
import fiuba.algo3.modelo.excepciones.NoSePuedeMoverPersonaje;

public class EstadoNormal implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;
    private int kiNecesario;

    public EstadoNormal(){
        poderPelea = 15;
        distanciaAtaque = 2;
        velocidad = 2;
        kiNecesario = 10;
    }

    @Override
    public boolean distanciaPermitida(int distancia){
        return (distanciaAtaque >= distancia);
    }

    @Override
    public boolean poseeMayorPoderPelea(int poderPelea){
        return (this.poderPelea > poderPelea);
    }

    @Override
    public void ataqueBasico(PersonajeMalo enemigo, Personaje personaje) {

        if(enemigo.poseeMayorPoderPelea(poderPelea)){
            enemigo.recibirDanio(poderPelea*80/100);
        }else{
            enemigo.recibirDanio(poderPelea);
        }
    }

    @Override
    public void puedeMoverse(int pasos){
        if(velocidad<pasos){
            throw new NoSePuedeMoverPersonaje();
        }
    }

    @Override
    public Estado transformarse(Personaje personaje1, Personaje personaje2, int ki){
        if(kiNecesario>ki){
            throw new NoSePuedeTransformarPersonaje();
        }
        return new SuperSayajinFase1();
    }

    @Override
    public Estado transformarse(int kiActual){
        throw new NoSePuedeTransformarPersonaje();
    }

    @Override
    public int costoDeTransformacion(){
        return 0;
    }

    @Override
    public Estado transformarse(Gohan gohan, int ki){
        throw new NoSePuedeTransformarPersonaje();
    }

    @Override
    public void sumarVidaAbsorbida(){

    }

    @Override
    public void ataqueBasico(PersonajeBueno enemigo, Personaje personaje){

    }

    public int moverPorEstado(){
	return this.velocidad;	
    }


    @Override
    public void aumentarVida(Personaje cell){

    }

    @Override
    public void ataqueEspecial(PersonajeBueno amigo, Personaje personaje){

    }

    @Override
    public void ataqueEspecial(PersonajeMalo enemigo, Personaje personaje) {

        if(enemigo.poseeMayorPoderPelea(poderPelea)){
            enemigo.recibirDanio(poderPelea*105/100);
        }else{
            enemigo.recibirDanio((poderPelea * 125) / 100);
        }
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

    @Override
    public Coordenada moverAIzquierda(VersorDireccion unVersor){
        int escalar = this.velocidad;
        Coordenada unaCoordenada = new Coordenada(0,0);
        for (int contador =0; contador < escalar; contador++){
            unaCoordenada = unVersor.moverAIzquierda();
            unVersor = new VersorDireccion(unaCoordenada);
        }
        return unaCoordenada;
    }

    @Override
    public Coordenada moverADerecha(VersorDireccion unVersor){
        int escalar = this.velocidad;
        Coordenada unaCoordenada = new Coordenada(0,0);
        for (int contador =0; contador < escalar; contador++){
            unaCoordenada = unVersor.moverADerecha();
            unVersor = new VersorDireccion(unaCoordenada);
        }
        return unaCoordenada;
    }

    @Override
    public Coordenada moverASuperiorDerecha(VersorDireccion unVersor){
        int escalar = this.velocidad;
        Coordenada unaCoordenada = new Coordenada(0,0);
        for (int contador =0; contador < escalar; contador++){
            unaCoordenada = unVersor.moverASuperiorDerecha();
            unVersor = new VersorDireccion(unaCoordenada);
        }
        return unaCoordenada;
    }

    @Override
    public Coordenada moverASuperiorIzquierda(VersorDireccion unVersor){
        int escalar = this.velocidad;
        Coordenada unaCoordenada = new Coordenada(0,0);
        for (int contador =0; contador < escalar; contador++){
            unaCoordenada = unVersor.moverASuperiorIzquierda();
            unVersor = new VersorDireccion(unaCoordenada);
        }
        return unaCoordenada;
    }

    @Override
    public Coordenada moverAInferiorDerecha(VersorDireccion unVersor){
        int escalar = this.velocidad;
        Coordenada unaCoordenada = new Coordenada(0,0);
        for (int contador =0; contador < escalar; contador++){
            unaCoordenada = unVersor.moverAInferiorDerecha();
            unVersor = new VersorDireccion(unaCoordenada);
        }
        return unaCoordenada;
    }

    @Override
    public Coordenada moverAInferiorIzquierda(VersorDireccion unVersor){
        int escalar = this.velocidad;
        Coordenada unaCoordenada = new Coordenada(0,0);
        for (int contador =0; contador < escalar; contador++){
            unaCoordenada = unVersor.moverAInferiorIzquierda();
            unVersor = new VersorDireccion(unaCoordenada);
        }
        return unaCoordenada;
    }

    @Override
    public int getPoderPelea() {
        return poderPelea;
    }

}

