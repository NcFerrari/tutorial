/*******************************************************************************
 * Trida Strom_5 rozsiruje definici o konstrukce probrane v podkapitole
 * o prepravkach.
 *
 *  Od Strom_5 je tu pridano:
 *  - konsturktory s parametry pro instance trid Pozice, Rozmer a Oblast
 *  - Pristupove metody majici za parametr nebo vracejici
 *    instance trid Pozice, Rozmer a Oblast
 *  - staticka metoda obrazek(Oblast,int)
 *
 *  Navic je trida doplnena o radkove komentare tak,
 *  aby odpovidala tridam vytvorenym podle sablony.
 *
 * @author     Rudolf Pecinovsky
 * @version    2.01, duben 2004
 */
public class Strom_5
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================

    /** Udava, kolikrat je strom vyssi nez samotny kmen. */
    public static final int IMPLICITNI_POMER_VYSKY =  3;

    /** Udava, kolikrat je koruna sirsi nez kmen. */
    public static final int IMPLICITNI_POMER_SIRKY = 10;



//== PROMENNE ATRIBUTY TRIDY ===================================================

    /** Velikost posunu pro bezparametricke posunove metody. */
    private static int krok = 50;

    /** Pocet doposud vytvorenych instanci. */
    private static int pocet = 0;



//== KONSTANTNI ATRIBUTY INSTANCI ==============================================

    /** Poradi kolikata byla dana instance vytvorena v ramci tridy. */
    private final int poradi = ++pocet;

    /** Nazev sestavajici z nazvu tridy a poradi instance */
    private final String nazev  = "Strom_" + poradi;

    /* Odkaz na instanci predstavujici korunu stromu. */
    private final Elipsa   koruna;

    /* Odkaz na instanci predstavujici korunu stromu. */
    private final Obdelnik kmen;



//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================

    /***************************************************************************
     * Vrati velikost implicitniho kroku, o ktery se instance presune
     * pri volani bezparametrickych metod presunu.
     *
     * @return Velikost implicitniho kroku v bodech
     */
    public static int getKrok()
    {
        return krok;
    }


    /***************************************************************************
     * Nastavi velikost implicitniho kroku, o ktery se instance presune
     * pri volani bezparametrickych metod presunu.
     *
     * @param velikost  Velikost implicitniho kroku v bodech;<br/>
     *                  musi platit:  0 <= velikost <= 100
     */
    public static void setKrok( int velikost )
    {
        krok = velikost;
    }


    /***************************************************************************
     * Metoda se dotaze uzivatele na pozadovanou velikost kroku pouzivaneho
     * v bezparametrickych posunovych metodach a zadanou hodnotu nastavi.
     */
    public static void setKrok()
    {
        krok = P.zadej( "Zadejte novou velikost kroku:", krok );
    }



//== OSTATNI METODY TRIDY ======================================================

    /***************************************************************************
     * Vytvori instanci zadane velikosti a upravi rozmer platna tak,
     * aby byla na platne prave zaramovana.
     *
     * @param sirka   Sirka stromu, ktery chceme vytvorit a zaramovat.
     * @param vyska   Vyska stromu, ktery chceme vytvorit a zaramovat.
     */
    public static void zaramuj( int sirka, int vyska )
    {
        Platno.getPlatno().setRozmer( sirka, vyska );
        new Strom_5( 0, 0, sirka, vyska );
    }


    /***************************************************************************
     * Metoda upravi rozmer platna a "vysadi" na nej alej dvou rad stromu
     * se tremi stromy v kazde rade. Stromy budou vysazeny sikmo ve smeru
     * hlavni diagonaly s kmenem zabirajicim 1/3 vysky a 1/10 sirky stromu.
     */
    public static void alej()
    {
        Platno platno = Platno.getPlatno();
        platno.setRozmer( 400, 350 );
        new Strom_5( 100,   0 );      new Strom_5( 300,   0 );
        new Strom_5(  50, 100 );      new Strom_5( 250, 100 );
        new Strom_5(   0, 200 );      new Strom_5( 200, 200 );
    }


    /***************************************************************************
     * Vytvori v zadane oblasti zaramovany obrazek stromu, pricemz sirka
     * ramu je zadana jako druhy parametr.
     */
    public static void obrazek( Oblast oblast, int sirkaRamu )
    {
        new Obdelnik( oblast, Barva.CERNA );
        oblast.x += sirkaRamu;
        oblast.y += sirkaRamu;
        oblast.sirka -= 2*sirkaRamu;
        oblast.vyska -= 2*sirkaRamu;

        new Obdelnik( oblast, Barva.AZUROVA );
        new Strom_5( oblast );
    }



