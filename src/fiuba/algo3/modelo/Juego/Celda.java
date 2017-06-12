package fiuba.algo3.modelo.Juego;

import fiuba.algo3.modelo.Excepciones.ErrorCeldaOcupada;
import fiuba.algo3.modelo.Personajes.Personaje;

public class Celda{

    private Ubicacion ubicacion;
    private Personaje personaje;

    public Celda(int fila, int columna){
        this.ubicacion = new Ubicacion(fila, columna );
        personaje = null;
    }

    public int getFila(){
        return ubicacion.getFila();
    }

    public int getColumna(){
        return ubicacion.getColumna();
    }

    public void incrementarColumna(int cantidad){
        this.ubicacion.setCoordenada(ubicacion.getFila(), ubicacion.getColumna() + cantidad);
    }

    public void colocarPersonaje(Personaje personaje) {
        if(this.personaje != null) throw new ErrorCeldaOcupada();
        this.personaje = personaje;
    }

    public void vaciar(){
        this.personaje = null;
    }

}