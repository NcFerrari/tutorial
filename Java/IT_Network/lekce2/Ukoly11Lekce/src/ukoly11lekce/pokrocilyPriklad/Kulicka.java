package ukoly11lekce.pokrocilyPriklad;

public class Kulicka extends Tvar {

    private int smerX = 1;
    private int smerY = -1;

    public Kulicka(int x, int y, String symbol) {
        super(x, y, symbol);
    }

    public void setPozice(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getSmerX() {
        return smerX;
    }

    public void zmenSmerX() {
        smerX = -smerX;
    }

    public int getSmerY() {
        return smerY;
    }

    public void zmenSmerY() {
        smerY = -smerY;
    }

}
