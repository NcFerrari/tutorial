public class Strom {
    
    private static final Platno platno = Platno.getPlatno();
    private static final Barva IMPLICITNI_BARVA_KORUNY = Barva.ZELENA;
    private static final Barva IMPLICITNI_BARVA_KMENE = Barva.HNEDA;
    private static final int IMPLICITNI_PODIL_SIRKY_KMENE = 10;
    private static final int IMPLICITNI_PODIL_VYSKY_KMENE = 3;
    
    private static int krok = 50;
    
    private Elipsa koruna;
    private Obdelnik kmen;
    private int x;
    private int y;
    private int sirka;
    private int vyska;
    private int podilSirkyKmene = IMPLICITNI_PODIL_SIRKY_KMENE;
    private int podilVyskyKmene = IMPLICITNI_PODIL_VYSKY_KMENE;
    
    public static void setKrok() {
        krok = P.zadej("Zadejte krok", krok);
    }
    
    public static void setKrok(int krok) {
        Strom.krok = krok;
    }
    
    public static int getKrok() {
        return krok;
    }
    
    public static void zaramuj(int sirka, int vyska) {
        platno.setRozmer(sirka, vyska);
        new Strom(0, 0, sirka, vyska);
    }
    
    public static void alej() {
        platno.setRozmer(380, 450);
        new Strom(0, 0, 100, 150);
        new Strom(70, 150, 100, 150);
        new Strom(140, 300, 100, 150);
        new Strom(140, 0, 100, 150);
        new Strom(210, 150, 100, 150);
        new Strom(280, 300, 100, 150);
    }
    
    public Strom() {
        this(0, 0);
    }
    
    public Strom(int x, int y) {
        this(x, y, 100, 150);
    }
    
    public Strom(int x, int y, int sirka, int vyska) {
        this(x, y, sirka, vyska, IMPLICITNI_PODIL_SIRKY_KMENE, IMPLICITNI_PODIL_VYSKY_KMENE);
    }
        
    public Strom(int x, int y, int sirka, int vyska, int podilSirkyKmene, int podilVyskyKmene) {
        this(x, y, sirka, vyska, podilSirkyKmene, podilVyskyKmene, IMPLICITNI_BARVA_KORUNY, IMPLICITNI_BARVA_KMENE);
    }
    
    public Strom(int x, int y, int sirka, int vyska, int podilSirkyKmene, int podilVyskyKmene, Barva barvaKoruny, Barva barvaKmene) {
        koruna = new Elipsa(0, 0, 0, 0);
        kmen = new Obdelnik(0, 0, 0, 0);
        this.podilSirkyKmene = podilSirkyKmene;
        this.podilVyskyKmene = podilVyskyKmene;
        setPozice(x, y);
        setRozmer(sirka, vyska);
        setBarvaKoruny(barvaKoruny);
        setBarvaKmene(barvaKmene);
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
    
    public Barva getBarvaKoruny() {
        return koruna.getBarva();
    }
    
    public Barva getBarvaKmene() {
        return kmen.getBarva();
    }
    
    public void nakresli() {
        koruna.nakresli();
        kmen.nakresli();
    }
    
    public void smaz() {
        koruna.smaz();
        kmen.smaz();
    }
    
    public void posunDolu(int vzdalenost) {
        koruna.posunDolu(vzdalenost);
        kmen.posunDolu(vzdalenost);
        nakresli();
    }
    
    public void posunVpravo(int vzdalenost) {
        koruna.posunVpravo(vzdalenost);
        kmen.posunVpravo(vzdalenost);
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
        koruna.setPozice(x, y);
        kmen.setPozice(x + koruna.getSirka() / 2 - kmen.getSirka() / 2, y + koruna.getVyska());
        nakresli();
    }
    
    public void setRozmer(int sirka, int vyska) {
        this.sirka = sirka;
        this.vyska = vyska;
        koruna.setRozmer(sirka, (podilVyskyKmene - 1) * vyska / podilVyskyKmene);
        kmen.setRozmer(sirka / podilSirkyKmene, vyska / podilVyskyKmene);
        setPozice(getX(), getY());
    }
    
    public void setBarvaKoruny(Barva barva) {
        koruna.setBarva(barva);
        nakresli();
    }
    
    public void setBarvaKmene(Barva barva) {
        kmen.setBarva(barva);
        nakresli();
    }
    
    public void zaramuj() {
        platno.setRozmer(getSirka(), getVyska());
        setPozice(0, 0);
    }
}
