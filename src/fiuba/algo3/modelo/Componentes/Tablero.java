package fiuba.algo3.modelo.Componentes;

import java.util.*;
import java.util.Iterator;

import fiuba.algo3.modelo.Personajes.Equipo;
import fiuba.algo3.modelo.Personajes.EquipoEnemigos;
import fiuba.algo3.modelo.Personajes.EquipoGuerrerosZ;
import fiuba.algo3.modelo.excepciones.CeldaNoOcupadaException;
import fiuba.algo3.modelo.excepciones.CeldaOcupadaException;

public class Tablero {

	private int dimension;
    private List<Celda> celdasOcupadas; 
	
    public Tablero (int unaDimension) {
        
    	this.dimension = unaDimension;
    	this.celdasOcupadas = new ArrayList<>();
    }
    
    
    private boolean celdaOcupada(Celda unaCelda){
    	Iterator<Celda> iterador =this.celdasOcupadas.iterator();
    	boolean encontrado = false;
    	Celda celda;
    	
    	while (iterador.hasNext() && !encontrado)
    	{
    		celda = iterador.next();
    		/*encontrado = ( (celda.getCoordenada().getCoordenadaX()) == (unaCelda.getCoordenada().getCoordenadaX())
    				&& (celda.getCoordenada().getCoordenadaY()) == (unaCelda.getCoordenada().getCoordenadaY()) );
    				*/
    		encontrado = celda.getCoordenada().esLaMismaCoordenada(unaCelda.getCoordenada());
    	}

    	return encontrado;
    }
    
    
    public void colocarCeldaEnTablero(Celda celda){
    	if (this.celdaOcupada(celda)){
    		throw new CeldaOcupadaException();
    	}
    	
    	this.celdasOcupadas.add(celda);
    }

    //Cuando una celda se libera, se debe sacar de la lista de celdas ocupadas
    public void liberarCeldaEnTablero(Coordenada coordenada){
		Iterator<Celda> iterador = this.celdasOcupadas.iterator();
		boolean encontrado = false;
		Celda celda;

		while (!encontrado && iterador.hasNext()){
			celda = iterador.next();
			encontrado = coordenada.esLaMismaCoordenada(celda.getCoordenada());
		}
		try {
			iterador.remove();
		} catch (Exception ex){
			throw new CeldaNoOcupadaException();
		}
	}

    public void ubicarEquipos(Equipo equipo1, Equipo equipo2) {
    	Coordenada esquinaSupIzq = new Coordenada(0,0);
    	Coordenada esquinaInfDer = new Coordenada(this.dimension - 1, this.dimension -1);

    	//ubicar equipo 1
    	Celda celda1 = new Celda(esquinaSupIzq);
    	celda1.colocarPersonaje(equipo1.obtenerPersonaje(0));
    	Celda celda2 = new Celda(new Coordenada(esquinaSupIzq.getCoordenadaX(),esquinaSupIzq.getCoordenadaY() + 1));
    	celda2.colocarPersonaje(equipo1.obtenerPersonaje(1));
    	Celda celda3 = new Celda(new Coordenada(esquinaSupIzq.getCoordenadaX() + 1,esquinaSupIzq.getCoordenadaY()));
    	celda3.colocarPersonaje(equipo1.obtenerPersonaje(2));
		this.colocarCeldaEnTablero(celda1);
		this.colocarCeldaEnTablero(celda2);
		this.colocarCeldaEnTablero(celda3);

    	//ubicar equipo 2
		Celda celda4 = new Celda(esquinaInfDer);
		celda1.colocarPersonaje(equipo2.obtenerPersonaje(0));
		Celda celda5 = new Celda(new Coordenada(esquinaInfDer.getCoordenadaX(),esquinaSupIzq.getCoordenadaY() - 1));
		celda2.colocarPersonaje(equipo2.obtenerPersonaje(1));
		Celda celda6 = new Celda(new Coordenada(esquinaSupIzq.getCoordenadaX() - 1,esquinaSupIzq.getCoordenadaY()));
		celda3.colocarPersonaje(equipo2.obtenerPersonaje(2));
		this.colocarCeldaEnTablero(celda4);
		this.colocarCeldaEnTablero(celda5);
		this.colocarCeldaEnTablero(celda6);

    }
}
