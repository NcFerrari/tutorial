public class Panacek {
    
    private static final Platno platno = Platno.getPlatno();
    
    private static int krok = 50;
    private static int vytvorenychInstanci = 0;
    
    private final int poradi = ++vytvorenychInstanci;
    private final String nazev = getClass().getName() + "_" + poradi;
    
    private Elipsa hlava;
    private Obdelnik telo;
    private Obdelnik levaNoha;
    private Obdelnik pravaNoha;
    private int x;
    private int y;
    private int sirka;
    private int vyska;
    
    public static void setKrok() {
        krok = P.zadej("Zadejte krok", krok);
    }
    
    public static void setKrok(int krok) {
        Panacek.krok = krok;
    }
    
    public static int getKrok() {
        return krok;
    }
    
    public static void zaramuj(int sirka, int vyska) {
        platno.setRozmer(sirka, vyska);
        new Panacek(0, 0, sirka, vyska);
    }
    
    public Panacek() {
        this(0, 0);
    }
    
    public Panacek(int x, int y) {
        this(x, y, 30, 80);
    }
    
    public Panacek(int x, int y, int sirka, int vyska) {
        this(x, y, sirka, vyska, Barva.MODRA);
    }
    
    public Panacek(int x, int y, int sirka, int vyska, Barva barva) {
        hlava = new Elipsa(0, 0, 0, 0);
        telo = new Obdelnik(0, 0, 0, 0);
        levaNoha = new Obdelnik(0, 0, 0, 0);
        pravaNoha = new Obdelnik(0, 0, 0, 0);
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
        return hlava.getBarva();
    }
    
    public String getNazev() {
        return nazev;
    }
    
    public void nakresli() {
        hlava.nakresli();
        telo.nakresli();
        levaNoha.nakresli();
        pravaNoha.nakresli();
    }
    
    public void smaz() {
        hlava.smaz();
        telo.smaz();
        levaNoha.smaz();
        pravaNoha.smaz();
    }
    
    public void posunDolu(int vzdalenost) {
        hlava.posunDolu(vzdalenost);
        telo.posunDolu(vzdalenost);
        levaNoha.posunDolu(vzdalenost);
        pravaNoha.posunDolu(vzdalenost);
        nakresli();
    }
    
    public void posunVpravo(int vzdalenost) {
        hlava.posunVpravo(vzdalenost);
        telo.posunVpravo(vzdalenost);
        levaNoha.posunVpravo(vzdalenost);
        pravaNoha.posunVpravo(vzdalenost);
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
        hlava.setPozice(x + sirka / 6, y);
        telo.setPozice(x, y + vyska / 4);
        levaNoha.setPozice(x + sirka / 5, y + 3 * vyska / 4);
        pravaNoha.setPozice(x + 3 * sirka / 5, y + 3 * vyska / 4);
        nakresli();
    }
    
    public void setRozmer(int sirka, int vyska) {
        this.sirka = sirka;
        this.vyska = vyska;
        hlava.setRozmer(2 * sirka / 3, vyska / 4);
        telo.setRozmer(sirka, vyska / 2);
        levaNoha.setRozmer(sirka / 5, vyska / 4);
        pravaNoha.setRozmer(sirka / 5, vyska / 4);
        setPozice(getX(), getY());
    }
    
    public void setBarva(Barva barva) {
        hlava.setBarva(barva);
        telo.setBarva(barva);
        levaNoha.setBarva(barva);
        pravaNoha.setBarva(barva);
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
