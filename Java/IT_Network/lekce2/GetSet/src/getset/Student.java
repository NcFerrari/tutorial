package getset;

public class Student {

    private String jmeno;
    private boolean muz;
    private int vek;
    private boolean plnolety;

    public Student(String jmeno, boolean muz, int vek) {
        this.jmeno = jmeno;
        this.muz = muz;
        this.vek = vek;
        setVek(vek);
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public int getVek() {
        return vek;
    }

    public boolean isMuz() {
        return muz;
    }

    public void setVek(int vek) {
        this.vek = vek;
        plnolety = vek > 18;
    }

    public boolean isPlnolety() {
        return plnolety;
    }

    @Override
    public String toString() {
        String jsemPlnolety = plnolety ? "jsem" : "nejsem";
        String pohlavi = muz ? "muž" : "žena";
        String gramatickaPlnoletost = muz ? "plnoletý" : "plnoletá";

        return String.format("Jsem %s, %s. Je mi %d let a %s %s.", jmeno, pohlavi, vek, jsemPlnolety, gramatickaPlnoletost);
    }

    public static void main(String[] args) {
        System.out.println(new Student("Nataša", false, 25));
    }
}
