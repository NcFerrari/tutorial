package priklady;

import rup.cesky.tvary.AktivniPlatno;
import rup.cesky.tvary.Barva;
import rup.cesky.tvary.IPosuvny;
import rup.cesky.tvary.Kreslitko;
import rup.cesky.tvary.Presouvac;
import rup.cesky.tvary.Obdelnik;


/*******************************************************************************
 * Trida Vytah simuluje vytah vozici pasazery
 *
 * @author    Rudolf Pecinovsky
 * @version   0.00.000,  0.0.2003
 */
public class Vytah_8 implements IPosuvny
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
    
    /** Aktivni platno, ktere dohlizi na spravne vykresleni instance. */
    private static final AktivniPlatno AP = AktivniPlatno.getPlatno();
    
    
    
//== PROMENNE ATRIBUTY TRIDY ===================================================

    /** Pocet dosud vytvorenych instanci. */
    private static int pocet = 0;

    

//== KONSTANTNI ATRIBUTY INSTANCI ==============================================

    /** Poradi vytvoreni dane instance v ramci tridy. */
    private final int poradi = ++pocet;

    /** Sloupec platna, v nemz se vytah pohybuje. */
    private final int sloupec;
    
    /** Barva kabiny. */
    private final Barva barva;
    
    /** Vytah pouzije pro vsechny posuny jednoho soukromeho presouvace. */
    private final Presouvac presouvac;
    
    
    
//== PROMENNE ATRIBUTY INSTANCI ================================================
    
    /** Patro, v nemz se vytah prave nachazi. */
    private int patro;
    
    private Obdelnik kabina;
    
    private IPosuvny pasazer;

    
    
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Konstruktor definujici ve kterem sloupci bude vytah jezdit, 
     * jakou bude jezdit rychlosti a jakou bude mit barvu.
     * 
     * @param sloupec  Sloupec aktivniho platna, v nemz bude vytah jezdit.
     * @param rychlost Rychlost nastavena presouvaci, ktery bude mit dany vytah
     *                 na starosti.
     * @param barva    Barva vytahu.          
     */
    public Vytah_8(int sloupec, int rychlost, Barva barva)
    {
        this.sloupec = sloupec;
        this.presouvac = new Presouvac( rychlost );
        this.barva = barva;
        this.patro = 0;
        
        int krok = AP.getKrok();
        int x = sloupec * krok;
        int y = (AP.getVyska()-1) * krok;
        
        this.kabina = new Obdelnik( x, y, krok, krok, barva );
        
        AP.pridej( this );
    }


    /***************************************************************************
     * Konstruktor definujici ve kterem sloupci bude vytah jezdit, 
     * jakou bude jezdit rychlosti a jakou bude mit barvu.
     * 
     * @param sloupec  Sloupec aktivniho platna, v nemz bude vytah jezdit.
     * @param rychlost Rychlost nastavena presouvaci, ktery bude mit dany vytah
     *                 na starosti.
     * @param barva    Barva vytahu.          
     */
    public Vytah_8(int sloupec)
    {
        this( sloupec, 2, Barva.CERNA );
    }

    

//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================


    /***************************************************************************
     * Vrati x-ovou souradnici pozice instance.
     *
     * @return  x-ova souradnice.
     */
    public int getX() 
    {
        return kabina.getX();
    }    

    
    /***************************************************************************
     * Vrati y-ovou souradnici pozice instance.
     *
     * @return  y-ova souradnice.
     */
    public int getY() 
    {
        return kabina.getY();
    }

    
    /***************************************************************************
     * Nastavi novou pozici instance.
     *
     * @param x   Nova x-ova pozice instance
     * @param y   Nova y-ova pozice instance
     */
    public void setPozice(int x, int y) 
    {
        kabina. setPozice( x, y );
    }
    
    
    
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
    
    /***************************************************************************
     * Za pomoci dodaneho kreslitka vykresli obraz sve instance
     * na animacni platno.
     *  
     * @param kreslitko   Kreslitko, kterym se instance nakresli na platno.     
     */
    public void nakresli(Kreslitko kreslitko) 
    {
        kabina .nakresli( kreslitko );
    }
    
    
    
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================

    /***************************************************************************
     * Prevede instanci na retezec, v nemz bude uvedeno poradove cislo
     * vytahu, sloupec, v nemz jezdi a patro, v nemz se prave nachazi.
     *
     * @return Retezcova reprezentace dane instance.
     */
    public String toString()
    {
        return "Vytah_" + poradi + ": sloupec=" + sloupec + ", patro=" + patro;
    }



