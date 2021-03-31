package ukoly5az8lekce.stredniPriklad;

public class Clovek {

    /**
     * Celé jméno
     */
    private String jmeno;
    /**
     * Věk
     */
    private int vek;
    /**
     * Únava
     */
    protected int unava = 0;

    /**
     * Inicializuje novou instanci
     *
     * @param jmeno Celé jméno
     * @param vek Věk
     */
    public Clovek(String jmeno, int vek) {
        this.jmeno = jmeno;
        this.vek = vek;
    }

    /**
     * Spí danou dobu
     *
     * @param doba Doba v hodinách
     */
    public void spi(int doba) {
        unava -= doba * 10;
        if (unava < 0) {
            unava = 0;
        }
    }

    /**
     * Uběhne danou vzdálenost
     *
     * @param vzdalenost Vzdálenost v Km
     */
    public void behej(int vzdalenost) {
        if (unava + vzdalenost <= 20) {
            unava += vzdalenost;
        } else {
            System.out.println("Jsem příliš unavený");
        }
    }

    /**
     * Vrátí textovou reprezentaci člověka
     *
     * @return textová reprezentace člověka
     */
    @Override
    public String toString() {
        return String.format("%s (%d)", jmeno, vek);
    }
}
