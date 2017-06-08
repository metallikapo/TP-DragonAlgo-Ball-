
public class Casillero {
	
	private Personaje unPersonaje;
	//private Consumible unConsumible;
	
	public Casillero(){
		unPersonaje = null;
		//unConsumible = null;
	}
	
	public void colocarPersonaje(Personaje unPersonaje){
		this.unPersonaje = unPersonaje;
	}
	
	public boolean contienePersonaje(){
		return (this.unPersonaje != null );
	}
	
	public Personaje obtenerPersonaje(){
		return this.unPersonaje;
	}
	
	public void quitarPersonaje(){
		this.unPersonaje =null;
	}
	
	
	
	
	

}
