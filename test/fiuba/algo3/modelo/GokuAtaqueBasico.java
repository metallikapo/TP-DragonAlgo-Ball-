package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personajes.Goku;
import fiuba.algo3.modelo.Personajes.Freezer;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Tablero;
import fiuba.algo3.modelo.excepciones.*;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class GokuAtaqueBasico {

    @Test
    public void test01SeUbicaAGokuYAFreezerSeAtacanConAtaqueBasico(){

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        Freezer freezer = new Freezer();
        freezer.naceEn(otraCoordenada);

        //goku ataca a freezer
        //freezer ataca a goku
        goku.ataqueBasico(freezer);
        freezer.ataqueBasico(goku);
        assertTrue(freezer.poseeVida(380));
        assertTrue(goku.poseeVida(480));

    }


/*
    @Test
    public void GokuEstadoNormalTieneMenosDel30%DeVidaSuDanioAumenta20%(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        Freezer freezer = new Freezer();
        freezer.naceEn(otraCoordenada1);

        goku.recibirDanio(350);
        goku.atacar(freezer);

        assertTrue(freezer.poseeVida(476));
    }

    @Test
    public void GokuEstadoKaioKenTieneMenosDel30%DeVidaSuDanioAumenta20%(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);
        Coordenada otraCoordenada2 = new Coordenada(1, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            goku.mover(otraCoordenada2);
        }

        goku.transformarse();

        Freezer freezer = new Freezer();
        freezer.naceEn(otraCoordenada2);

        goku.recibirDanio(350);
        goku.atacar(freezer);

        assertTrue(freezer.poseeVida(452));
    }

    @Test
    public void GokuEstadoSuperSayajinTieneMenosDel30%DeVidaSuDanioAumenta20%(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);
        Coordenada otraCoordenada2 = new Coordenada(1, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            goku.mover(otraCoordenada2);
        }

        goku.transformarse();

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            goku.mover(otraCoordenada2);
        }

        goku.transformarse();

        Freezer freezer = new Freezer();
        freezer.naceEn(otraCoordenada1);

        goku.recibirDanio(350);
        goku.atacar(freezer);

        assertTrue(freezer.poseeVida(428));
    }*/
}