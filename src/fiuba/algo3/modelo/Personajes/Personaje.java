package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Componentes.Coordenada;

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

    /*public void incrementarKi(int turnos){
        for (int i=0; i<turnos;i++){
            ki += 5;
        }
    } */


    public boolean poseeKi(int ki){
        return (this.ki==ki);
    }

    public void mover(Coordenada coordenada){
    	this.coordenada = coordenada;
    }

}