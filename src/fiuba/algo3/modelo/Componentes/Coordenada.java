package fiuba.algo3.modelo.Componentes;

import fiuba.algo3.modelo.excepciones.NoSePuedeCalcularLaDistanciaException;

public class Coordenada {
	
	private int coordenadaX;
	private int coordenadaY;
	
	public Coordenada(int coordenadaX, int coordenadaY ){
		
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}
	
	public int getCoordenadaX(){
		return this.coordenadaX;
	}
	
	public int getCoordenadaY(){
		return this.coordenadaY;
	}
	
	public boolean esLaMismaCoordenada(Coordenada unaCoordenada){
		return ( this.getCoordenadaX() == unaCoordenada.getCoordenadaX()  &&
				this.getCoordenadaY() == unaCoordenada.getCoordenadaY() );
	}

	public boolean ubicacionDiagonal(Coordenada coordenada){
		return (Math.abs(coordenada.getCoordenadaY() - this.coordenadaY) ==
				Math.abs(coordenada.getCoordenadaX() - this.coordenadaX));
	}

	public int obtenerDistancia(Coordenada coordenada){
		int distancia;
		if (this.ubicacionDiagonal(coordenada) || (coordenada.getCoordenadaX() == this.coordenadaX)){
			distancia = Math.abs(coordenada.getCoordenadaY() - this.coordenadaY);
			//da igual la distancia columna o la distancia fila
		} else if (coordenada.getCoordenadaY() == this.getCoordenadaY()){
			distancia = Math.abs(coordenada.getCoordenadaX() - this.coordenadaX);

		} else {
			throw new NoSePuedeCalcularLaDistanciaException();
			// si no se puede calcular la distancia Tira una excepcion

		}

		return distancia;
	}
}