//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Implicitni konstruktor tridy Strom_5 vytvori v levem hornim rohu platna
     * instanci sirokou 100 bodu, vysokou 150 bodu
     * s kmenem zabirajicim 1/3 vyska a 1/10 sirky stromu.
     */
    public Strom_5()
    {
        this( 0, 0 );
    }


    /***************************************************************************
     * Vytvori na zadanych souradnicich
     * instanci sirokou 100 bodu, vysokou 150 bodu
     * s kmenem zabirajicim 1/3 vyska a 1/10 sirky stromu.
     *
     * @param x       x-ova souradnice pocatku, x>=0, x=0 ma levy okraj platna
     * @param y       y-ova souradnice pocatku, y>=0, y=0 ma horni okraj platna
     */
    public Strom_5( int x, int y )
    {
        this( x, y, 100, 150 );
    }


    /***************************************************************************
     * Vytvori na zadanych souradnicich instanci se zadanou sirkou a vyskou.
     * Pomer velikosti kmene ku zbytku stromu zustane implicitni, tj.
     * kmen bude zabirat 1/3 vyska a 1/10 sirky stromu.
     *
     * @param x       x-ova souradnice pocatku, x>=0, x=0 ma levy okraj platna
     * @param y       y-ova souradnice pocatku, y>=0, y=0 ma horni okraj platna
     * @param sirka   Sirka vytvarene instance,  sirka > 0
     * @param vyska   Vyska vytvarene instance,  vyska > 0
     */
    public Strom_5( int x, int y, int sirka, int vyska )
    {
        this( x, y, sirka, vyska,
            IMPLICITNI_POMER_SIRKY, IMPLICITNI_POMER_VYSKY );
    }


    /**************************************************************************
     * Vytvori novou instanci se zadanou polohou a rozmery.
     *
     * @param pozice  Pozice vytvarene instance
     * @param rozmer  Rozmer vytvarene instance
     */
    public Strom_5(Pozice pozice, Rozmer rozmer)
    {
        this( pozice.x, pozice.y, rozmer.sirka, rozmer.vyska );
    }


    /**************************************************************************
     * Vytvori novou instanci vyplnujici zadanou oblast.
     *
     * @param oblast   Oblast definujici pozici a rozmer vytvarene instance
     */
    public Strom_5(Oblast oblast)
    {
        this( oblast.x, oblast.y, oblast.sirka, oblast.vyska );
    }


    /***************************************************************************
     * Vytvori na zadanych souradnicich instanci se zadanou sirkou, vyskou.
     * a pomerem velikosti kmene ku zbytku stromu.
     * Vytvorene instanci priradi jeji "rodne cislo".
     *
     * @param x       x-ova souradnice pocatku, x>=0, x=0 ma levy okraj platna
     * @param y       y-ova souradnice pocatku, y>=0, y=0 ma horni okraj platna
     * @param sirka   Sirka vytvarene instance,  sirka > 0
     * @param vyska   Vyska vytvarene instance,  vyska > 0
     * @param podilVyskyKmene  Kolikrat je kmen mensi nez cely strom
     * @param podilSirkyKmene  Kolikrat je kmen uzsi nez cely strom
     */
    public Strom_5( int x, int y, int sirka, int vyska,
                    int podilSirkyKmene, int  podilVyskyKmene )
    {
        int vyskaKmene  = vyska / podilVyskyKmene;
        int vyskaKoruny = vyska - vyskaKmene;
        int sirkaKmene  = sirka / podilSirkyKmene;
        int posunKmene  = ( sirka - sirkaKmene) / 2;
        koruna = new Elipsa  ( x, y, sirka, vyskaKoruny, Barva.ZELENA  );
        kmen   = new Obdelnik( x+posunKmene, y+vyskaKoruny,
                               sirkaKmene, vyskaKmene, Barva.HNEDA );
    }



