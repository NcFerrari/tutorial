package lp.cesky.tvary;

import lp.cesky.spolecne.P;

                                                                            /**/
/*******************************************************************************
 * Trida pro praci s trojuhelnikem komunikujicim s aktivnim platnem.
 *
 * Oproti stejnojmenne tride z projektu
 * 06_Rozhrani se zmenilo pouze implementovane rozhrani.
 *
 * @author     Rudolf Pecinovsky
 * @version    2.01, duben 2004
 */
public class Trojuhelnik extends AHybaci 
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================

    /** Pocatecni Barva nakreslene instance v pripade,
     *  kdy uzivatel zadnou pozadovanou barvu nezada -
     *  pro trojuhelnik Barva.ZELENA. */
    public static final Barva IMPLICITNI_BARVA = Barva.ZELENA;
    public static final Smer8 IMPLICITNI_SMER = Smer8.SEVER;

    /** Aktivni platno, ktere dohlizi na spravne vykresleni instance. */
    protected static final AktivniPlatno AP = AktivniPlatno.getPlatno();



//== PROMENNE ATRIBUTY TRIDY ===================================================

    /** Pocet vytvorenych instanci */
    private static int pocet = 0;
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
//== PROMENNE ATRIBUTY INSTANCI ================================================
    private Smer8 smer;
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Vytvori novou instanci s implicitnimi rozmery, umistenim, barvou
     * a natocenim.
     * Instance bude umistena v levem hornim rohu platna
     * a bude mit implicitni barvu,
     * vysku 1 pole, sirku 2 pole a bude natocena vrocholem na sever.
     */
    public Trojuhelnik()
    {
        this( 0, 0, 2*AP.getKrok(), AP.getKrok() );
    }


    /***************************************************************************
     * Vytvori novou instanci se zadanou polohou a rozmery
     * a implicitni barvou a smerem natoceni.
     *
     * @param x       x-ova souradnice pocatku, x=0 ma levy okraj platna
     * @param y       y-ova souradnice pocatku, y=0 ma horni okraj platna
     * @param sirka   sirka vytvarene instance
     * @param vyska   vyska vytvarene instance
     */
    public Trojuhelnik( int x, int y, int sirka, int vyska )
    {
        this( x, y, sirka, vyska, IMPLICITNI_BARVA, IMPLICITNI_SMER );
    }


    /***************************************************************************
     * Vytvori novou instanci se zadanou polohou, rozmery a smerem natoceni
     * a s implicitni barvou.
     *
     * @param x       x-ova souradnice pocatku, x=0 ma levy okraj platna
     * @param y       y-ova souradnice pocatku, y=0 ma horni okraj platna
     * @param sirka   sirka vytvarene instance
     * @param vyska   vyska vytvarene instance
     * @param smer    Smer, do nejz bude natocen vrchol trojuhelniku -
     *                je treba zadat nekterou z instanci tridy Smer8
     */
    public Trojuhelnik( int x, int y, int sirka, int vyska, Smer8 smer )
    {
        this( x, y, sirka, vyska, IMPLICITNI_BARVA, smer );
    }


    /***************************************************************************
     * Vytvori novou instanci se zadanymi rozmery, polohou a barvou.
     * Smer natoceni bude implicitni, tj. na sever.
     *
     * @param x       x-ova souradnice pocatku, x=0 ma levy okraj platna
     * @param y       y-ova souradnice pocatku, y=0 ma horni okraj platna
     * @param sirka   sirka vytvarene instance
     * @param vyska   vyska vytvarene instance
     * @param barva   barva vytvarene instance
     */
    public Trojuhelnik( int x, int y, int sirka, int vyska, Barva barva )
    {
        this( x, y, sirka, vyska, barva, IMPLICITNI_SMER );
    }


    /***************************************************************************
     * Vytvori novou instanci se zadanou polohou a rozmery, barvou a merem.
     *
     * @param pozice  Pozice vytvarene instance
     * @param rozmer  Rozmer vytvarene instance
     * @param barva   barva vytvarene instance
     * @param smer    Smer, do nejz je natocen vrchol trojuhelniku -
     *                je treba zadat nekterou z instanci tridy Smer8
     */
    public Trojuhelnik( Pozice pozice, Rozmer rozmer, Barva barva, Smer8 smer )
    {
        this( pozice.x, pozice.y, rozmer.sirka, rozmer.vyska, barva, smer );
    }


    /***************************************************************************
     * Vytvori novou instanci v zadane oblasti a se zadanou barvou.
     *
     * @param oblast  Oblast, v niz se ma instance vytvorit
     * @param barva   barva vytvarene instance
     * @param smer    Smer, do nejz je natocen vrchol trojuhelniku -
     *                je treba zadat nekterou z instanci tridy Smer8
     */
    public Trojuhelnik( Oblast oblast, Barva barva, Smer8 smer )
    {
        this( oblast.x, oblast.y, oblast.sirka, oblast.vyska, barva, smer );
    }


    /***************************************************************************
     * Vytvori novou instanci se zadanymi rozmery, polohou, barvou,
     * i smerem natoceni.
     *
     * @param x       x-ova souradnice pocatku, x=0 ma levy okraj platna
     * @param y       y-ova souradnice pocatku, y=0 ma horni okraj platna
     * @param sirka   sirka vytvarene instance
     * @param vyska   vyska vytvarene instance
     * @param barva   barva vytvarene instance
     * @param smer    Smer, do nejz bude natocen vrchol trojuhelniku -
     *                je treba zadat nekterou z instanci tridy Smer8
     */
    public Trojuhelnik( int x, int y, int sirka, int vyska, Barva barva, Smer8 smer )
    {
        super(x, y, sirka, vyska, barva);
        this.nazev = P.nazevTridy(this) + "_" + ++pocet;
        this.smer  = smer;
    }



