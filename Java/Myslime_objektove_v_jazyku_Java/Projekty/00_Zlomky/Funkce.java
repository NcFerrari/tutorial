/*******************************************************************************
 * Trida Funkce obsahuje pomocne staticke metody pro tridu Zlomek. Resi
 * vypocet nejmensiho spolecneho nasobku a nejvetsiho spolecneho delitele. 
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  30. brezen 2004, 23:17
 */
public final class Funkce
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================
    
    /***************************************************************************
     * Vrati nejvetsiho spolecneho delitele dvou zadanych cisel.
     * Vracene cislo je vzdy kladne nezavisle na znamenku parametru.
     *
     * @param i1   Prvni cislo
     * @param i2   Druhe cislo
     *
     * @return Nejvetsi spolecny delitel zadanych cisel
     */
    public static int nsd(int i1, int i2)
    {
        i1 = Math.abs( i1 );
        i2 = Math.abs( i2 );
        while( i2 > 0 )
        {
            int pom = i1 % i2;
            i1 = i2;
            i2 = pom;
        }
        return i1;
    }
    
    
    /***************************************************************************
     * Vrati nejmensi spolecny nasobek zadanych cisel.
     * Vracene cislo je vzdy kladne nezavisle na znamenku parametru.
     *
     * @param i1   Prvni cislo
     * @param i2   Druhe cislo
     *
     * @return Nejmensi spolecny nasobek zadanych cisel
     */
    public static int nsn(int i1, int i2)
    {
        if( (i1 == 0)  ||  (i2 == 0) )
            return 0;
        return  i2 * Math.abs(i1) / nsd(i1,i2);
    }
    

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================
    
    /***************************************************************************
     * Trida nema verejny konstruktor => neni mozne vytvaret jeji instance.
     */
    private Funkce() {}
    
    
//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
//== NOVE ZAVEDENE METODY INSTANCI =============================================
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}

