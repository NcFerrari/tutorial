package lp.cesky.tvary;

import lp.cesky.spolecne.P;

/*******************************************************************************
 * Trida Presouvac slouzi k pohybu s instancemi trid
 * implementujicich rozhrani IPosuvny.
 *
 * @author     Rudolf Pecinovsky
 * @version    2.01, duben 2004
 */
public class Presouvac
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================

    /** Tento atribut je tu pouze pro zjednoduseni psani. */
    private static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    /** Oocet milisekund mezi dvema prekreslenimi objektu. */
    private static final int PERIODA = 50;  



//== PROMENNE ATRIBUTY TRIDY ===================================================

    /** Pocet vytvorenych instanci */
    private static int pocet = 0;



//== KONSTANTNI ATRIBUTY INSTANCI ==============================================

    /** Nazev sestavajici z nazvu tridy a poradi instance */
    private final String nazev;



//== PROMENNE ATRIBUTY INSTANCI ================================================

    /** Specifikuje rychlost posunu objektu danym posunovacem. */
    private int rychlost;


//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Vytvori presouvace, ktery bude presouvat objekty rychlosti 1.
     */
    public Presouvac()
    {
        this( 1 );
    }


    /***************************************************************************
     * Vytvori presouvace, ktery bude presouvat objekty zadanou rychlosti.
     *
     * @param rychlost Rychlost, kterou bude presouvac pohybovat
     *                 se sverenymi objekty.
     */
    public Presouvac( int rychlost )
    {
        if( rychlost <= 0 )
            throw new IllegalArgumentException(
                "Zadana rychlost musi byt nezaporna!" );
        this.rychlost = rychlost;
        this.nazev    = getClass().getName() + "(ID=" + ++pocet + 
                        ",rychlost=" + rychlost + ")";
    }



//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================

    /***************************************************************************
     * Metoda prevadi instanci na retezec -
     * pouziva se vetsinou pro ucely ladeni.
     * Mela by ji definovat kazda trida a uvest v ni
     * vsechny potrebne informace o vnitrnim stavu instance.
     *
     * @return     Retezec informujici o vnitrnim stavu instance
     */
    public String toString()
    {
        return nazev;
    }



//== NOVE ZAVEDENE METODY INSTANCI =============================================

    /***************************************************************************
     * Presune zadany objekt o pozadovany pocet bodu.
     *
     * @param objekt  Presouvany objekt
     * @param doprava Pocet bodu, o nez se objekt presune doprava
     * @param dolu    Pocet bodu, o nez se objekt presune dolu
     */
    public void presunO( IPosuvny objekt, int doprava, int dolu )
    {
        if( ! (objekt instanceof IKresleny) )
            throw new IllegalArgumentException(
                "Nafukovat se smi jen kreslitelne objekty" );
        IKresleny ik = (IKresleny)objekt;

        double vzdalenost = Math.sqrt(doprava*doprava + dolu*dolu);
        int    kroku      = (int)(vzdalenost / rychlost);
        double dx = (doprava+.4) / kroku;
        double dy = (dolu   +.4) / kroku;
        double x  = objekt.getX() + .4;
        double y  = objekt.getY() + .4;

        AP.pridej( ik );
        for(int i=kroku;   i > 0;   i-- )
        {
            x = x + dx;
            y = y + dy;
            AP.nekresli();
            objekt.setPozice( (int)x, (int)y );
            AP.prekresli();
            AP.vratKresli();
            P.cekej(PERIODA);
        }
    }


    /***************************************************************************
     * Presune zadany objekt do pozadovane pozice.
     *
     * @param objekt  Presouvany objekt
     * @param x       x-ova souradnice pozadovane cilove pozice
     * @param y       y-ova souradnice pozadovane cilove pozice
     */
    public void presunNa( IPosuvny objekt, int x, int y )
    {
        presunO( objekt, x-objekt.getX(), y-objekt.getY() );
    }


    /***************************************************************************
     * Presune zadany objekt do pozadovane pozice.
     *
     * @param objekt  Presouvany objekt
     * @param pozice  Pozadovane cilove pozice.
     */
    public void presunNa( IPosuvny objekt, Pozice pozice )
    {
        presunO( objekt, pozice.x-objekt.getX(), pozice.y-objekt.getY() );
    }



//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}

