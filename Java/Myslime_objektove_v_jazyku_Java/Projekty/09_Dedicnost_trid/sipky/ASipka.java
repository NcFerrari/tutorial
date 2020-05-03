package sipky;

import rup.cesky.tvary.AktivniPlatno;
import rup.cesky.tvary.IKresleny;
import rup.cesky.tvary.Kreslitko;
import rup.cesky.tvary.Obdelnik;
import rup.cesky.tvary.Trojuhelnik;


/*******************************************************************************
 * Trida ASipka slouzi k ...
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
public abstract class ASipka implements IKresleny
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
    
    static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    
    
//== PROMENNE ATRIBUTY TRIDY ===================================================
    
    static int krok = AP.getKrok();

        
        
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
//== PROMENNE ATRIBUTY INSTANCI ================================================
    
    Trojuhelnik spicka;
    Obdelnik    telo;
    int xPole, yPole;
    
    

//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Implicitni konstruktor tridy Trida
     */
    public ASipka( int xPole, int yPole ) 
    {
        this.xPole = xPole;
        this.yPole = yPole;
    }

    

//== ABSTRAKTNI METODY =========================================================

    /***************************************************************************
     * Vrati sipku, ktera je na stejne pozici, pouze je otocena o 90\u00b0 vlevo.
     *
     * @return Sipka natocena do noveho smeru.
     */
    public abstract ASipka doleva();

    
    /***************************************************************************
     * Posune sipku na dalsi policko ve smeru, do ktereho je natocena.
     */
    public abstract void vpred();
    
    
    
//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================

    /***************************************************************************
     * Vrati vodorovnou souradnici sipky.
     *
     * @return  x-ova souradnice sipky
     */
    public int getXPole()
    {
        return xPole;
    }
    
    
    /***************************************************************************
     * Vrati svislou souradnici sipky.
     *
     * @return  y-ova souradnice sipky
     */
    public int getYPole()
    {
        return yPole;
    }
    
    

//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
//== NOVE ZAVEDENE METODY INSTANCI =============================================

    /***************************************************************************
     * Nakresli sipku zadanym kreslitkem.
     *
     * @param g Kreslitko (objekt typu Graphics2D), kterym se sipka nakresli.
     */
    public void nakresli( Kreslitko g )
    {
        spicka.nakresli( g );
        telo  .nakresli( g );
    }



//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}

