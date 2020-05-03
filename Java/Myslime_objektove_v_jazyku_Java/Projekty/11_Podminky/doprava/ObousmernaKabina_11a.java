package doprava;

import rup.cesky.spolecne.P;
import rup.cesky.tvary.Barva;
import rup.cesky.tvary.AktivniPlatno;
import rup.cesky.tvary.Multipresouvac;


/*******************************************************************************
 * Instance tridy ObousmernaKabina_11a predstavuji kabinky pohybujici se po linkach.
 *
 * @author
 * @version
 */
public class ObousmernaKabina_11a extends Kabina_11a
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
//== PROMENNE ATRIBUTY INSTANCI ================================================

    private Smer smer;



//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Vytvori kruhovou kabinu, ktera se bude pohybovat zadanou rychlosti
     * po zadane lince.
     *
     * @param linka     Linka, po ktere se kabina pohybuje.
     * @param dopredu   Pohybuje-li se ze stanice k nasledujici stanici.
     */
    public ObousmernaKabina_11a( Linka linka, Smer smer )
    {
        //Vytvori novou kabinu a rozjede ji k nisledujici zastavce
        super( linka );
        this.smer = smer;
        AP.pridej( this );
    }


    /***************************************************************************
     * Vytvori kruhovou kabinu, ktera se bude pohybovat zadanou rychlosti
     * po zadane lince.
     * 
     * @param linka    Linka, po ktere se kabina pohybuje.
     */
    public static ObousmernaKabina_11a getInstance( 
                                       Linka linka, Smer smer )
    {
        ObousmernaKabina_11a kabina = new ObousmernaKabina_11a( linka, smer );
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
        if( smer == Smer.VPRED )
            dalsi = dalsi.getNasledujici();
        else
            dalsi = dalsi.getPredchozi();

        P.cekej( linka.getCekani() );

        //Nechame kabinu presunout na dalsi zastavku
        Multipresouvac mp = Multipresouvac.getInstance();
        mp.presun( this,  dalsi.getPozice(),  linka.getRychlost() );
    }



//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}

