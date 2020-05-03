import rup.cesky.tvary.Barva;
import rup.cesky.tvary.AktivniPlatno;


/*******************************************************************************
 * Instance tridy Balon simuluji gumovy balon, ktery pada kolmo dolu
 * a odrazi se od spodniho okraje platna.
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
public class Balon 
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A METODY VRACEJICI INSTANCE VLASTNI TRIDY ====================

    /***************************************************************************
     * Implicitni konstruktor umiste balon implicitni velikosti a barvy
     * do leveho horniho rohu platna a necha jej spadnout.
     */
    public Balon()
    {
    }


    /***************************************************************************
     * Konstruktor vytvori balon zadane velikosti a barvy, umisti jej 
     * na zadanou pozici a necha jej odtud spadnout.
     *
     * @param x       x-ova souradnice pocatku, x>=0, x=0 ma levy okraj platna
     * @param y       y-ova souradnice pocatku, y>=0, y=0 ma horni okraj platna
     * @param prumer  Prumer vytvarene instance,  prumer > 0
     * @param barva   Barva vytvareneho ctverce
     */
    public Balon( int x, int y, int prumer, Barva barva )
    {
    }

    

//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
//== NOVE ZAVEDENE METODY INSTANCI =============================================
    

    /***************************************************************************
     * Premisti balon na zadanou pozici a necha jej spadnout.
     */
    public void presunNa( int x, int y )
    {
    }

    
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
    
    public static void test()
    {
    }
    
}//public class Sbl_Trida

