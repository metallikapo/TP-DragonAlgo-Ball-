package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personaje.Celda;

public class Gohan{

    private String nombre;
    private int puntosDeVida;
    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;
    private int ki;

    private Celda celda;

    public Gohan(){
        nombre = "Gohan";
        puntosDeVida = 300;
        poderPelea = 15;
        distanciaAtaque = 2;
        velocidad = 2;
        ki = 0;

    }

    public void naceEn(Celda celda){
        this.celda = celda;
    }

    public void seMueveHaciaLaDerecha(int pasos){
        if(velocidad >= pasos){
            celda.incrementarColumna(pasos);
        }
    }

    public boolean estaUbicadoEn(Celda celda){
        return ((this.celda.getFila()==celda.getFila())
        && (this.celda.getColumna()==celda.getColumna()));
    }


}