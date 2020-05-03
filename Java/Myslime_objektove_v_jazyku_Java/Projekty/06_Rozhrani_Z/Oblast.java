/*******************************************************************************
 * Trida Oblast slouzi jako prepravka uchovavajici informace o pozici 
 * a rozmeru dane obdelnikove oblasti.
 * Proto jsou jeji atributy deklarovany jako verejne.
 *
 * @author     Rudolf Pecinovsky
 * @version    2.01, duben 2004
 */
public class Oblast
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
//== PROMENNE ATRIBUTY INSTANCI ================================================

    /** Vodorovna souradnice dane oblasti, tj. jejiho leveho horniho rohu. */
    public int x;

    /** Svisla souradnice dane oblasti, tj. jejiho leveho horniho rohu. */
    public int y;

    /** Sirka oblasti. */
    public int sirka;

    /** Vyska oblasti. */
    public int vyska;


//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Bezparametricky konstruktor vytvari pradznou oblast v pocatku,
     * tj. oblast o rozmerech (0\u00d70) umistenou v bode [0;0].
     */
    public Oblast()
    {
    }


    /***************************************************************************
     * Vytvori oblast se zadanym umistenim a rozmery.
     *
     * @param x      Vodorovna souradnice oblasti, tj. jejiho leveho horniho rohu.
     * @param y      Svisla souradnice oblasti, tj. jejiho leveho horniho rohu.
     * @param sirka  Sirka oblasti.
     * @param vyska  Vyska oblasti.
     */
    public Oblast( int x, int y, int sirka, int vyska )
    {
        this.x     = x;
        this.y     = y;
        this.sirka = sirka;
        this.vyska = vyska;
    }


    /***************************************************************************
     * Vytvori oblast, ktera je kopii zadane instance.
     *
     * @param oblast  Referencni oblast.
     */
    public Oblast( Oblast o )
    {
        this( o.x, o.y, o.sirka, o.vyska );
    }


    /***************************************************************************
     * Vytvori oblast se zadanym umistenim a rozmery.
     *
     * @param Pozice  Pozice oblasti, tj pozice jejiho leveho horniho rohu.
     * @param Rozmer  Rozmer vytvarene oblasti.
     */
    public Oblast( Pozice pozice, Rozmer rozmer )
    {
        this( pozice.x, pozice.y, rozmer.sirka, rozmer.vyska );
    }


    /***************************************************************************
     * Vytvori prazdnou oblast, tj. oblast o rozmerech (0\u00d70),
     * ktera je umistena v zadanem bode.
     *
     * @param pozice  Referencni pozice.
     */
    public Oblast( Pozice pozice )
    {
        this( pozice.x, pozice.y, 0, 0 );
    }


    /***************************************************************************
     * Vytvori oblast se zadanymi rozmery umistenou v bode [0;0].
     *
     * @param sirka  Sirka oblasti.
     * @param vyska  Vyska oblasti.
     */
    public Oblast( int sirka, int vyska )
    {
        this( 0, 0, sirka, vyska );
    }


    /***************************************************************************
     * Vytvori oblast se zadanymi rozmery umistenou v bode [0;0].
     *
     * @param rozmer  Referencni rozmer.
     */
    public Oblast( Rozmer rozmer )
    {
        this( 0, 0, rozmer.sirka, rozmer.vyska );
    }



//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================

    /***************************************************************************
     * Vrati hodnotu vodorovne souradnice dane oblasti.
     *
     * @return  Pozadovana souradnice.
     */
    public int getX()
    {
        return x;
    }


    /***************************************************************************
     * Vrati hodnotu svisle souradnice dane oblasti.
     *
     * @return  Pozadovana souradnice.
     */
    public int getY()
    {
        return y;
    }


    /***************************************************************************
     * Nastavi hodnoty souradnic dane oblasti.
     *
     * @param x Nastavovana vodorovna souradnice.
     * @param y Nastavovana svisla souradnice.
     */
    public Pozice getPozice()
    {
        return new Pozice ( x, y );
    }


    /***************************************************************************
     * Nastavi hodnoty souradnic dane oblasti.
     *
     * @param x Nasvavovana vodorovna souradnice.
     * @param y Nasvavovana svisla souradnice.
     */
    public void setPozice( int x, int y )
    {
        this.x = x;
        this.y = y;
    }


    /***************************************************************************
     * Nastavi hodnoty souradnic dane oblasti podle parametru.
     *
     * @param pozice Pozice, jejiz parametry prevezmeme.
     */
    public void setPozice( Pozice pozice )
    {
        this.x = pozice.x;
        this.y = pozice.y;
    }


    /***************************************************************************
     * Vrati velikost sirky oblasti.
     *
     * @return  Sirka oblasti.
     */
    public int getSirka()
    {
        return sirka;
    }


    /***************************************************************************
     * Vrati velikost vysky oblasti.
     *
     * @return  Vyska oblasti.
     */
    public int getVyska()
    {
        return vyska;
    }


    /***************************************************************************
     * Nastavi sirku a vysku oblasti.
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
     * Nastavi sirku a vysku oblasti podle parametru.
     *
     * @param rozmer Rozmer, jehoz parametry prevezmeme.
     */
    public void setRozmer( Rozmer rozmer )
    {
        this.sirka = rozmer.sirka;
        this.vyska = rozmer.vyska;
    }


    /***************************************************************************
     * Nastavi novou pozici a rozmer oblasti.
     *
     * @param x      Vodorovna souradnice oblasti, tj. jejiho leveho horniho rohu.
     * @param y      Svisla souradnice oblasti, tj. jejiho leveho horniho rohu.
     * @param sirka  Sirka oblasti.
     * @param vyska  Vyska oblasti.
     */
    public void setOblast( int x, int y, int sirka, int vyska )
    {
        this.x     = x;
        this.y     = y;
        this.sirka = sirka;
        this.vyska = vyska;
    }


    /***************************************************************************
     * Nastavi novou pozici a rozmer oblasti.
     *
     * @param oblast  Referencni oblast.
     */
    public void setOblast( Oblast o )
    {
        setOblast( o.x, o.y, o.sirka, o.vyska );
    }


    /***************************************************************************
     * Nastavi novou pozici a rozmer oblasti.
     *
     * @param Pozice  Pozice oblasti, tj pozice jejiho leveho horniho rohu.
     * @param Rozmer  Rozmer vytvarene oblasti.
     */
    public void setOblast( Pozice pozice, Rozmer rozmer )
    {
        setOblast( pozice.x, pozice.y, rozmer.sirka, rozmer.vyska );
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
        return "Oblast: x=" + x + ",y=" + y + ",sirka=" +
                sirka + ",vyska=" + vyska;
    }



//== NOVE ZAVEDENE METODY INSTANCI =============================================
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}