//== PRISTUPOVE METODY ATRIBUTU INSTANCI =======================================
    /***************************************************************************
     * Vrati smer instance. tj. smer, co nejz je otocen vrchol.
     *
     * @return  Instance tridy Smer8 definujici nastaveny smer.
     */
    public Smer8 getSmer()
    {
        return smer;
    }


    /***************************************************************************
     * Nastavi novy smer instance.
     *
     * @param novy  Pozadovany novy smer.
     */
    public void setSmer(Smer8 novy)
    {
        smer = novy;
        AP.prekresli();
    }

//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================

    /***************************************************************************
     * Za pomoci dodaneho kreslitka vykresli obraz sve instance
     * na animacni platno.
     *
     * @param kreslitko   Kreslitko, kterym se instance nakresli na platno.
     */
    public void nakresli( Kreslitko kreslitko )
    {
        int[][] points = getVrcholy();
        kreslitko.vyplnPolygon( points[0], points[1], getBarva() );
    }



//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================

    /***************************************************************************
     * Prevede instanci na retezec. Pouziva se predevsim pri ladeni.
     *
     * @return Retezcova reprezentace dane instance.
     */
    public String toString()
    {
        return nazev + ": x=" + getX() + ", y=" + getY() +
               ",getSirka()=" + getSirka() + ",getVyska()=" + getVyska() +
               ", getBarva()=" + getBarva() + ", smer=" + smer;
    }



//== NOVE ZAVEDENE METODY INSTANCI =============================================
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================

    /***************************************************************************
     * Vrati matici se souradnicemi vrcholu daneho trojuhelniku.
     *
     * @return Pozadovana matice
     */
    private int[][] getVrcholy()
    {
        int[] xpoints = null;
        int[] ypoints = null;

        switch( smer )
        {
            case VYCHOD:
                xpoints = new int[]{ getX(),  getX() + (getSirka()),    getX() };
                ypoints = new int[]{ getY(),  getY() + (getVyska()/2),  getY() + getVyska() };
                break;

            case SEVEROVYCHOD:
                xpoints = new int[]{ getX(),  getX() + getSirka(),  getX() + getSirka() };
                ypoints = new int[]{ getY(),  getY(),          getY() + getVyska() };
                break;

            case SEVER:
                xpoints = new int[]{ getX(),         getX() + (getSirka()/2), getX() + getSirka() };
                ypoints = new int[]{ getY() + getVyska(), getY(),             getY() + getVyska() };
                break;

            case SEVEROZAPAD:
                xpoints = new int[]{ getX(),          getX(),  getX() + getSirka() };
                ypoints = new int[]{ getY() + getVyska(),  getY(),  getY()         };
                break;

            case ZAPAD:
                xpoints = new int[]{ getX(),             getX() + getSirka(), getX() + getSirka() };
                ypoints = new int[]{ getY() + (getVyska()/2), getY(),         getY() + getVyska() };
                break;

            case JIHOZAPAD:
                xpoints = new int[]{ getX(),  getX(),          getX() + getSirka() };
                ypoints = new int[]{ getY(),  getY() + getVyska(),  getY() + getVyska() };
                break;

            case JIH:
                xpoints = new int[]{ getX(),  getX() + (getSirka()/2),  getX() + getSirka() };
                ypoints = new int[]{ getY(),  getY() + getVyska(),      getY(),        };
                break;

            case JIHOVYCHOD:
                xpoints = new int[]{ getX(),          getX() +getSirka(),   getX() + getSirka() };
                ypoints = new int[]{ getY() + getVyska(),  getY() + getVyska(),  getY()         };
                break;

            default:
                throw new IllegalStateException(
                    "Instance ukazuje do nedefinovaneho smeru" );
        }
        return new int[][] { xpoints, ypoints };
    }



//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}

