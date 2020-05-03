import rup.cesky.tvary.Text;

import java.awt.event.KeyEvent;


/*******************************************************************************
 * Trida Sbl_Trida slouzi k ...
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
public class Delo_11e extends Delo_11b
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
    
    private static final int KADENCE = 2;
    
    private static final int PRODLEVA = 1000 / KADENCE;
    
    private static final int KROK = 5;
    
    
    
//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A METODY VRACEJICI INSTANCE VLASTNI TRIDY ====================

    /***************************************************************************
     * 
     */
    public Delo_11e(int x, char spoust)
    {
        super( x, spoust );
    }


//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
    
    public void posun( int dx )
    {
        xPos += dx;
        podstavec.posunVpravo( dx );
        hlaven   .posunVpravo( dx );
        popisek  .posunVpravo( dx );
    }
    
    
    
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
    
    private long naposledy = 0;

    public void keyPressed( KeyEvent ke )
    {
        if( ke.getKeyChar() == spoust )
        {
            long nyni = ke.getWhen();
            if( (nyni - naposledy) > PRODLEVA )
            {
                if( naboju > 0)
                {
                    Strela strela = new Strela( xPos, VYSKA_PLATNA );
                    AP.pridejPod( this,  strela );
                    MP.presun( strela, xPos, 0, RYCHLOST_STRELY );
                    naposledy = nyni;
                    --naboju;
                    popisek = new Text( odpal + naboju, 
                                        popisek.getX(), popisek.getY() );
                }
            }
        }
        else if( ke.getKeyCode() == KeyEvent.VK_LEFT )
        {
            posun( -KROK );
        }
        else if( ke.getKeyCode() == KeyEvent.VK_RIGHT )
        {
            posun( KROK );
        }
    }

    public void keyPressed2( KeyEvent ke )
    {
        if( ke.getKeyChar() == spoust )
        {
            long nyni = ke.getWhen();
            if( (nyni - naposledy) > PRODLEVA )
            {
                if( naboju > 0)
                {
                    Strela strela = new Strela( xPos, VYSKA_PLATNA );
                    AP.pridejPod( this,  strela );
                    MP.presun( strela, xPos, 0, RYCHLOST_STRELY );
                    naposledy = nyni;
                    --naboju;
                    popisek = new Text( odpal + naboju, 
                                        popisek.getX(), popisek.getY() );
                }
            }
        }
        else switch( ke.getKeyCode() )
        {
            case KeyEvent.VK_LEFT:
                posun( -KROK );
                break;

            case KeyEvent.VK_RIGHT:
                posun( KROK );
                break;

        }//else switch( ke.getKeyCode() )
    }
    

//== NOVE ZAVEDENE METODY INSTANCI =============================================
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================

    /***************************************************************************
     * Testovaci metoda.
     * -
     * @param args Parametry prikazoveho radku se nepouzivaji.
     */
    public static void start_11e()
    {
        new Delo_11e( 100, '1' );
        new Delo_11e( 200, '2' );
    }


}//public class Pal extends KeyAdapter

