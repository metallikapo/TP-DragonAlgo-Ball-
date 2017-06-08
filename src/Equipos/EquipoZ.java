import Personaje;

public class EquipoZ{
    private Gohan gohan;
    private Goku goku;

    EquipoZ(){
        gohan = new Gohan();
        goku = new Goku();
    }

    public Gohan getGohan(){
        return gohan;
    }

    public Goku getGoku(){
        return goku;
    }
}