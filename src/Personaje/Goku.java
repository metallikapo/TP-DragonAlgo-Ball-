public class Goku{
    private String nombre;
    private int puntosDeVida;
    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;
    private int ki;


    private Celda posicionActual;

    private Celda posicion(){
        return posicionActual;
    }

    private void establecerPosicion(Celda nuevaPosicion){
        posicionActual = nuevaPosicion;
    }

    public boolean verificarPosicion(Casillero casilleroNuevo){
        return true;
    }

    public void seMueveHaciaLaDerecha(int pasos){
        Celda nuevaPosicion = new Celda;
        nuevaPosicion = this.posicion().columna + pasos;

        this.establecerPosicion(nuevaPosicion);
    }


}