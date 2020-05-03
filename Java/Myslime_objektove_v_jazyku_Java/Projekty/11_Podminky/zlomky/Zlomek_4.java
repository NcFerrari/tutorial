package zlomky;

/*******************************************************************************
 * Trida Zlomek_4 definuje zlomky a potrebne operace, aby se zlomky bylo
 * mozno pocitat obdobne jako s cisly. Definuje proto operace pro scitani,
 * odcitani, nasobeni a deleni dvou zlomku a zlomku a cisla, 
 * jakoz i operace pro prevod celeho cisla na zlomek a zlomku na cislo.
 *
 * @author     Rudolf Pecinovsky
 * @version    0.00.000,  0.0.2003
 */
public class Zlomek_4
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================

    private final int citatel;
    private final int jmenovatel;
    

//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A TOVARNI METODY =============================================

    /***************************************************************************
     * Vytvori novou instanci tridy Zlomek s hodnotou danou citatelem a
     * jmenovatelem dodanymi jako parametry. Hodnota citatele a jmenovatele 
     * ulozena v atributech vsak bude jiz zkracena a jmenovatel bude kladny.
     * 
     * @param c  Zadavany citatel
     * @param j  Zadavany jmenovatel
     */
    public Zlomek_4(int c, int j)
    {
        int delitel = Funkce.nsd( c, j );
        if( j < 0 )
        {
            c = -c;
            j = -j;
        }
        citatel    = c / delitel;
        jmenovatel = j / delitel;
    }
    
    
    /***************************************************************************
     * Kopirovaci konstruktor -- vytvori novou instanci 
     * se stejnymi hodnotami atributu, jake ma zlomek zadany jako parametr.
     *
     * @param z  Kopirovany zlomek
     */
    public Zlomek_4(Zlomek_4 z)
    {
        citatel    = z.citatel;
        jmenovatel = z.jmenovatel;
    }
    
    
    /***************************************************************************
     * Vytvori zlomek, ktery bude mit hodnotu cisla zadaneho jako parametr.
     *
     * @param cislo  Hodnota vytvareneho zlomku
     */
    public Zlomek_4(int cislo)
    {
        citatel    = cislo;
        jmenovatel = 1;
    }
    

    
//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================

    /***************************************************************************
     * Vrati hodnotu citatele.
     * 
     * @return hodnota citatele              
     */     
    public int getCitatel()
    {
        return citatel;
    }


    /***************************************************************************
     * Vrati hodnotu jmenovatele.
     * 
     * @return hodnota jmenovatele              
     */     
    public int getJmenovatel()
    {
        return jmenovatel;
    }



//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================
    
    /***************************************************************************
     * Vrati retezec reprezentujici zlomek ve tvaru
     * [citatel/jmenovatel]  -  napr. [7/2]
     *
     * @return Textova reprezentace zlomku.
     */
public boolean equals( Object o )
{
    if( o instanceof Zlomek )
    {
        Zlomek_4 z = (Zlomek_4)o;
        return (citatel    == z.citatel)   &&  
               (jmenovatel == z.jmenovatel);
    }
    else
        return false;
}
    
    
    /***************************************************************************
     * Vrati retezec reprezentujici zlomek ve tvaru
     * [citatel/jmenovatel]  -  napr. [7/2]
     *
     * @return Textova reprezentace zlomku.
     */
    public String toString()
    {
        return "[" + citatel + "/" + jmenovatel + "]";
    }
    
    
    
