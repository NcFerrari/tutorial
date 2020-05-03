/*******************************************************************************
 * Trida Obdobi slouzi k ...
 *
 * @author    jmeno autora
 * @version   0.00.000,  0.0.2003
 */
public enum Obdobi_5c
{
//== HODNOTY VYCTOVEHO TYPU ====================================================

    JARO("puci"), LETO("zraje"), PODZIM("plodi"), ZIMA("spi");
    
//== KONSTANTNI ATRIBUTY TRIDY =================================================
//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================

    private final String cinnost;
    
//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Bezparametricky konstruktor ...
     */
    private Obdobi_5c( String cinnost )
    {
        this.cinnost = cinnost;
    }


//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== NOVE ZAVEDENE METODY INSTANCI =============================================

    public String zprava()
    {
        return "Je " + name().toLowerCase() + ", priroda " + cinnost + ".";
    }
    
    
    
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}


