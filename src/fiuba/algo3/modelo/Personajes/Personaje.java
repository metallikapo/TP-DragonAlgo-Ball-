package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.excepciones.PersonajeEstaMuerto;

public abstract class Personaje{

    protected int vida;
    protected int ki;
    protected int kiPorTurno = 5;
    protected Coordenada coordenada;
    protected int vidaCritica;

    public void naceEn(Coordenada coordenada){
        this.coordenada = coordenada;//se necesita el new??en constructor??
    }

    public boolean estaUbicadoEn(Coordenada coordenada){
        
    	return (this.coordenada.getCoordenadaX() == coordenada.getCoordenadaX()  &&
    			this.coordenada.getCoordenadaY() == coordenada.getCoordenadaY() );
    }

    public boolean poseeKi(int ki){
        return (this.ki==ki);
    }

    public boolean poseeVida(int vida){
        return (this.vida == vida);
    }

    public void mover(Coordenada coordenada){
        this.coordenada = coordenada;
        this.ki += this.kiPorTurno;
    }

    public boolean estadoVidaCritica(){
        return (vida <= vidaCritica);
    }

    public void recibirDanio(int ataque){
        if(vida<=0){
            throw new PersonajeEstaMuerto();
        }
        this.vida -= ataque;
    }

    public int getVida() {
        return this.vida;
    }

    public void aumentarVida(int cantidad){
        this.vida += cantidad;
    }

}