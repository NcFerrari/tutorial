package rozhrani;

public abstract class Zvire implements Comparable {

    private int vaha;

    public Zvire(int vaha) {
        this.vaha = vaha;
    }

    public int getVaha() {
        return vaha;
    }

    public void setVaha(int vaha) {
        this.vaha = vaha;
    }

    public void dychej() {
        System.out.println("Dýchám...");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    public abstract void presunSe();

    @Override
    public int compareTo(Object o) {
        Zvire jine = (Zvire) o;
        if (this.vaha < jine.vaha) {
            return -1;
        }
        if (this.vaha > jine.vaha) {
            return 1;
        }
        return getClass().getSimpleName().compareTo(o.getClass().getSimpleName());
    }

}
