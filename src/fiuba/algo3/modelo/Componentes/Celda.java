package fiuba.algo3.modelo.Componentes;

import fiuba.algo3.modelo.Personajes.Personaje;

public class Celda{

	private Coordenada coordenada;
	private Personaje personaje;

    public Celda(Coordenada unaCoordenada){
        this.coordenada = unaCoordenada;
    }
    
    public Coordenada getCoordenada(){
    	return this.coordenada;
    }
    
    public void colocarPersonaje( Personaje personaje){
    	this.personaje = personaje;
    }

}