package fiuba.algo3.modelo.Personaje;

public class Celda{

    private int fila;
    private int columna;

    public Celda(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila(){
        return fila;
    }

    public int getColumna(){
        return columna;
    }

    public void incrementarColumna(int cantidad){
        this.columna += cantidad;
    }
}