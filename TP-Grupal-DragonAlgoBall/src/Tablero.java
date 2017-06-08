
public class Tablero {
	private int rango;
	private Casillero [][] matrizTablero;
	
	public Tablero(int unRango){
		this.rango = unRango; 
		this.matrizTablero = new Casillero[this.rango][this.rango];
	}
	
	public void ubicarPersonaje(Personaje unPersonaje, int fila, int columna){
		this.matrizTablero[fila][columna].colocarPersonaje(unPersonaje);
	}
	
	public boolean sePuedeMoverPersonaje(Personaje unPersonaje, int fila, int columna){
		return ( this.matrizTablero[fila][columna].contienePersonaje());
	}
	
	
	
	
	
	
	
	
}
