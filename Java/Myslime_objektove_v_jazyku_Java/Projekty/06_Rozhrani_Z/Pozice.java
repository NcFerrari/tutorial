/*******************************************************************************
 * Trida Pozice slouzi jako prepravka uchovavajici informace o pozici objektu.
 * Proto jsou jeji atributy deklarovany jako verejne.
 *
 * @author     Rudolf Pecinovsky
 * @version    2.01, duben 2004
 */
public class Pozice
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
//== PROMENNE ATRIBUTY INSTANCI ================================================

    /** Vodorovna souradnice dane pozice. */
    public int x;

    /** Svisla souradnice dane pozice. */
    public int y;



//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Bezparametricky konstruktor vytvori instanci s nulovymi souradnicemi.
     */
    public Pozice()
    {
    }


    /***************************************************************************
     * Vytvori instanci se zadanymi souradnicemi.
     *
     * @param x  Vodorovna souradnice.
     * @param y  Svisla souradnice.
     */
    public Pozice( int x, int y )
    {
        this.x = x;
        this.y = y;
    }


    /***************************************************************************
     * Vytvori instanci, ktera je kopii zadane instance.
     *
     * @param pozice  Referencni pozice.
     */
    public Pozice( Pozice pozice )
    {
        this( pozice.x, pozice.y );
    }



//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================

    /***************************************************************************
     * Vrati hodnotu vodorovne souradnice dane pozice.
     *
     * @return  Pozadovana souradnice.
     */
    public int getX()
    {
        return x;
    }


    /***************************************************************************
     * Vrati hodnotu svisle souradnice dane pozice.
     *
     * @return  Pozadovana souradnice.
     */
    public int getY()
    {
        return y;
    }


    /***************************************************************************
     * Nastavi hodnoty souradnic dane pozice.
     *
     * @param x Nastavovana vodorovna souradnice.
     * @param y Nastavovana svisla souradnice.
     */
    public void setPozice( int x, int y )
    {
        this.x = x;
        this.y = y;
    }


    /***************************************************************************
     * Nastavi hodnoty souradnic dane pozice podle parametru.
     *
     * @param pozice Pozice, jejiz parametry prevezmeme.
     */
    public void setPozice( Pozice pozice )
    {
        this.x = pozice.x;
        this.y = pozice.y;
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
        return "Pozice[x=" + x + ",y=" + y + "]";
    }



//== NOVE ZAVEDENE METODY INSTANCI =============================================

    /***************************************************************************
     * Nastavi souradnice dane pozice na zadane hodnoty.
     *
     * @param  x   Nastavovana vodorovna souradnice.
     * @param  y   Nastavovana svisla souradnice.
     */
    public void presunNa( int x, int y )
    {
        this.x = x;
        this.y = y;
    }


    /***************************************************************************
     * Nastavi souradnice dane pozice podle parametru.
     *
     * @param  pozice   Pozice, jejiz nastaveni se kopiruje.
     */
    public void presunNa( Pozice pozice )
    {
        this.x = pozice.x;
        this.y = pozice.y;
    }


    /***************************************************************************
     * Presun souradnic dane pozice o zadany pocet bodu v obou smerech.
     *
     * @param  dx   Vodorovna vzdalnost presunu.
     * @param  dy   Svisla vzdalnost presunu.
     */
    public void presunO( int dx, int dy )
    {
        x += dx;
        y += dy;
    }



//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}

