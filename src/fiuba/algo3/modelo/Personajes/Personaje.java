package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.excepciones.PersonajeEstaMuerto;

public abstract class Personaje{

    protected int vida;
    protected int ki;
    protected int kiPorTurno = 5;
    //protected int ataqueEspecial;
    protected Coordenada coordenada;

    public void naceEn(Coordenada coordenada){
        this.coordenada = coordenada;//se necesita el new??en constructor??
    }

    public boolean estaUbicadoEn(Coordenada coordenada){
        
    	return (this.coordenada.getCoordenadaX() == coordenada.getCoordenadaX()  &&
    			this.coordenada.getCoordenadaY() == coordenada.getCoordenadaY() );
    }

    //public abstract void seMueveHaciaLaDerecha(int pasos);

    public boolean poseeKi(int ki){
        return (this.ki==ki);
    }

    public void mover(Coordenada coordenada){
        this.coordenada = coordenada;
        this.ki += this.kiPorTurno;
    }

<<<<<<< HEAD
    
    //public abstract void mover(Coordenada coordenada);
   
    //public abstract void seMueveHaciaLaDerecha(int pasos);

    //public abstract boolean esGuerreroZ();
/*
//No es mejor pedir posiciones u ubicacion??
    public abstract void seMueveHaciaLaIzquierda(int pasos);

    public abstract void seMueveHaciaArriba(int pasos);

    public abstract void seMueveHaciaAbajo(int pasos);

    public abstract void seMueveHaciaUnaDiagonal(int pasos);
*/
=======
    public void recibirDanio(int ataque){
        if(vida<=0){
            throw new PersonajeEstaMuerto();
        }
        this.vida -= ataque;
    }

>>>>>>> 8a897eb4a8a4792b3bc759ffa7c9cea679cc4c18
}