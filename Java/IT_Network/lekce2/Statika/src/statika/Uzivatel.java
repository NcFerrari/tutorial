package statika;

public class Uzivatel {

    private static int minimalniDelkaHesla = 6;
    private static int dalsiId = 1;

    private String jmeno;
    private String heslo;
    private boolean prihlaseny;
    private final int id;

    public static boolean zvalidujHeslo(String heslo) {
        if (heslo.length() >= minimalniDelkaHesla) {
            return true;
        }
        return false;
    }

    public static int getMinimalniDelkaHesla() {
        return minimalniDelkaHesla;
    }

    public static void setMinimalniDelkaHesla(int minimalniDelkaHesla) {
        Uzivatel.minimalniDelkaHesla = minimalniDelkaHesla;
    }

    public Uzivatel(String jmeno, String heslo) {
        this.jmeno = jmeno;
        this.heslo = heslo;
        id = dalsiId++;
    }

    public boolean prihlasSe(String zadaneHeslo) {
        if (zadaneHeslo.equals(heslo)) {
            prihlaseny = true;
        }
        return prihlaseny;
    }

    public int getId() {
        return id;
    }

}
