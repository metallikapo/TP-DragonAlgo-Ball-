package fiuba.algo3.modelo.EstadosGoku;

import fiuba.algo3.modelo.Estados.*;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.excepciones.NoSePuedeTransformarPersonaje;
import fiuba.algo3.modelo.excepciones.NoSePuedeMoverPersonaje;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Personajes.PersonajeBueno;
import fiuba.algo3.modelo.Personajes.PersonajeMalo;

public class EstadoKaioKen implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;
    private int kiNecesario;
    private int costo;

    public EstadoKaioKen(){
        poderPelea = 40;
        distanciaAtaque = 4;
        velocidad = 3;
        kiNecesario = 50;
        costo = 20;
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
        return new EstadoSuperSayajin();
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

    public void ataqueBasico(PersonajeMalo enemigo, Personaje goku){
        if(goku.estadoVidaCritica()){
            enemigo.recibirDanio((poderPelea*20)/100);
        }
        enemigo.recibirDanio(poderPelea);
    }

    @Override
    public void ataqueBasico(PersonajeBueno enemigo, Personaje personaje){

    }

    @Override
    public void aumentarVida(Personaje cell){

    }

    @Override
    public void ataqueEspecial(PersonajeBueno amigo, Personaje Goku){

    }

    @Override
    public void ataqueEspecial(PersonajeMalo enemigo, Personaje goku){
        if(goku.estadoVidaCritica()){
            enemigo.recibirDanio((poderPelea*50)/100);
        }
        enemigo.recibirDanio(poderPelea);
    }

}

