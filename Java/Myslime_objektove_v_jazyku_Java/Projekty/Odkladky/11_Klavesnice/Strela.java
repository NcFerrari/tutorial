import rup.cesky.tvary.AktivniPlatno;
import rup.cesky.tvary.IMultiposuvny;
import rup.cesky.tvary.Kruh;
import rup.cesky.tvary.Multipresouvac;


/*******************************************************************************
 * Trida Sbl_Trida slouzi k ...
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
public class Strela extends Kruh implements IMultiposuvny
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
    
    /* Aplikacni okno, v nemz se vsechno odehrava. */
    private static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    /** Vsechny strely budou mit stejny prumer. */
    public static final int PRUMER = 10;
    
    
    
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
    public Strela( int x, int y )
    {
        super( x, y, PRUMER );
    }

    

//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================

    public void presunuto()
    {
        AP.odstran( this );
    }    
    
    
    
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
//== NOVE ZAVEDENE METODY INSTANCI =============================================
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}

