package dela;

import rup.cesky.tvary.Text;

import java.awt.event.KeyEvent;


/*******************************************************************************
 * Trida Sbl_Trida slouzi k ...
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
public class Delo_11f extends Delo_11e
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================

    /** Pocet bodu, o nez se delo posune po stisku posunove klavesy. */    
    protected static final int KROK = 5;
    
    
    
//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================

    protected final char VLEVO;
    protected final char VPRAVO;



//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * 
     */
    public Delo_11f(int x, String ovladani )
    {
        super( x, ovladani.charAt(1) );
        VLEVO = ovladani.charAt(0);
        VPRAVO= ovladani.charAt(2);
    }


//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
    
    public void posun( int dx )
    {
        xPos += dx;
        podstavec.posunVpravo( dx );
        hlaven   .posunVpravo( dx );
        popisek  .posunVpravo( dx );
    }
    
    
    
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
    
    public void keyPressed( KeyEvent ke )
    {
        if( ke.getKeyChar() == spoust )
        {
            super.keyPressed( ke );
        }
        else if( ke.getKeyChar() == VLEVO )
        {
            posun( -KROK );
        }
        else if( ke.getKeyChar() == VPRAVO )
        {
            posun( KROK );
        }
    }

    

//== NOVE ZAVEDENE METODY INSTANCI =============================================
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================

    /***************************************************************************
     * Testovaci metoda.
     * -
     * @param args Parametry prikazoveho radku se nepouzivaji.
     */
    public static void start_11f()
    {
        new Delo_11f( 100, "asd" );
        new Delo_11f( 200, "jkl" );
    }


}

