public class Panenka {
    
    private static final Platno platno = Platno.getPlatno();
    
    private static int krok = 50;
    private static int vytvorenychInstanci = 0;
    
    private final int poradi = ++vytvorenychInstanci;
    private final String nazev = getClass().getName() + "_" + poradi;
    
    private Elipsa hlava;
    private Trojuhelnik telo;
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
        Panenka.krok = krok;
    }
    
    public static int getKrok() {
        return krok;
    }
    
    public static void zaramuj(int sirka, int vyska) {
        platno.setRozmer(sirka, vyska);
        new Panenka(0, 0, sirka, vyska);
    }
    
    public Panenka() {
        this(0, 0);
    }
    
    public Panenka(int x, int y) {
        this(x, y, 40, 80);
    }
    
    public Panenka(int x, int y, int sirka, int vyska) {
        this(x, y, sirka, vyska, Barva.RUZOVA);
    }
    
    public Panenka(int x, int y, int sirka, int vyska, Barva barva) {
        hlava = new Elipsa(0, 0, 0, 0);
        telo = new Trojuhelnik(0, 0, 0, 0, Smer8.SEVER);
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
        hlava.setPozice(x + 7 * sirka / 40, y);
        telo.setPozice(x, y + vyska / 4);
        levaNoha.setPozice(x + sirka / 5, y + 13 * vyska / 16);
        pravaNoha.setPozice(x + 13 * sirka / 20, y + 13 * vyska / 16);
        nakresli();
    }
    
    public void setRozmer(int sirka, int vyska) {
        this.sirka = sirka;
        this.vyska = vyska;
        hlava.setRozmer(13 * sirka / 20, 13 * vyska / 40);
        telo.setRozmer(sirka, (9 * vyska / 16) + 2);
        levaNoha.setRozmer(sirka / 5, 3 * vyska / 16);
        pravaNoha.setRozmer(sirka / 5, 3 * vyska / 16);
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
