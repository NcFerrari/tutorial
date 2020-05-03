/*******************************************************************************
 * Trida pro praci s obdelnikem komunikujicim s aktivnim platnem.
 *  
 * Oproti stejnojmenne tride z projektu 
 * 06_Rozhrani se zmenilo pouze implementovane rozhrani.   
 *   
 * @author     Rudolf Pecinovsky
 * @version    2.01, duben 2004
 */
public class Obdelnik extends Posuvny implements IHybaci
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================

    /** Pocatecni barva nakreslene instance v pripade,
     *  kdy uzivatel zadnou pozadovanou barvu nezada -
     *  pro obdelnik Barva.CERVENA. */
    public static final Barva IMPLICITNI_BARVA = Barva.CERVENA;



//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
//== PROMENNE ATRIBUTY INSTANCI ================================================

    private int    sirka;   //sirka v bodech
    private int    vyska;   //Vyska v bodech
    private Barva  barva;   //Barva instance



//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A METODY VRACEJICI INSTANCE VLASTNI TRIDY ====================

    /***************************************************************************
     * Vytvori novou instanci s implicitnimi rozmery, umistenim a barvou.
     * Instance bude umistena v levem hornim rohu platna 
     * a bude mit implicitni barvu, 
     * vysku 1 pole a sirku 2 pole.
     */
    public Obdelnik()
    {
        this( 0, 0, 2*AP.getKrok(), AP.getKrok() );
    }


    /***************************************************************************
     * Vytvori novou instanci se zadanou polohou a rozmery
     * a implicitni barvou.
     *
     * @param x      x-ova souradnice instance, x>=0, x=0 ma levy okraj platna
     * @param y      y-ova souradnice instance, y>=0, y=0 ma horni okraj platna
     * @param sirka   Sirka vytvarene instance,  sirka > 0
     * @param vyska   Vyska vytvarene instance,  vyska > 0
     */
    public Obdelnik( int x, int y, int sirka, int vyska )
    {
        this( x, y, sirka, vyska, IMPLICITNI_BARVA );
    }


    /***************************************************************************
     * Vytvori novou instanci se zadanou polohou, rozmery 
     * a barvou.
     *
     * @param pozice    Pozice vytvarene instance
     * @param rozmer    Rozmer vytvarene instance
     * @param barva     Barva vytvarene instance
     */
    public Obdelnik(Pozice pozice, Rozmer rozmer, Barva barva)
    {
        this( pozice.x, pozice.y, rozmer.sirka, rozmer.vyska, barva );
    }


    /***************************************************************************
     * Vytvori novou instanci vyplnujici zadanou oblast 
     * a majici zadanou barvu.
     *
     * @param oblast   Oblast definujici pozici a rozmer vytvarene instance
     * @param barva    Barva vytvarene instance
     */
    public Obdelnik(Oblast oblast, Barva barva)
    {
        this( oblast.x, oblast.y, oblast.sirka, oblast.vyska, barva );
    }


    /***************************************************************************
     * Vytvori novou instanci se zadanymi rozmery, polohou a barvou.
     *
     * @param x       x-ova souradnice instance, x>=0, x=0 ma levy okraj platna
     * @param y       y-ova souradnice instance, y>=0, y=0 ma horni okraj platna
     * @param sirka   Sirka vytvarene instance,  sirka > 0
     * @param vyska   Vyska vytvarene instance,  vyska > 0
     * @param barva   Barva vytvarene instance
     */
    public Obdelnik( int x, int y, int sirka, int vyska, Barva barva )
    {
        super( x, y );
        this.sirka = sirka;
        this.vyska = vyska;
        this.barva = barva;
    }



//== PRISTUPOVE METODY ATRIBUTU INSTANCI =======================================

    /***************************************************************************
     * Vrati sirku instance.
     *
     * @return  Sirka instance v bodech
     */
     public int getSirka()
     {
         return sirka;
     }


    /***************************************************************************
     * Vrati vysku instance.
     *
     * @return  Vyska instance v bodech
     */
     public int getVyska()
     {
         return vyska;
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
     * Nastavi novy "ctvercovy" rozmer instance -
     * na zadany rozmer se nastavi vyska i sirka.
     *
     * @param rozmer  Nove nastavovany rozmer v obou smerech; rozmer>0
     */
    public void setRozmer(int rozmer)
    {
        setRozmer( rozmer, rozmer );
    }


    /***************************************************************************
     * Nastavi nove rozmery instance.
     *
     * @param sirka    Nove nastavovana sirka; sirka>0
     * @param vyska    Nove nastavovana vyska; vyska>0
     */
    public void setRozmer(int sirka, int vyska)
    {
        if( (sirka < 0) || (vyska < 0) )
            throw new IllegalArgumentException(
                "Rozmery musi byt kladne: sirka=" + sirka + ", vyska=" + vyska );
        this.sirka = sirka;
        this.vyska = vyska;
        AP.prekresli();
    }


    /***************************************************************************
     * Nastavi nove rozmery instance.
     *
     * @param rozmer    Nove nastavovany rozmer.
     */
    public void setRozmer(Rozmer rozmer)
    {
        setRozmer( rozmer.sirka, rozmer.vyska );
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
     * Nastavi novou polohu a rozmery instance.
     *
     * @param o    Nove nastavovana oblast zaujimana instanci.
     */
    public void setOblast(Oblast o)
    {
        AP.nekresli();
            setPozice( o.x,     o.y     );
            setRozmer( o.sirka, o.vyska );
        AP.vratKresli();
    }


    /***************************************************************************
     * Vrati barvu instance.
     *
     * @return  Instance tridy Barva definujici nastavenou barvu.
     */
    public Barva getBarva()
    {
        return barva;
    }


    /***************************************************************************
     * Nastavi novou barvu instance.
     *
     * @param nova   Pozadovana nova barva.
     */
    public void setBarva(Barva nova)
    {
        barva = nova;
        AP.prekresli();
    }



//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================

    /***************************************************************************
     * Za pomoci dodaneho kreslitka vykresli obraz sve instance
     * na animacni platno.
     *  
     * @param kr   Kreslitko, kterym se instance nakresli na platno.     
     */
    public void nakresli( Kreslitko kr )
    {
        //Volam rodicovske verze metod, abych mel jistotu, co se zavola,
        //a aby se pri prekryti nektere z pouzitych metod 
        //nezavolalo neco jineho, co muze vrati pro mne nevhodnou hodnotu.
        kr.vyplnRam( super.getX(), super.getY(), 
                     getSirka(),   getVyska(),   barva );
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
        return super.toString() + 
               ", sirka=" + getSirka() + ", vyska=" + getVyska() +
               ", barva=" + barva;
    }



//== NOVE ZAVEDENE METODY INSTANCI =============================================
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}//public class Obdelnik

