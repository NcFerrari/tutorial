package posuvne_sipky;

import rup.cesky.tvary.AktivniPlatno;
import rup.cesky.tvary.Barva;
import rup.cesky.tvary.Kreslitko;
import rup.cesky.tvary.Presouvac;
import rup.cesky.tvary.Smer8;

import rup.cesky.tvary.Trojuhelnik;
import rup.cesky.tvary.Obdelnik;


/*******************************************************************************
 * Trida SSipka definuje sipku otocenou na sever.
 *
 * @author     Rudolf Pecinovsky
 * @version    0.00.000,  0.0.2003
 */
public class SSipka implements ISipka
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
    
    private static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    private static final Presouvac pres = new Presouvac( 5 );
    
    
    
//== RETEZCOVE LITERALY ========================================================
//== ATRIBUTY TRIDY ============================================================
//== ATRIBUTY INSTANCI =========================================================
    
    private Trojuhelnik spicka;
    private Obdelnik    telo;
    
    

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Vytvori na zadanych souradnicich novou, na sever otocenou sipku
     * zadane barvy.
     *
     * @param x  x-ova polickova souradnice
     * @param y  y-ova polickova souradnice
     * @param barva  barva sipky
     */
    public SSipka(int x, int y, Barva barva)
    {
        int krok = AP.getKrok();
        int k2   = krok/2;
        spicka = new Trojuhelnik( x*krok, y*krok, krok, k2, barva, 
                                                            Smer8.SEVER );
        telo   = new Obdelnik( x*krok + krok/4, y*krok + k2, k2, k2, barva );
    }

    

//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================

    /***************************************************************************
     * Vrati vodorovnou souradnici sipky.
     *
     * @return  x-ova souradnice sipky
     */
    public int getX()
    {
        return spicka.getX();
    }
    
    
    /***************************************************************************
     * Vrati svislou souradnici sipky.
     *
     * @return  y-ova souradnice sipky
     */
    public int getY()
    {
        return spicka.getY();
    }
    
    
    /***************************************************************************
     * Nastavi vodorovnou a svislou souradnici sipky.
     *
     * @param x  Zadavana x-ova souradnice
     * @param y  Zadavana y-ova souradnice
     */
    public void setPozice(int x, int y)
    {
        int krok = AP.getKrok();
        spicka.setPozice( x,          y );
        telo  .setPozice( x + krok/4, y + krok/2 );
    }
    
    

//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================

    /***************************************************************************
     * Nakresli sipku zadanym kreslitkem.
     *
     * @param g Kreslitko (objekt typu Graphics2D), kterym se sipka nakresli.
     */
    public void nakresli(Kreslitko g)
    {
        spicka.nakresli( g );
        telo.nakresli( g );
    }


    
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
//== NOVE ZAVEDENE METODY INSTANCI =============================================

    /***************************************************************************
     * Vrati sipku, ktera je na stejne pozici, pouze je otocena o 90\u00b0 vlevo.
     *
     * @return Sipka natocena do noveho smeru.
     */
    public ISipka doleva()
    {
        int krok = AP.getKrok();
        return new ZSipka( getX()/krok, getY()/krok, spicka.getBarva() );
    }
    

    /***************************************************************************
     * Posune sipku na dalsi policko ve smeru, do ktereho je natocena.
     */
    public void vpred()
    {
        pres.presunNa( this, getX(),  getY()-AP.getKrok() );
        AP.odstran( this );  //Presouvac ji nasadil, odstranit se musi sama
    }
    
    
    
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}

