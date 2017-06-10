

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
	
	
	// metodo horrible ! 
	private Coordenada obtenerCoordenadaDePersonaje(Personaje unPersonaje){
		boolean encontrado = false;
		int fila=0;
		int columna =0;
		while (!encontrado && fila < this.rango) {
			
			while (!encontrado && columna < this.rango){
				encontrado =(this.matrizTablero[fila][columna].obtenerPersonaje() 
								== unPersonaje);
				columna++;
			}
			fila++;
		}
		Coordenada coordenada = new Coordenada(fila--, columna--); 
		return coordenada;
	}
	
	private boolean movimientoPermitidoPorVelocidadDePersonaje(Personaje unPersonaje, int fila, int columna){
		Coordenada unaCoordenada;
		unaCoordenada = this.obtenerCoordenadaDePersonaje(unPersonaje);
		int rangoFila = unaCoordenada.obtenerFila() + unPersonaje.obtenerVelocidad();
		int rangoColumna= unaCoordenada.obtenerColumna() + unPersonaje.obtenerVelocidad();
		// solo estoy mirando las diagonales !!
		
		return ((fila <= rangoFila) && (columna <= rangoColumna) );
	}
	
	
	private boolean seEncuentraOtroPersonajeEnCaminoDe(Personaje unPersonaje){
		// solo estoy mirando las diagonales!!
		
		Coordenada unaCoordenada = this.obtenerCoordenadaDePersonaje(unPersonaje);
		return (
		this.matrizTablero[unaCoordenada.obtenerFila()+1][unaCoordenada.obtenerColumna()+1].contienePersonaje()
		&&
		this.matrizTablero[unaCoordenada.obtenerFila()+2][unaCoordenada.obtenerColumna()+2].contienePersonaje()
		);
	}
	
	public boolean sePuedeMoverPersonaje(Personaje unPersonaje, int fila, int columna){
		return (this.movimientoPermitidoPorVelocidadDePersonaje(unPersonaje, fila, columna)&&
				this.matrizTablero[fila][columna].contienePersonaje() &&
				this.seEncuentraOtroPersonajeEnCaminoDe(unPersonaje));
	}
	
	
	public boolean esGuerreroZ(int fila, int columna){
		Personaje unPersonaje;
		unPersonaje = this.matrizTablero[fila][columna].obtenerPersonaje();
		return (unPersonaje.esGuerreroZ);
	}
	
	public boolean esEnemigo(int fila, int columna){
		Personaje unPersonaje;
		unPersonaje = this.matrizTablero[fila][columna].obtenerPersonaje();
		return (unPersonaje.esEnemigo);
	}
	
	private int calcularNorma(Coordenada coordenada1, Coordenada coordenada2){
		int cuadrado1= (int) Math.pow(coordenada1.obtenerFila()- coordenada2.obtenerFila(), 2);
		int cuadrado2= (int) Math.pow(coordenada1.obtenerColumna()- coordenada2.obtenerColumna(), 2);
		int norma = (int) Math.sqrt(cuadrado1 + cuadrado2 );
		return norma;
	}
	
	public int calcularDistancia(Personaje unPersonaje, Personaje otroPersonaje){
		Coordenada  coordenada1;
		Coordenada  coordenada2;
		
		coordenada1 = this.obtenerCoordenadaDePersonaje(unPersonaje);
		coordenada2 = this.obtenerCoordenadaDePersonaje(otroPersonaje);
		
		return this.calcularNorma(coordenada1, coordenada2);
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
