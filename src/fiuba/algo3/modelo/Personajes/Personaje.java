package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Celda;
<<<<<<< HEAD
import fiuba.algo3.modelo.Personajes.Gohan;
=======
import fiuba.algo3.modelo.Componentes.Coordenada;
>>>>>>> 4f8935d11c62d77d3c6868ae79fef16cff484a94

public abstract class Personaje{

    protected int vida;
    protected int ki;
<<<<<<< HEAD
    protected int kiPorTurno = 5;
=======
>>>>>>> 4f8935d11c62d77d3c6868ae79fef16cff484a94
    //protected int ataqueEspecial;
    protected Coordenada coordenada;

    public void naceEn(Coordenada coordenada){
        this.coordenada = coordenada;//se necesita el new??en constructor??
    }

    public boolean estaUbicadoEn(Coordenada coordenada){
        
    	return (this.coordenada.getCoordenadaX() == coordenada.getCoordenadaX()  &&
    			this.coordenada.getCoordenadaY() == coordenada.getCoordenadaY() );
    }

<<<<<<< HEAD
    public abstract void seMueveHaciaLaDerecha(int pasos);
=======
    /*public void incrementarKi(int turnos){
        for (int i=0; i<turnos;i++){
            ki += 5;
        }
    } */
>>>>>>> 4f8935d11c62d77d3c6868ae79fef16cff484a94

    public boolean poseeKi(int ki){
        return (this.ki==ki);
    }

<<<<<<< HEAD

=======
    public void mover(Coordenada coordenada){
    	this.coordenada = coordenada;
    }
    //public abstract void seMueveHaciaLaDerecha(int pasos);

    //public abstract boolean esGuerreroZ();
>>>>>>> 4f8935d11c62d77d3c6868ae79fef16cff484a94
/*
//No es mejor pedir posiciones u ubicacion??
    public abstract void seMueveHaciaLaIzquierda(int pasos);

    public abstract void seMueveHaciaArriba(int pasos);

    public abstract void seMueveHaciaAbajo(int pasos);

    public abstract void seMueveHaciaUnaDiagonal(int pasos);
*/
}