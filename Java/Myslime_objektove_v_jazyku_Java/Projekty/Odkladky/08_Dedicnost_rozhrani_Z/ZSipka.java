/*******************************************************************************
 * Trida ZSipka definuje sipku otocenou na zapad.
 *
 * @author     Rudolf Pecinovsky
 * @version    0.00.000,  0.0.2003
 */
public class ZSipka implements ISipka
{
//== VEREJNE KONSTANTY =========================================================
//== SOUKROME KONSTANTY ========================================================
    
    private static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    
    
//== RETEZCOVE LITERALY ========================================================
//== ATRIBUTY TRIDY ============================================================
//== ATRIBUTY INSTANCI =========================================================
    
    private Trojuhelnik spicka;
    private Obdelnik    telo;
    
    
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================
//== KONSTRUKTORY A METODY VRACEJICI INSTANCE VLASTNI TRIDY ====================
    

    /***************************************************************************
     * Vytvori na zadanych souradnicich novou, na zapad otocenou sipku
     * zadane barvy.
     *
     * @param x  x-ova polickova souradnice
     * @param y  y-ova polickova souradnice
     * @param barva  barva sipky
     */
    public ZSipka(int x, int y, Barva barva)
    {
        int krok = AP.getKrok();
        int k2   = krok/2;
        spicka = new Trojuhelnik( x*krok, y*krok, k2, krok, barva, 
                                  Smer8.ZAPAD );
        telo   = new Obdelnik(  x*krok + k2, y*krok + krok/4, k2, k2, barva );
    }//public ZSipka( int x, int y )
    

    
//== ABSTRAKTNI METODY =========================================================
//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================


    /***************************************************************************
     * Vrati vodorovnou souradnici sipky.
     *
     * @return  x-ova souradnice sipky
     */
    public int getX()
    {
        return spicka.getX();
    }//public int getX()
    
    
    /***************************************************************************
     * Vrati svislou souradnici sipky.
     *
     * @return  y-ova souradnice sipky
     */
    public int getY()
    {
        return spicka.getY();
    }//public int getY()
    
    
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
        telo  .setPozice( x + krok/2, y + krok/4 );
    }//public void setPozice(int x, int y)
    
    

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
    }//public void nakresli(Kreslitko g)


    /***************************************************************************
     * Vrati sipku, ktera je na stejne pozici, pouze je otocena o 90\u00b0 vlevo.
     *
     * @return Sipka natocena do noveho smeru.
     */
    public ISipka doleva()
    {
        int krok = AP.getKrok();
        return new JSipka( getX()/krok, getY()/krok, spicka.getBarva() );
    }//public ISipka vlevoVbok()
    

    /***************************************************************************
     * Posune sipku na dalsi policko ve smeru, do ktereho je natocena.
     */
    public void vpred()
    {
        setPozice( getX()-AP.getKrok(),  getY() );
    }//public void vpred()
    
    
    
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
//== NOVE ZAVEDENE METODY INSTANCI =============================================
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}//public class ZSipka

