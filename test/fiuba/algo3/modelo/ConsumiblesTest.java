package fiuba.algo3.modelo;


import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.EsferaDelDragon;
import fiuba.algo3.modelo.Componentes.Semilla;
import fiuba.algo3.modelo.Personajes.Freezer;
import fiuba.algo3.modelo.Personajes.Gohan;
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


    @Test
    public void gokuObtieneUnConsumibleSemillaPeroTieneVidaLLenaYNoPasaNada(){
        Coordenada unaCoordenada = new Coordenada(2,0);
        Coordenada otraCoordenada = new Coordenada(0,0);
        Celda celdaConConsumible = new Celda(otraCoordenada);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        Semilla semilla = new Semilla();
        semilla.posicionarEn(otraCoordenada);

        celdaConConsumible.colocarConsumible(semilla);
        goku.mover(otraCoordenada);

        celdaConConsumible.colocarPersonaje(goku);

        assertEquals(500, goku.getVida());
    }

    @Test
    public void gohanObtieneUnaEsferaDelDragonSuAtaqueBasicoAumentaUn25porc(){
        Coordenada unaCoordenada = new Coordenada(2,0);
        Coordenada otraCoordenada = new Coordenada(0,0);
        Celda celdaConConsumible = new Celda(otraCoordenada);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        Freezer freezer = new Freezer();
        Coordenada otraCoordenada1 = new Coordenada(1,1);
        freezer.naceEn(otraCoordenada1);

        EsferaDelDragon esfera = new EsferaDelDragon();
        celdaConConsumible.colocarConsumible(esfera);

        gohan.mover(otraCoordenada);
        celdaConConsumible.colocarPersonaje(gohan);

        gohan.ataqueBasico(freezer);

        assertTrue(freezer.poseeVida(385));

    }

    @Test
    public void freezerObtieneUnaEsferaDelDragonSuAtaqueBasicoAumentaUn25porc(){
        Coordenada unaCoordenada = new Coordenada(2,0);
        Coordenada otraCoordenada = new Coordenada(0,0);
        Celda celdaConConsumible = new Celda(otraCoordenada);

        Gohan gohan = new Gohan();
        Coordenada otraCoordenada1 = new Coordenada(1,1);
        gohan.naceEn(otraCoordenada1);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        EsferaDelDragon esfera = new EsferaDelDragon();
        celdaConConsumible.colocarConsumible(esfera);

        freezer.mover(otraCoordenada);
        celdaConConsumible.colocarPersonaje(freezer);

        freezer.ataqueBasico(gohan);

        assertTrue(gohan.poseeVida(275));

    }


}