//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================

    /***************************************************************************
     * Vrati x-ovou souradnici pozice instance.
     *
     * @return  x-ova souradnice.
     */
    public int getX()
    {
        return koruna.getX();
    }


    /***************************************************************************
     * Vrati y-ovou souradnici pozice instance.
     *
     * @return  y-ova souradnice.
     */
    public int getY()
    {
        return koruna.getY();
    }


    /***************************************************************************
     * Nastavi novou pozici instance.
     *
     * @param x   Nova x-ova pozice instance
     * @param y   Nova y-ova pozice instance
     */
    public void setPozice(int x, int y)
    {
        koruna.setPozice( x, y );
        kmen  .setPozice( x  +  (koruna.getSirka() - kmen.getSirka()) / 2,
                          y  +  koruna.getVyska()     );
        koruna.nakresli();
    }


    /***************************************************************************
     * Nastavi novou pozici instance.
     *
     * @param pozice   Nova pozice instance
     */
    public void setPozice(Pozice pozice)
    {
        setPozice( pozice.x, pozice.y );
    }


    /***************************************************************************
     * Vrati sirku instance.
     *
     * @return  Sirka instance v bodech
     */
    public int getSirka()
    {
        return koruna.getSirka();
    }


    /***************************************************************************
     * Vrati vysku instance.
     *
     * @return  Vyska instance v bodech
     */
    public int getVyska()
    {
        return koruna.getVyska() + kmen.getVyska();
    }


    /***************************************************************************
     * Vrati instanci tridy Rozmer s rozmery instance.
     *
     * @return   Rozmer s rozmery instance.
     */
    public Rozmer getRozmer()
    {
        return new Rozmer( getSirka(), getVyska() );
    }


    /***************************************************************************
     * Vrati instanci tridy Oblast s informacemi o pozici a rozmerech instance.
     *
     * @return   Oblast s informacemi o pozici a rozmere instance.
     */
    public Oblast getOblast()
    {
        return new Oblast( getX(), getY(), getSirka(), getVyska() );
    }


    /***************************************************************************
     * Vrati nazev instance, tj. nazev jeji tridy nasledovany poradim.
     *
     * @return  Retezec s nazvem instance.
     */
    public String getNazev()
    {
       return nazev;
    }


    /***************************************************************************
     * Vrati barvu koruny stromu.
     *
     * @return  Instance tridy Barva definujici nastavenou barvu koruny.
     */
    public Barva getBarvaKoruny()
    {
        return koruna.getBarva();
    }


    /***************************************************************************
     * Nastavi novou barvu koruny.
     *
     * @param nova  Pozadovana nova barva.
     */
    public void setBarvaKoruny( Barva nova )
    {
        koruna.setBarva( nova );
    }



//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
//== NOVE ZAVEDENE METODY INSTANCI =============================================

    /***************************************************************************
     * Prevede instanci na retezec obsahujici nazev tridy, poradi instance,
     * jeji souradnice a rozmery.
     *
     * @return Retezcova reprezentace dane instance.
     */
    public String toString()
    {
        return nazev + ": x=" + getX() + ", y=" + getY() +
               ", sirka=" + getSirka() + ", vyska=" + getVyska();
    }


    /***************************************************************************
     * Vykresli obraz sve instance na platno.
     */
    public void nakresli()
    {
        koruna.nakresli();
        kmen  .nakresli();
    }


    /***************************************************************************
     * Smaze obraz sve instance z platna (nakresli ji barvou pozadi platna).
     */
    public void smaz()
    {
        koruna.smaz();
        kmen  .smaz();
    }


    /***************************************************************************
     * Presune instanci o zadany pocet bodu vpravo,
     * pri zaporne hodnote parametru vlevo.
     *
     * @param vzdalenost Vzdalenost, o kterou se instance presune.
     */
    public void posunVpravo( int vzdalenost )
    {
        koruna.posunVpravo( vzdalenost );
        kmen  .posunVpravo( vzdalenost );
    }


    /***************************************************************************
     * Presune instanci o krok bodu vpravo.
     */
    public void posunVpravo()
    {
        posunVpravo( krok );
    }


    /***************************************************************************
     * Presune instanci o krok bodu vlevo.
     */
    public void posunVlevo()
    {
        posunVpravo( -krok );
    }


    /***************************************************************************
     * Presune instanci o zadany pocet bodu dolu,
     * pri zaporne hodnote parametru nahoru.
     *
     * @param vzdalenost   Pocet bodu, o ktere se instance presune.
     */
    public void posunDolu( int vzdalenost )
    {
        koruna.posunDolu( vzdalenost );
        kmen  .posunDolu( vzdalenost );
        koruna.nakresli();
    }


    /***************************************************************************
     * Presune instanci o krok bodu dolu.
     */
    public void posunDolu()
    {
        posunDolu( krok );
    }


    /***************************************************************************
     * Presune instanci o krok bodu nahoru.
     */
    public void posunVzhuru()
    {
        posunDolu( -krok );
    }


    /***************************************************************************
     * Nastavi parametry okna s platnem tak, aby prave zaramovalo danou
     * instanci. Instanci pred tim presune do leveho horniho rohu platna.
     */
    public void zaramuj()
    {
        Platno.getPlatno().setRozmer( getSirka(), getVyska() );
        setPozice( 0, 0 );
    }


//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}

