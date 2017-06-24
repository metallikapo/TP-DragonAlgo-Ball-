package fiuba.algo3.modelo;


import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Semilla;
import fiuba.algo3.modelo.Personajes.Goku;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class ConsumiblesTest {

    @Test
    public void gokuObtieneUnConsumibleSemilla(){
        Coordenada unaCoordenada = new Coordenada(2,0);
        Coordenada otraCoordenada = new Coordenada(0,0);
        Celda celdaConConsumible = new Celda(otraCoordenada);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        Semilla semilla = new Semilla();
        semilla.posicionarEn(otraCoordenada);

        goku.recibirDanio(150);

        celdaConConsumible.colocarConsumible(semilla);
        goku.mover(otraCoordenada);

        celdaConConsumible.colocarPersonaje(goku);

        assertEquals(450, goku.getVida());
        assertTrue(goku.poseeVida(450));
    }
}