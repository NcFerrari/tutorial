package molekuly;

import rup.cesky.tvary.AktivniPlatno;

import java.util.Timer;
import java.util.TimerTask;

/*******************************************************************************
 * Trida AnimatorMolekul_13b definuje objekt, ktery zabezpeci
 * animaci molekul ulozenych ve statickem atributu <code>molekuly</code> 
 * tridy </code>Molekula_13b</code>.
 * Animator by mel spravne byt bud jedinacek, nebo alespon kontrolovat,
 * ze se druhy nespusti drive, nez prvni dobehne. 
 * Vzhledem k tomu, ze je urcen pouze pro testovaci ucely a bude jej
 * pouzivat pouze trida <code>Molekula_13b</code>, dopustime se maleho hrichu
 * a tyto kontroly do kodu nezahrneme. 
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
//==============================================================================

class AnimatorMolekul_13b extends TimerTask
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================

    /** AP od tridy Molekula_13d je nedosazitelne, protoze ta je dedi od 
     *  rodicovske tridy trida APosuvny, jez je deklarovala jako protected. */
    AktivniPlatno AP = AktivniPlatno.getPlatno();
    

//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Vytvori novy animator molekul, ktery bude s frekvenci zadanou ve tride 
     * Molekula_13b zadat moelkuly o aktulizaci jejich pozice 
     * a nasledne nechavat prekreslit platno.
     */     
    public AnimatorMolekul_13b()
    {
        new Timer().schedule( this, 0, 1000 / Molekula_13b.FREKVENCE );
    }

    

//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================

    /***************************************************************************
     * Metoda pozadovana tridou TimerTask. Bude spoustena casovacem
     * s pozadovanou frekvenci. Tato metoda ma na starosti vlastni animaci.
     */     
    public void run()
    {
        AP.nekresli();
            for( Molekula_13b m : Molekula_13b.molekuly )
            {
                m.popojed();
            }
        AP.vratKresli();
    }



//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
//== NOVE ZAVEDENE METODY INSTANCI =============================================
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}

