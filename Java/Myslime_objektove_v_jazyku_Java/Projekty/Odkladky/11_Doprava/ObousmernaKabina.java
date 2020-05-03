import rup.cesky.spolecne.P;
import rup.cesky.tvary.Barva;
import rup.cesky.tvary.AktivniPlatno;
import rup.cesky.tvary.Multipresouvac;


/*******************************************************************************
 * Instance tridy ObousmernaKabina predstavuji kabinky pohybujici se 
 * po linkach smerem zadanym pri jejich vytvoreni.
 *
 * @author
 * @version
 */
public class ObousmernaKabina extends Kabina_11a
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
//== PROMENNE ATRIBUTY INSTANCI ================================================

    private boolean dopredu;



//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A METODY VRACEJICI INSTANCE VLASTNI TRIDY ====================

    /***************************************************************************
     * Vytvori kruhovou kabinu, ktera se bude pohybovat zadanou rychlosti
     * po zadane lince.
     *
     * @param linka     Linka, po ktere se kabina pohybuje.
     * @param dopredu   Pohybuje-li se ze stanice k nasledujici stanici.
     */
    protected ObousmernaKabina(Linka linka, boolean dopredu)
    {
        super( linka );
        /*# Telo konstruktoru je treba dotvorit. */
    }


    /***************************************************************************
     * Vytvori kruhovou kabinu, ktera se bude pohybovat zadanou rychlosti
     * po zadane lince.
     * 
     * @param linka    Linka, po ktere se kabina pohybuje.
     */
    public static ObousmernaKabina getInstance( Linka linka, boolean dopredu )
    {
        ObousmernaKabina kabina = new ObousmernaKabina( linka, dopredu );
        kabina.presunuto();
        return kabina;
    }


//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
//== NOVE ZAVEDENE METODY INSTANCI =============================================

    /***************************************************************************
     * Metoda vyzadovana rozhranim IMultiposuvny: definuje akci,
     * ktera se ma provest v okamziku,
     * kdy je objekt doveden do pozadovane cilove pozicie.
     *
     * @param mp   Multipresouvac, ktery kabinku dovedl do cile.
     *             Ten bude pravdepodobne pozadan, aby kabinku dovezl zase dal
     *             a v pripade dorazeni do cilove stanice
     */
    public void presunuto()
    {
        /*# Doplnit telo. */
    }



//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}//public class Kabina extends Kruh implements IMultiposuvny

