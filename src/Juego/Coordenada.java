
public class Coordenada {
	private int fila;
	private int columna;
	
	public Coordenada(int unaFila, int unaColumna){
		this.fila = unaFila;
		this.columna = unaColumna;
	}
	
	public int obtenerFila(){
		return this.fila;
	}
	
	public int obtenerColumna(){
		return this.columna;
	}
}
