public class Strom implements IKresleny {
    
    private static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    private static final Barva IMPLICITNI_BARVA_KORUNY = Barva.ZELENA;
    private static final Barva IMPLICITNI_BARVA_KMENE = Barva.HNEDA;
    private static final int IMPLICITNI_PODIL_SIRKY_KMENE = 10;
    private static final int IMPLICITNI_PODIL_VYSKY_KMENE = 3;
    
    private static int vytvorenychInstanci = 0;
    
    private final int poradi = ++vytvorenychInstanci;
    private final String nazev = getClass().getName() + "_" + poradi;
    private final Elipsa koruna;
    private final Obdelnik kmen;
    
    private int x;
    private int y;
    private int sirka;
    private int vyska;
    private int podilSirkyKmene = IMPLICITNI_PODIL_SIRKY_KMENE;
    private int podilVyskyKmene = IMPLICITNI_PODIL_VYSKY_KMENE;
    
    public static void zaramuj(int sirka, int vyska) {
        AP.setKrokRozmer(1, sirka, vyska);
        new Strom(0, 0, sirka, vyska).nakresli();
    }
    
    public static void alej() {
        AP.setKrokRozmer(1, 380, 450);
        new Strom(0, 0, 100, 150).nakresli();
        new Strom(70, 150, 100, 150).nakresli();
        new Strom(140, 300, 100, 150).nakresli();
        new Strom(140, 0, 100, 150).nakresli();
        new Strom(210, 150, 100, 150).nakresli();
        new Strom(280, 300, 100, 150).nakresli();
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
    
    public Strom(Pozice pozice) {
        this(pozice.getX(), pozice.getY());
    }
    
    public Strom(Rozmer rozmer) {
        this(0, 0, rozmer.getSirka(), rozmer.getVyska());
    }
    
    public Strom(Pozice pozice, Rozmer rozmer) {
        this(new Oblast(pozice, rozmer));
    }
    
    public Strom(Oblast oblast) {
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
    
    public Barva getBarvaKoruny() {
        return koruna.getBarva();
    }
    
    public Barva getBarvaKmene() {
        return kmen.getBarva();
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
        AP.pridej(this);
    }
    
    public void nakresli(Kreslitko kreslitko) {
        koruna.nakresli(kreslitko);
        kmen.nakresli(kreslitko);
    }
    
    public void smaz() {
        AP.odstran(this);
    }
    
    public void posunDolu(int vzdalenost) { 
        setPozice(getX(), getY() + vzdalenost);
    }
    
    public void posunVpravo(int vzdalenost) {
        setPozice(getX() + vzdalenost, getY());
    }
    
    public void posunDolu() {
        posunDolu(AP.getKrok());
    }
    
    public void posunVpravo() {
        posunVpravo(AP.getKrok());
    }
    
    public void posunVzhuru() {
        posunDolu(-AP.getKrok());
    }
    
    public void posunVlevo() {
        posunVpravo(-AP.getKrok());
    }
    
    public void setPozice(int x, int y) {
        this.x = x;
        this.y = y;
        koruna.setPozice(x, y);
        kmen.setPozice(x + koruna.getSirka() / 2 - kmen.getSirka() / 2, y + koruna.getVyska());
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
    }
    
    public void setBarvaKmene(Barva barva) {
        kmen.setBarva(barva);
    }
    
    public void zaramuj() {
        AP.odstranVse();
        AP.setKrokRozmer(1, getSirka(), getVyska());
        setPozice(0, 0);
        AP.pridej(this);
    }
    
    @Override
    public String toString() {
        return String.format("%s: x=%d, y=%d, šíøka=%d, výška=%d",
                            getNazev(), getX(), getY(), getSirka(), getVyska());
    }
}
