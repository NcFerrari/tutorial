import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import rup.cesky.spolecne.P;

import rup.cesky.tvary.Kruh;


/*******************************************************************************
 * Trida Molekula je prazdnou tridou pripravenou k vytvoreni simulace 
 * Brownova pohybu molekul. Obsahuje pouze definici atributu tridy
 * a prazdne definice metod, o kterych se hovori v textu. 
 * Vse ostatni musite definovat sami.
 *
 * @author    ???
 * @version   0.00.000,  0.0.2004
 */
public class Molekula extends Kruh 
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================

    /** Spolecny prumer vsech moelkul. */
    private static final int PRUMER = 50;

    /** Maximalni povolena rychlost molekuly, 
     * tj. kolik bodu muze molekula urazit za sekundu. */
    private static int maxR = 300 ;
    
    /** Mnozina vsech dosud vygenerovanych molekul. */
    private static final Set<Molekula> molekuly = 
						new LinkedHashSet<Molekula>();
    
    /** Spolecny generator nahodnych cisel. */
    private static final Random rnd = new Random();

    
    
//== PROMENNE ATRIBUTY TRIDY ===================================================

    /** Pocet dosud vytvorenych instanci. */
    private static int pocet = 0;
    
    /** Maximalni povolene souradnice molekuly. */
    private static int maxX;
    private static int maxY;
    
    static { nastavMaxima(); }
    


//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================
    
    /***************************************************************************
     * Nastavi maximalni povolene souradnice molekul 
     * podle aktualni velikosti aktivniho platna.
     */
    public static void nastavMaxima()
    {
    }
    

    /***************************************************************************
     * Vytvori sadu nahodne umistenych molekul. 
     */
    public static void novaSada()
    {
    }


    /***************************************************************************
     * Najde nahodne umisteni dalsi molekuly tak, aby se neprekryvala s zadnou
     * z dosud vytvorenych molekul, a necha molekulu na teto pozici vytvorit.
     */
    public static void dalsi()
    {
    }



//##############################################################################
//== KONSTRUKTORY A METODY VRACEJICI INSTANCE VLASTNI TRIDY ====================

    /***************************************************************************
     * 
     */
    public Molekula(int x, int y)
    {
        super( x, y, PRUMER );
    }

    

//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
//== NOVE ZAVEDENE METODY INSTANCI =============================================
    
    public void popojed()
    {
    }
    
    
    
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}//public class Sbl_Trida


