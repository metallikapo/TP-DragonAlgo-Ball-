package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;

public abstract class Personaje{

    protected int vida;
    protected int ki;
    //protected int ataqueEspecial;
    protected Coordenada coordenada;

    public void naceEn(Coordenada coordenada){
        this.coordenada = coordenada;//se necesita el new??en constructor??
    }

    public boolean estaUbicadoEn(Coordenada coordenada){
        
    	return (this.coordenada.getCoordenadaX() == coordenada.getCoordenadaX()  &&
    			this.coordenada.getCoordenadaY() == coordenada.getCoordenadaY() );
    }

    /*public void incrementarKi(int turnos){
        for (int i=0; i<turnos;i++){
            ki += 5;
        }
    } */

    public void incrementarKi(){
        ki+=5;
    }

    public void mover(Coordenada coordenada){
    	this.coordenada = coordenada;
    }
    
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
}