//== NOVE ZAVEDENE METODY INSTANCI =============================================
     
    /***************************************************************************
     * Prijede di patra, ve kterem se nachazi pasazer.
     * odveze jej do pozadovaneho patra; pasazer zustava ve vytahu.
     * 
     * @param pasazer   Pasazer, do jehoz radku je trebaq prijet.
     */
    public void prijedK( IPosuvny pasazer )
    {
        int patro = AP.getVyska() - pasazer.getY()/AP.getKrok() - 1;
        doPatra( patro );
    }
    
   
    /***************************************************************************
     * Presune zadaneho pasazera z jeho vychozi pozice do vytahu.
     * V zajmu realnosti graficke simulace by se mel pasazer vejit do 
     * jednoho policka aktivniho platna.          
     *
     * @param pasazer   Gemetricky tvar, ktery bude zastupovat pasazera.
     */
    public void nastup( IPosuvny pasazer )
    {
        this.pasazer = pasazer;
        AP.pridejPod( this, pasazer );
        presouvac.presunNa( pasazer, getX(), getY() );
        AP.odstran( pasazer );
    }
    
   
    /***************************************************************************
     * Odjede s vytahem do zadaneho patra;
     * je-li nastoupeny pasazer, odjede i s nim.
     *
     * @param patro   Poradove cislo ciloveho patra (prizemi ma 0).
     */
    public void doPatra( int patro )
    {
        presouvac.presunO( this, 0, (this.patro - patro)*AP.getKrok() );
        this.patro = patro;
    }
    
    
    /***************************************************************************
     * Presune pasazera vytahu na sousedni policko vpravo vedle vytahu.
     */
    public void vystupVpravo()
    {
        vystup( AP.getKrok() );
    }
    
    
    /***************************************************************************
     * Presune pasazera vytahu na sousedni policko vlevo vedle vytahu.
     */
    public void vystupVlevo()
    {
        vystup( -AP.getKrok() );
    }
    
     
    /***************************************************************************
     * Privola do pasazerova patra vytah, necha pasazera nastoupit,
     * odveze jej do pozadovaneho patra a tam jej necha vystoupit doprava.
     * 
     * @param pasazer   Gemetricky tvar, ktery bude zastupovat pasazera.
     * @param doPatra   Poradove cislo ciloveho patra (prizemi ma 0).
     */
    public void odvezVpravo( IPosuvny pasazer, int doPatra )
    {
        odvez( pasazer, doPatra );
        vystupVpravo();
    }   
    
     
    /***************************************************************************
     * Privola do pasazerova patra vytah, necha pasazera nastoupit,
     * odveze jej do pozadovaneho patra a tam jej necha vystoupit doleva.
     * 
     * @param pasazer   Gemetricky tvar, ktery bude zastupovat pasazera.
     * @param doPatra   Poradove cislo ciloveho patra (prizemi ma 0).
     */
    public void odvezVlevo( IPosuvny pasazer, int doPatra )
    {
        odvez( pasazer, doPatra );
        vystupVlevo();
    }   
    
    
    
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
    
    /***************************************************************************
     * Presune pasazera vytahu na sousedni policko vlevo vedle vytahu.
     */
    private void vystup( int posun )
    {
        int krok = AP.getKrok();
        pasazer.setPozice( getX(), getY() );
	    AP.pridejPod( this, this.pasazer );
        presouvac.presunO( pasazer, posun,  0 );
        pasazer = null;
    }
    
     
    /***************************************************************************
     * Privola do pasazerova patra vytah, necha pasazera nastoupit,
     * odveze jej do pozadovaneho patra; pasazer zustava ve vytahu.
     * 
     * @param pasazer   Gemetricky tvar, ktery bude zastupovat pasazera.
     * @param doPatra   Poradove cislo ciloveho patra (prizemi ma 0).
     */
    private void odvez( IPosuvny pasazer, int doPatra )
    {
        prijedK( pasazer );
        nastup( pasazer );
        doPatra( doPatra );
    }
    


//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}

