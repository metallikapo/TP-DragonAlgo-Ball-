public class Goku{
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