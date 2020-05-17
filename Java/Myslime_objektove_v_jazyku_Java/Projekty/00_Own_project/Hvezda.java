public class Hvezda {
    
    private static final Platno platno = Platno.getPlatno();
    
    private static int krok = 50;
    private static int vytvorenychInstanci = 0;
    
    private final int poradi = ++vytvorenychInstanci;
    private final String nazev = getClass().getName() + "_" + poradi;
    
    private Trojuhelnik severniTrojuhelnik;
    private Trojuhelnik jizniTrojuhelnik;
    private int x;
    private int y;
    private int sirka;
    private int vyska;
    
    public static void setKrok() {
        krok = P.zadej("Zadejte krok", krok);
    }
    
    public static void setKrok(int krok) {
        Hvezda.krok = krok;
    }
    
    public static int getKrok() {
        return krok;
    }
    
    public static void zaramuj(int sirka, int vyska) {
        platno.setRozmer(sirka, vyska);
        new Hvezda(0, 0, sirka, vyska);
    }
    
    public Hvezda() {
        this(0, 0);
    }
    
    public Hvezda(int x, int y) {
        this(x, y, 60, 80);
    }
    
    public Hvezda(int x, int y, int sirka, int vyska) {
        this(x, y, sirka, vyska, Barva.ZLATA);
    }
    
    public Hvezda(int x, int y, int sirka, int vyska, Barva barva) {
        severniTrojuhelnik = new Trojuhelnik(0, 0, 0, 0, Smer8.SEVER);
        jizniTrojuhelnik = new Trojuhelnik(0, 0, 0, 0, Smer8.JIH);
        setPozice(x, y);
        setRozmer(sirka, vyska);
        setBarva(barva);
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getSirka() {
        return sirka;
    }
    
    public int getVyska() {
        return vyska;
    }
    
    public Barva getBarva() {
        return severniTrojuhelnik.getBarva();
    }
    
    public String getNazev() {
        return nazev;
    }
    
    public void nakresli() {
        severniTrojuhelnik.nakresli();
        jizniTrojuhelnik.nakresli();
    }
    
    public void smaz() {
        severniTrojuhelnik.smaz();
        jizniTrojuhelnik.smaz();
    }
    
    public void posunDolu(int vzdalenost) {
        severniTrojuhelnik.posunDolu(vzdalenost);
        jizniTrojuhelnik.posunDolu(vzdalenost);
        nakresli();
    }
    
    public void posunVpravo(int vzdalenost) {
        severniTrojuhelnik.posunVpravo(vzdalenost);
        jizniTrojuhelnik.posunVpravo(vzdalenost);
        nakresli();
    }
    
    public void posunDolu() {
        posunDolu(krok);
    }
    
    public void posunVpravo() {
        posunVpravo(krok);
    }
    
    public void posunVzhuru() {
        posunDolu(-krok);
    }
    
    public void posunVlevo() {
        posunVpravo(-krok);
    }
    
    public void setPozice(int x, int y) {
        this.x = x;
        this.y = y;
        severniTrojuhelnik.setPozice(x, y);
        jizniTrojuhelnik.setPozice(x, y + vyska / 4);
        nakresli();
    }
    
    public void setRozmer(int sirka, int vyska) {
        this.sirka = sirka;
        this.vyska = vyska;
        severniTrojuhelnik.setRozmer(sirka, 3 * vyska / 4);
        jizniTrojuhelnik.setRozmer(sirka, 3 * vyska / 4);
        setPozice(getX(), getY());
    }
    
    public void setBarva(Barva barva) {
        severniTrojuhelnik.setBarva(barva);
        jizniTrojuhelnik.setBarva(barva);
        nakresli();
    }
    
    public void zaramuj() {
        platno.setRozmer(getSirka(), getVyska());
        setPozice(0, 0);
    }
    
    @Override
    public String toString() {
        return String.format("%s: x=%d, y=%d, šíøka=%d, výška=%d",
                            getNazev(), getX(), getY(), getSirka(), getVyska());
    }
}
