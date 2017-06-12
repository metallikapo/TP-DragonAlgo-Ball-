package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Juego.Celda;
import fiuba.algo3.modelo.Juego.Ubicacion;
import fiuba.algo3.modelo.Juego.Tablero;
import fiuba.algo3.modelo.Juego.Ubicacion;

public abstract class Personaje{

    protected int vida;
    protected int ki;
    //protected int ataqueEspecial;
    //protected Celda celda;
    protected Ubicacion ubicacion;

    /*public void naceEn(Celda celda){
        this.celda = celda;//se necesita el new??en constructor??
    }*/

    //public boolean estaUbicadoEn(Celda celda){
    //    return ((this.celda.getFila()==celda.getFila())
    //            && (this.celda.getColumna()==celda.getColumna()));
    //}


    //public abstract void seMueveHaciaLaDerecha(int pasos);

    public void actualizarUbicacion(int fil, int col) {
        ubicacion.setCoordenada(fil, col);
    }

    public Ubicacion obtenerUbicacionActual(){
        return this.ubicacion;
    }

    public void seMueveHacia(Tablero tablero, Ubicacion nuevaUbicacion){
        tablero.moverPersonaje(this, nuevaUbicacion);
    }

    public void actualizarUbicacion(Ubicacion nuevaUbicacion) {
        this.ubicacion = nuevaUbicacion;
    }
/*
//No es mejor pedir posiciones u ubicacion??
    public abstract void seMueveHaciaLaIzquierda(int pasos);

    public abstract void seMueveHaciaArriba(int pasos);

    public abstract void seMueveHaciaAbajo(int pasos);

    public abstract void seMueveHaciaUnaDiagonal(int pasos);
*/
}