package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personajes.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EquipoTest {
    @Test
    public void crearEquipoGuerrerosZYVerificarPersonajes(){
        EquipoGuerrerosZ equipo = new EquipoGuerrerosZ();
        assertTrue(equipo.obtenerPersonaje(0) instanceof PersonajeBueno);
        //Cuando Gohan y Piccolo implementen la interfaz PersonajeBueno, descomentar
        //assertTrue(equipo.obtenerPersonaje(1) instanceof PersonajeBueno);
        //assertTrue(equipo.obtenerPersonaje(2) instanceof PersonajeBueno);
    }

    @Test
    public void crearEquipoEnemigosYVerificarPersonajes() {
        EquipoEnemigos equipo = new EquipoEnemigos();
        Personaje personaje = equipo.obtenerPersonaje(0);
        assertTrue(equipo.obtenerPersonaje(0) instanceof PersonajeMalo);
    }

}
