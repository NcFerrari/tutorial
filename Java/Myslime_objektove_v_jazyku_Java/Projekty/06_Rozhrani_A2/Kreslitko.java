import java.awt.Font;
import java.awt.Graphics2D;


/*******************************************************************************
 * Trida Kreslitko slouzi k ...
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
public class Kreslitko
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
    
    private Graphics2D g;
    
    
    
//== PROMENNE ATRIBUTY INSTANCI ================================================
    
    private Barva barvaPozadi;
    
    
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Implicitni konstruktor tridy Trida
     */
    public Kreslitko( java.awt.Graphics2D g )
    {
        this.g = g;
    }

    

//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================

    /***************************************************************************
     * Implicitni konstruktor tridy Trida
     */
    public void setFont( Font font )
    {
        g.setFont( font );
    }


    /***************************************************************************
     * Implicitni konstruktor tridy Trida
     */
    public void setPozadi( Barva barva )
    {
        g.setBackground( barva.getColor() );
    }

    

//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
//== NOVE ZAVEDENE METODY INSTANCI =============================================

    /***************************************************************************
     * Implicitni konstruktor tridy Trida
     */
    public void kresliOval( int x, int y, int sirka, int vyska, Barva barva )
    {
        g.setColor( barva.getColor() );
        g.drawOval( x, y, sirka, vyska );
    }


    /***************************************************************************
     * Implicitni konstruktor tridy Trida
     */
    public void vyplnOval( int x, int y, int sirka, int vyska, Barva barva )
    {
        g.setColor( barva.getColor() );
        g.fillOval( x, y, sirka, vyska );
    }


    /***************************************************************************
     * Implicitni konstruktor tridy Trida
     */
    public void kresliRam( int x, int y, int sirka, int vyska, Barva barva )
    {
        g.setColor( barva.getColor() );
        g.drawRect( x, y, sirka, vyska );
    }


    /***************************************************************************
     * Implicitni konstruktor tridy Trida
     */
    public void vyplnRam( int x, int y, int sirka, int vyska, Barva barva )
    {
        g.setColor( barva.getColor() );
        g.fillRect( x, y, sirka, vyska );
    }


    /***************************************************************************
     * Implicitni konstruktor tridy Trida
     */
    public void kresliPolygon( int[] x, int[] y, Barva barva )
    {
        g.setColor( barva.getColor() );
        g.drawPolygon( x, y, x.length );
    }


    /***************************************************************************
     * Implicitni konstruktor tridy Trida
     */
    public void vyplnPolygon( int[] x, int[] y, Barva barva )
    {
        g.setColor( barva.getColor() );
        g.fillPolygon( x, y, x.length );
    }


    /***************************************************************************
     * Implicitni konstruktor tridy Trida
     */
    public void kresliCaru( int x1, int y1, int x2, int y2, Barva barva )
    {
        g.setColor( barva.getColor() );
        g.drawLine( x1, y1, x2, y2 );
    }


    /***************************************************************************
     * Implicitni konstruktor tridy Trida
     */
    public void kresliText( String text, int x, int y, Barva barva )
    {
        g.setColor( barva.getColor() );
        g.drawString( text, x, y );
    }

    

//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}

