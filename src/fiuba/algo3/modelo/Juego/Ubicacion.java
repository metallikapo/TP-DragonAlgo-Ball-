package fiuba.algo3.modelo.Juego;

/**
 * Created by HP on 12/6/2017.
 */
public class Ubicacion {
    private int fila;
    private int columna;

    public Ubicacion(int fila, int columna){
        this.setCoordenada(fila, columna);
    }
    
    public void setCoordenada(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila(){ return this.fila; }
    public int getColumna(){return this.columna;}
}
