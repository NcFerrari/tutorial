import rup.cesky.spolecne.P;
import rup.cesky.tvary.Barva;
import rup.cesky.tvary.Kreslitko;
import rup.cesky.tvary.Kruh;


/*******************************************************************************
 * Trida Balon_12a simuluje pruzny padajici balon, ktery pada zrychlene dolu
 * a po dopadu se odrazi zmensenou rychlosti, takze o nejake dobe doskace.
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
public final class Balon_12c extends Kruh
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================

    /** Zmena rychlosti za jeden snimek. */
    private static final int IMPLICITNI_VELIKOST = 20;

    /** Zmena rychlosti za jeden snimek. */
    private static final Barva IMPLICITNI_BARVA = Barva.CERVENA;

    /** Gravitacni zrychleni. **/
    private static final double GRAVITACNI_ZRYCHLENI  = 400;

    /** Pocet prekresleni za sekundu. */
    private static final int FREKVENCE = 50;

    /** Cekani mezi snimky. */
    private static final int PERIODA = 1000 / FREKVENCE;

    /** Zmena rychlosti za jeden snimek. */
    private static final double SNIMKOVE_ZRYCHLENI =
                                    GRAVITACNI_ZRYCHLENI / FREKVENCE;

    /** Zmena rychlosti za jeden snimek. */
    private static final double UTLUM = 0.85;

    /** Zmena rychlosti za jeden snimek. */
    private static final double MINIMALNI_RYCHLOST = 50;



//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A METODY VRACEJICI INSTANCE VLASTNI TRIDY ====================

    /***************************************************************************
     * Implicitni konstruktor vytvori v levem hornim rohu aktivniho platna
     * balon o prumeru 25 a necha jej spadnout.
     */
    public Balon_12c()
    {
        this( 0, 0, IMPLICITNI_VELIKOST, IMPLICITNI_BARVA );
    }


    /***************************************************************************
     * Vytvori novy balon na zadane pozici a o zadanem prumeru
     * a necha jej spadnout.
     */
    public Balon_12c(int x, int y, int prumer, Barva barva)
    {
        super( x, y, prumer, barva );
        AP.pridej( this );
        spadni();
    }



//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
//== NOVE ZAVEDENE METODY INSTANCI =============================================

    /***************************************************************************
     * Presune balon do zadane pozice a necha jej odtud spadnout.
     */
    public void presunNa( int x, int y )
    {
        setPozice( x, y );  //Nastaveni pozice muzes sverit rodici
        spadni();           //Zacni padat
    }


    /***************************************************************************
     * Simuluje poskakovani balonu v gravitacnim poli.
     * Balon se po dopadu odrazi po dopadu se odrazi zmensenou rychlosti,
     * takze o nejake dobe doskace.
     */
    private void spadni()
    {
        double konecne_y = AP.getBVyska() - getVyska();
        double rychlost  = 0;
        double y = getY();

        do{
            while( y < konecne_y )
            {
                rychlost += SNIMKOVE_ZRYCHLENI;
                y += rychlost / FREKVENCE;
                //Rodicovska verze setPozice vyzaduje celociselne parametry -
                // aktualni svislou souradnici proto musime pretypovat
                setPozice( xPos, (int)y );
                P.cekej( PERIODA );
            }
            //setPozice( xPos, (int)konecne_y);
            y = konecne_y - 1;
//            System.out.print("Rychlost: " + rychlost );
            rychlost = -rychlost * UTLUM;
//            System.out.println(" - " + -rychlost );
        }while( -rychlost > MINIMALNI_RYCHLOST );
    }


//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================

    /***************************************************************************
     * Test vytvori implicitni balon a necha jej spadnout.
     * Pak vytvori druhy balon a po jeho dopadu presune prvni do nove pozice
     * a opet jej odtud necha spadnout.
     */
    public static void test()
    {
        AP.odstranVse();
        //Velikost aktivniho platna ne nastavena na obrazovku 1024\u00d7768
        AP.setKrokRozmer( 50, 3 , 15 );
        AP.setMrizka( true );

        Balon_12c b1 = new Balon_12c();
        Balon_12c b2 = new Balon_12c( 100, 100, 50, Barva.MODRA );
        b1.presunNa( 50, 50 );
    }


}//public class Sbl_Trida

