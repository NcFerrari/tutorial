public class CinkaK {
    
    private static final Platno platno = Platno.getPlatno();
    
    private static int krok = 50;
    private static int vytvorenychInstanci = 0;
    
    private final int poradi = ++vytvorenychInstanci;
    private final String nazev = getClass().getName() + "_" + poradi;
    
    private Elipsa leveZavazi;
    private Obdelnik tycka;
    private Elipsa praveZavazi;
    private int x;
    private int y;
    private int sirka;
    private int vyska;
    
    public static void setKrok() {
        krok = P.zadej("Zadejte krok", krok);
    }
    
    public static void setKrok(int krok) {
        CinkaK.krok = krok;
    }
    
    public static int getKrok() {
        return krok;
    }
    
    public static void zaramuj(int sirka, int vyska) {
        platno.setRozmer(sirka, vyska);
        new CinkaK(0, 0, sirka, vyska);
    }
    
    public CinkaK() {
        this(0, 0);
    }
    
    public CinkaK(int x, int y) {
        this(x, y, 100, 30);
    }
    
    public CinkaK(int x, int y, int sirka, int vyska) {
        this(x, y, sirka, vyska, Barva.HNEDA);
    }
    
    public CinkaK(int x, int y, int sirka, int vyska, Barva barva) {
        leveZavazi = new Elipsa(0, 0, 0, 0);
        tycka = new Obdelnik(0, 0, 0, 0);
        praveZavazi = new Elipsa(0, 0, 0, 0);
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
        return leveZavazi.getBarva();
    }
    
    public String getNazev() {
        return nazev;
    }
    
    public void nakresli() {
        leveZavazi.nakresli();
        tycka.nakresli();
        praveZavazi.nakresli();
    }
    
    public void smaz() {
        leveZavazi.smaz();
        tycka.smaz();
        praveZavazi.smaz();
    }
    
    public void posunDolu(int vzdalenost) {
        leveZavazi.posunDolu(vzdalenost);
        tycka.posunDolu(vzdalenost);
        praveZavazi.posunDolu(vzdalenost);
        nakresli();
    }
    
    public void posunVpravo(int vzdalenost) {
        leveZavazi.posunVpravo(vzdalenost);
        tycka.posunVpravo(vzdalenost);
        praveZavazi.posunVpravo(vzdalenost);
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
        leveZavazi.setPozice(x, y);
        tycka.setPozice(x + 3 * sirka / 10, y + 2 * vyska / 5);
        praveZavazi.setPozice(x + 7 * sirka / 10, y);
        nakresli();
    }
    
    public void setRozmer(int sirka, int vyska) {
        this.sirka = sirka;
        this.vyska = vyska;
        leveZavazi.setRozmer(3 * sirka / 10, vyska);
        tycka.setRozmer((2 * sirka / 5) + 2, vyska / 5);
        praveZavazi.setRozmer(3 * sirka / 10, vyska);
        setPozice(getX(), getY());
    }
    
    public void setBarva(Barva barva) {
        leveZavazi.setBarva(barva);
        tycka.setBarva(barva);
        praveZavazi.setBarva(barva);
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
