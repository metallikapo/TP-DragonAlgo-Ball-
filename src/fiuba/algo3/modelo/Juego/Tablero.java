package fiuba.algo3.modelo.Juego;

import fiuba.algo3.modelo.Personajes.Personaje;

/**
 * Created by Nico on 11/6/2017.
 */
public class Tablero {
    int dimension = 10;
    private Celda[][] celdas = new Celda[dimension][dimension];

    public Tablero() {
        super();
        inicializarTableroVacio();
    }

    public Tablero(int dimension) {
        this.dimension = dimension;
        inicializarTableroVacio();
    }

    private void inicializarTableroVacio() {
        //celdas = new Celda[dimension * dimension];
        for (int i = 0; i < dimension; i++)
            for (int j = 0; j < dimension; j++) this.celdas[i][j] = new Celda(i, j);
    }

    public Celda obtenerCelda(int fil, int col) {
        return celdas[fil][col];
    }

    public Celda obtenerCelda(Ubicacion ubicacion) {
        return celdas[ubicacion.getFila()][ubicacion.getColumna()];
    }

    public void colocarPersonaje(Personaje personaje, int fil, int col) {
        Celda celda = this.obtenerCelda(fil, col);
        celda.colocarPersonaje(personaje);
        personaje.actualizarUbicacion(fil, col);
    }

    public void colocarPersonaje(Personaje personaje, Ubicacion nuevaUbicacion) {
        Celda celda = this.obtenerCelda(nuevaUbicacion);
        celda.colocarPersonaje(personaje);
        personaje.actualizarUbicacion(nuevaUbicacion);
    }

    public void moverPersonaje(Personaje personaje, Ubicacion nuevaUbicacion) {
        Ubicacion ubicacionAnterior = personaje.obtenerUbicacionActual();
        colocarPersonaje(personaje, nuevaUbicacion);
        this.liberarCelda(ubicacionAnterior);
    }

    private void liberarCelda(Ubicacion ubicacionAnterior) {
        celdas[ubicacionAnterior.getFila()][ubicacionAnterior.getColumna()].vaciar();
    }
}
