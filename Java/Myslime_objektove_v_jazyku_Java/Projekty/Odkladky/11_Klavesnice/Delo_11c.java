import rup.cesky.spolecne.P;

import java.awt.event.KeyEvent;


/*******************************************************************************
 * Trida Sbl_Trida slouzi k ...
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
public class Delo_11c extends Delo_11b
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
    
    private static final int KADENCE = 10;
    
    private static final int PRODLEVA = 1000 / KADENCE;
    
    
    
//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A METODY VRACEJICI INSTANCE VLASTNI TRIDY ====================

    /***************************************************************************
     * 
     */
    public Delo_11c(int x, char spoust)
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
            Strela strela = new Strela( xPos, VYSKA_PLATNA );
            AP.pridejPod( this,  strela );
            MP.presun( strela, xPos, 0, RYCHLOST_STRELY );
            P.cekej( PRODLEVA );
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
    public static void Delo_11c()
    {
        new Delo_11c( 100, '1' );
        new Delo_11c( 200, '2' );
    }


}//public class Pal extends KeyAdapter

