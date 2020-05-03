package rup.cesky.tvary;

/*******************************************************************************
 * Trida Rozmer slouzi jako prepravka k uchovavani informaci o rozmeru objektu.
 * Proto jsou jeji atributy deklarovany jako verejne.
 *
 * @author     Rudolf Pecinovsky
 * @version    2.01, duben 2004
 */
public class Rozmer
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
//== PROMENNE ATRIBUTY INSTANCI ================================================

    /** Sirka objektu. */
    public int sirka;

    /** Vyska objektu. */
    public int vyska;


//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Bezparametricky konstruktor vytvori instanci s nulovymi rozmery.
     */
    public Rozmer()
    {
    }


    /***************************************************************************
     * Vytvori instanci se zadanymi rozmery.
     *
     * @param sirka  Sirka objektu.
     * @param vyska  Vyska objektu.
     */
    public Rozmer( int sirka, int vyska )
    {
        this.sirka = sirka;
        this.vyska = vyska;
    }


    /***************************************************************************
     * Vytvori instanci, ktera je kopii zadane instance.
     *
     * @param rozmer  Referencni rozmer.
     */
    public Rozmer( Rozmer rozmer )
    {
        this( rozmer.sirka, rozmer.vyska );
    }


//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================

    /***************************************************************************
     * Vrati velikost sirky objektu.
     *
     * @return  Sirka objektu.
     */
    public int getSirka()
    {
        return sirka;
    }


    /***************************************************************************
     * Vrati velikost vysky objektu.
     *
     * @return  Vyska objektu.
     */
    public int getVyska()
    {
        return vyska;
    }


    /***************************************************************************
     * Nastavi sirku a vysku objektu.
     *
     * @param sirka Nastavovana sirka.
     * @param vyska Nastavovana vyska.
     */
    public void setRozmer( int x, int y )
    {
        this.sirka = sirka;
        this.vyska = vyska;
    }


    /***************************************************************************
     * Nastavi sirku a vysku objektu podle parametru.
     *
     * @param rozmer Rozmer, jehoz parametry prevezmeme.
     */
    public void setRozmer( Rozmer rozmer )
    {
        this.sirka = rozmer.sirka;
        this.vyska = rozmer.vyska;
    }


//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================

    /***************************************************************************
     * Vraci textovou reprezentaci dane instance
     * pouzivanou predevsim k ladicim ucelum.
     *
     * @return Pozadovana textova reprezentace.
     */
    public String toString()
    {
        return "Rozmer: sirka=" + sirka + ", vyska=" + vyska;
    }


//== NOVE ZAVEDENE METODY INSTANCI =============================================

    /***************************************************************************
     * Nastavi rozmery na zadane hodnoty.
     *
     * @param  sirka   Nastavovana sirka.
     * @param  vyska   Nastavovana vyska.
     */
    public void nastav( int sirka, int vyska )
    {
        this.sirka = sirka;
        this.vyska = vyska;
    }


    /***************************************************************************
     * Nastavi rozmer podle parametru.
     *
     * @param  rozmer   Rozmer, jehoz nastaveni se kopiruje.
     */
    public void nastav( Rozmer rozmer )
    {
        this.sirka = rozmer.sirka;
        this.vyska = rozmer.vyska;
    }


    /***************************************************************************
     * Presun souradnic dane pozice o zadany pocet bodu v obou smerech.
     *
     * @param  dsirka   Zmena sirky (>0=zvetsit, <0=zmensit).
     * @param  dvyska   Zmena vysky (>0=zvetsit, <0=zmensit).
     */
    public void zmenO( int dsirka, int dvyska )
    {
        sirka += dsirka;
        vyska += dvyska;
    }


//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}

