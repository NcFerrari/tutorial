import rup.cesky.tvary.AktivniPlatno;
import rup.cesky.tvary.Multipresouvac;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/*******************************************************************************
 * Trida Delo_0 demonstruje moznosti reakce na udalost klavesnice.
 * Tstovaci metoda vytvori dva palposty a po stisku zadane klavesy
 * se z daneho palpostu vystreli kolmovzhuru strela.
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
public class Delo_11a extends KeyAdapter
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
    
    /* Aplikacni okno, v nemz se vsechno odehrava. */
    protected static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    /* Spolecny mulitpresouvac vsech pohyblivych predmetu ve hre. */
    protected static final Multipresouvac MP = Multipresouvac.getInstance();
    
    protected static final int   RYCHLOST_STRELY    = 200;
    
   
    
//== PROMENNE ATRIBUTY TRIDY ===================================================
    
    protected static int VYSKA_PLATNA = 0;
    
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
    
    protected final int      xPos;
    protected final char     spoust;
    
    
    
//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A METODY VRACEJICI INSTANCE VLASTNI TRIDY ====================

    /***************************************************************************
     * Implicitni konstruktor tridy Trida
     */
    public Delo_11a(int x, char spoust)
    {
        this.xPos   = x;
        this.spoust = spoust;
        AP.prihlasKlavesnici( this );
    }

    

//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
    
    public void keyPressed( KeyEvent ke )
    {
        if( ke.getKeyChar() == spoust )
        {
            Strela strela = new Strela( xPos, AP.getVyska()*AP.getKrok() );
            MP.presun( strela, xPos, 0, RYCHLOST_STRELY );
        }
    }

//== NOVE ZAVEDENE METODY INSTANCI =============================================
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================

    public static void start_11a()
    {
        new Delo_11a( 100, 'a' );
        new Delo_11a( 200, 's' );
    }
    

}//public class Delo_1 extends KeyAdapter

