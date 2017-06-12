package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Estados.*;
import fiuba.algo3.modelo.EstadosPiccolo.*;
import fiuba.algo3.modelo.excepciones.PiccoloNoPuedePasarEstadoProtector;
import fiuba.algo3.modelo.excepciones.NoSePuedeMoverPersonaje;

public class Piccolo extends Personaje {

    private Estado estado;
    private int kiNecesario;

    public Piccolo(){

        vida = 500;
        ki = 0;
        guerreroZ = true;
        kiNecesario = 20;
        estado = new EstadoNormal();
    }

    public void fortalecido(){
        if (ki>=kiNecesario){
            ki -= kiNecesario;
            estado = new EstadoFortalecido();
        }
    }

    public void protector(Gohan gohan){
        if (!gohan.estadoVidaCritica()){
            throw new PiccoloNoPuedePasarEstadoProtector();
        }
        estado = new EstadoProtector();
    }

    public int getKi(){
        return ki;
    }

    @Override
    public void seMueveHaciaLaDerecha(int pasos){
        if(estado.getVelocidad() < pasos){
            throw new NoSePuedeMoverPersonaje();
        }
        celda.incrementarColumna(pasos);
    }

    @Override
    public boolean esGuerreroZ(){
        return guerreroZ;
    }
}