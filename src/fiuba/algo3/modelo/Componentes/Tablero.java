package fiuba.algo3.modelo.Componentes;

import java.util.*;
import java.util.Iterator;

import fiuba.algo3.modelo.excepciones.CeldaOcupadaException;

public class Tablero {

	private int dimension;
    private List<Celda> celdasOcupadas; 
	
    public Tablero (int unaDimension) {
        
    	this.dimension = unaDimension;
    	this.celdasOcupadas = new ArrayList<Celda>();	
    }
    
    
    private boolean celdaOcupada(Celda unaCelda){
    	Iterator<Celda> iterador =this.celdasOcupadas.iterator();
    	boolean encontrado = false;
    	Celda celda;
    	
    	while (iterador.hasNext() && !encontrado)
    	{
    		celda = iterador.next();
    		encontrado = ( (celda.getCoordenada().getCoordenadaX()) == (unaCelda.getCoordenada().getCoordenadaX())
    				&& (celda.getCoordenada().getCoordenadaY()) == (unaCelda.getCoordenada().getCoordenadaY()) );
    	}

    	return encontrado;
    }
    
    
    public void colocarCeldaEnTablero(Celda celda){
    	if (this.celdaOcupada(celda)){
    		throw new CeldaOcupadaException();
    	}
    	
    	this.celdasOcupadas.add(celda);
    }
    
}
