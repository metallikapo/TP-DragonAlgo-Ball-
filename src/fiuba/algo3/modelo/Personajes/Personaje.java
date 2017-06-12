package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Celda;

public abstract class Personaje{

    protected int vida;
    protected int ki;
    protected boolean guerreroZ;
    //protected int ataqueEspecial;
    protected Celda celda;

    public void naceEn(Celda celda){
        this.celda = celda;//se necesita el new??en constructor??
    }

    public boolean estaUbicadoEn(Celda celda){
        return ((this.celda.getFila()==celda.getFila())
                && (this.celda.getColumna()==celda.getColumna()));
    }

    public void incrementarKi(int turnos){
        for (int i=0; i<turnos;i++){
            ki += 5;
        }
    }

    public void incrementarKi(){
        ki+=5;
    }

    public abstract void seMueveHaciaLaDerecha(int pasos);

    public abstract boolean esGuerreroZ();
/*
//No es mejor pedir posiciones u ubicacion??
    public abstract void seMueveHaciaLaIzquierda(int pasos);

    public abstract void seMueveHaciaArriba(int pasos);

    public abstract void seMueveHaciaAbajo(int pasos);

    public abstract void seMueveHaciaUnaDiagonal(int pasos);
*/
}