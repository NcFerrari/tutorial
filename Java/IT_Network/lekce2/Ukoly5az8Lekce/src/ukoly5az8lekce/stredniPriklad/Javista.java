package ukoly5az8lekce.stredniPriklad;

public class Javista extends Clovek {

    private String iDE;

    public Javista(String jmeno, int vek, String iDe) {
        super(jmeno, vek);
        this.iDE = iDE;
    }

    public void programuj(int pocetRadku) {
        int pocetUnavy = pocetRadku / 10;
        unava += pocetUnavy;
        if (unava >= 20) {
            System.out.println("Jsem příliš unavený, abych programoval");
            unava = 20;
        }
    }
}
