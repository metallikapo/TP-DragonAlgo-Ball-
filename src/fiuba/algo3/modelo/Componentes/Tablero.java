package fiuba.algo3.modelo.Componentes;

import java.util.*;

public class Tablero {

	private int dimension;
    private List<Celda> celdasOcupadas; 
	
    public Tablero (int unaDimension) {
        
    	this.dimension = unaDimension;
    	this.celdasOcupadas = new ArrayList<Celda>();	
    }
    
    
    
}