//== NOVE ZAVEDENE METODY INSTANCI =============================================
    
    /***************************************************************************
     * Vrati hodnotu zlomku oriznutou na cele cislo.
     *
     * @return  Hodnota zlomku oriznuta na cele cislo.
     */
    public int intValue()
    {
        return citatel / jmenovatel;
    }
    
    
    /***************************************************************************
     * Vrati hodnotu zlomku prevedenou na realne cislo typu double.
     *
     * @return  Hodnota zlomku prevedena na realne cislo typu double.
     */
    public double doubleValue()
    {
        return (double)citatel / jmenovatel;
    }

        
    /***************************************************************************
     * Pripocte ke zlomku zlomek zadany jako parametr 
     * a vrati zlomek, ktery je jejich souctem. 
     *
     * @param  z  Pricitany zlomek.
     *
     * @return Zlomek_4, ktrery je souctem obou zlomku.
     */
    public Zlomek_4 plus(Zlomek_4 z)
    {
        //int nasobek = Funkce.nsn( this.jmenovatel, z.jmenovatel );
        return new Zlomek_4( citatel*z.jmenovatel + z.citatel*jmenovatel, 
                           jmenovatel*z.jmenovatel );
    }
    
    
    /***************************************************************************
     * Pripocte ke zlomku cele cislo zadane jako parametr 
     * a vrati zlomek, ktery je jejich souctem. 
     *
     * @param  cislo   Pricitane cislo.
     *
     * @return Zlomek_4, ktrery je souctem obou hodnot.
     */
    public Zlomek_4 plus(int cislo)
    {
        return new Zlomek_4( citatel + cislo*jmenovatel, jmenovatel );
    }
    
    
    /***************************************************************************
     * Odecte od zlomku zlomek zadany jako parametr 
     * a vrati zlomek, ktery je jejich rozdilem. 
     *
     * @param  z  Odecitany zlomek.
     *
     * @return Zlomek_4, ktrery je rozdilem obou zlomku.
     */
    public Zlomek_4 minus(Zlomek_4 z)
    {
        //int nasobek = Funkce.nsn( this.jmenovatel, z.jmenovatel );
        return new Zlomek_4( citatel*z.jmenovatel - z.citatel*jmenovatel, 
                           jmenovatel*z.jmenovatel );
    }
    
    
    /***************************************************************************
     * Odecte od zlomku cele cislo zadane jako parametr 
     * a vrati zlomek, ktery je jejich rozdilem. 
     *
     * @param  cislo   Odecitane cislo.
     *
     * @return Zlomek_4, ktrery je rozdilem obou hodnot.
     */
    public Zlomek_4 minus(int cislo)
    {
        return new Zlomek_4( citatel - cislo*jmenovatel, jmenovatel );
    }
    
    
    /***************************************************************************
     * Odecte zlomek od celeho cisla zadaneho jako parametr 
     * a vrati zlomek, ktery je jejich rozdilem. 
     *
     * @param  cislo   Cislo, od ktereho se zlomek odecte.
     *
     * @return Zlomek_4, ktrery je rozdilem obou hodnot.
     */
    public Zlomek_4 odectiOd(int cislo)
    {
        return new Zlomek_4( cislo*jmenovatel - citatel, jmenovatel );
    }
    
    
    /***************************************************************************
     * Vynasobi zlomek zlomkem zadanym jako parametr 
     * a vrati zlomek, ktery je jejich soucinem. 
     *
     * @param  z  Zlomek_4, kterym se nasobi.
     *
     * @return Zlomek_4, ktrery je soucinem obou zlomku.
     */
    public Zlomek_4 krat(Zlomek_4 z)
    {
        return new Zlomek_4( citatel * z.citatel,  jmenovatel * z.jmenovatel );
    }
    
    
    /***************************************************************************
     * Vynasobi zlomek celym cislem zadanym jako parametr 
     * a vrati zlomek, ktery je jejich soucinem. 
     *
     * @param  cislo  Cislo, kterym se nasobi.
     *
     * @return Zlomek_4, ktrery je soucinem obou hodnot.
     */
    public Zlomek_4 krat(int cislo)
    {
        return new Zlomek_4( citatel * cislo,  jmenovatel );
    }
    
    
    /***************************************************************************
     * Vydeli zlomek zlomkem zadanym jako parametr 
     * a vrati zlomek, ktery je jejich podilem. 
     *
     * @param  z  Zlomek_4, kterym se deli.
     *
     * @return Zlomek_4, ktrery je podilem obou zlomku.
     */
    public Zlomek_4 deleno(Zlomek_4 z)
    {
        return new Zlomek_4( citatel * z.jmenovatel,  jmenovatel * z.citatel );
    }
    
    
    
    /***************************************************************************
     * Vydeli zlomek celym cislem zadanym jako parametr 
     * a vrati zlomek, ktery je jejich podilem. 
     *
     * @param  z  Cislo, kterym se deli.
     *
     * @return Zlomek_4, ktrery je podilem obou hodnot.
     */
    public Zlomek_4 deleno(int cislo)
    {
        return new Zlomek_4( citatel,  jmenovatel * cislo );
    }
    
    
    /***************************************************************************
     * Vydeli zlomkem cele cislo zadane jako parametr 
     * a vrati zlomek, ktery je jejich podilem. 
     *
     * @param  z  Cislo, ktere se deli.
     *
     * @return Zlomek_4, ktrery je podilem obou hodnot.
     */
    public Zlomek_4 delCislo(int cislo)
    {
        return new Zlomek_4( jmenovatel * cislo,  citatel );
    }
    

    
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}

