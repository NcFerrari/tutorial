public class CinkaO {
    
    private static final Platno platno = Platno.getPlatno();
    
    private static int krok = 50;
    private static int vytvorenychInstanci = 0;
    
    private final int poradi = ++vytvorenychInstanci;
    private final String nazev = getClass().getName() + "_" + poradi;
    
    private Obdelnik leveZavazi;
    private Obdelnik tycka;
    private Obdelnik praveZavazi;
    private int x;
    private int y;
    private int sirka;
    private int vyska;
    
    public static void setKrok() {
        krok = P.zadej("Zadejte krok", krok);
    }
    
    public static void setKrok(int krok) {
        CinkaO.krok = krok;
    }
    
    public static int getKrok() {
        return krok;
    }
    
    public static void zaramuj(int sirka, int vyska) {
        platno.setRozmer(sirka, vyska);
        new CinkaO(0, 0, sirka, vyska);
    }
    
    public CinkaO() {
        this(0, 0);
    }
    
    public CinkaO(int x, int y) {
        this(x, y, 100, 30); 
    }

    public CinkaO(int x, int y, int sirka, int vyska) {
        this(x, y, sirka, vyska, Barva.CERNA);
    }
    
    public CinkaO(int x, int y, int sirka, int vyska, Barva barva) {
        leveZavazi = new Obdelnik(0, 0, 0, 0);
        tycka = new Obdelnik(0, 0, 0, 0);
        praveZavazi = new Obdelnik(0, 0, 0, 0);
        setPozice(x, y);
        setRozmer(sirka, vyska);
        setBarva(barva);
    }
    
    public CinkaO(Pozice pozice) {
        this(pozice.getX(), pozice.getY());
    }
    
    public CinkaO(Rozmer rozmer) {
        this(0, 0, rozmer.getSirka(), rozmer.getVyska());
    }
    
    public CinkaO(Pozice pozice, Rozmer rozmer) {
        this(new Oblast(pozice, rozmer));
    }
    
    public CinkaO(Oblast oblast) {
        this(oblast.getX(), oblast.getY(), oblast.getSirka(), oblast.getVyska());
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
    
    public void setOblast(Oblast oblast) {
        setPozice(oblast.getPozice());
        setRozmer(oblast.getRozmer());
    }
    
    public Oblast getOblast() {
        return new Oblast(getPozice(), getRozmer());
    }
    
    public void setPozice(Pozice pozice) {
        setPozice(pozice.getX(), pozice.getY());
    }
    
    public Pozice getPozice() {
        return new Pozice(getX(), getY());
    }
    
    public void setRozmer(Rozmer rozmer) {
        setRozmer(rozmer.getSirka(), rozmer.getVyska());
    }
    
    public Rozmer getRozmer() {
        return new Rozmer(getSirka(), getVyska());
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
        tycka.setPozice(x + 3 * sirka / 20, y + 2 * vyska / 5);
        praveZavazi.setPozice(x + 17 * sirka / 20, y);
        nakresli();
    }
    
    public void setRozmer(int sirka, int vyska) {
        this.sirka = sirka;
        this.vyska = vyska;
        leveZavazi.setRozmer(3 * sirka / 20, vyska);
        tycka.setRozmer((7 * sirka / 10) + 2, vyska / 5);
        praveZavazi.setRozmer(3 * sirka / 20, vyska);
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
