package fiuba.algo3.modelo.Componentes;

import java.util.*;
import java.util.Iterator;

import fiuba.algo3.modelo.excepciones.CeldaNoOcupadaException;
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
    
}
