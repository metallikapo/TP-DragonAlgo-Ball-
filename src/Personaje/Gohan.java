public class Gohan{

    private String nombre;
    private int puntosDeVida;
    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;
    private int ki;

    Gohan(){
        nombre = "Gohan";
        puntosDeVida = 300;
        poderPelea = 15;
        distanciaAtaque = 2;
        velocidad = 2;
        ki = 0;

    }

    public void incrementarKi(int kiAumentado){
        ki = ki + kiAumentado;
    }



}