package dela;

import rup.cesky.tvary.Text;

import java.awt.event.KeyEvent;


/*******************************************************************************
 * Trida Sbl_Trida slouzi k ...
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
public class Delo_11d extends Delo_11b
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
    
    /** Pocet vystrlu za vterinu. */
    private static final int KADENCE = 10;
    
    /** Prodleva mezi jednotlivymi vystrely v milisekundach. */
    private static final int PRODLEVA = 1000 / KADENCE;
    
    
    
//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * 
     */
    public Delo_11d(int x, char spoust)
    {
        super( x, spoust );
    }


//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
    
    private long naposledy = 0;

    public void keyPressed( KeyEvent ke )
    {
        if( ke.getKeyChar() == spoust )
        {
            long nyni = ke.getWhen();
            if( (nyni - naposledy) > PRODLEVA )
            {
                if( naboju > 0)
                {
                    Strela strela = new Strela( xPos, VYSKA_PLATNA );
                    AP.pridejPod( this,  strela );
                    MP.presun( strela, xPos, 0, RYCHLOST_STRELY );
                    naposledy = nyni;
                    --naboju;
                    popisek = new Text( odpal + naboju, 
                                        popisek.getX(), popisek.getY() );
                }
            }
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
    public static void start_11d()
    {
        new Delo_11d( 100, ' ' );
        new Delo_11d( 200, ' ' );
    }

}

