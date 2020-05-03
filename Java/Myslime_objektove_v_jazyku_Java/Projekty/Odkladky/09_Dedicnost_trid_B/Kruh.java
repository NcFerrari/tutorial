/*******************************************************************************
 * Trida pro praci s kruhem na virtualnim platne.
 * Kruh je definovan jako potomek elipsy,
 * pricemz pri nastavovani rozmeru nastavi mensi ze zadanych velikosti.
 * 
 * @author Rudolf Pecinovsky
 * @version 0.00.000,  0.0.2003
 */
public class Kruh extends Elipsa
{
//== KONSTANTNI ATRIBUTY TRIDY =================================================
//== PROMENNE ATRIBUTY TRIDY ===================================================
//== KONSTANTNI ATRIBUTY INSTANCI ==============================================
//== PROMENNE ATRIBUTY INSTANCI ================================================
//== PRISTUPOVE METODY VLASTNOSTI TRIDY ========================================
//== OSTATNI METODY TRIDY ======================================================

//##############################################################################
//== KONSTRUKTORY A METODY VRACEJICI INSTANCE VLASTNI TRIDY ====================
    
    /***************************************************************************
     * Vytvori novou instanci s implicitnimi rozmery, umistenim a barvou.
     * Instance bude umistena v levem hornim rohu platna 
     * a bude mit implicitni barvu, 
     * vysku a sirku 1 pole.
     */
    public Kruh()
    {
        super( 0, 0, AP.getKrok(), AP.getKrok() );
    }
    
    
    /***************************************************************************
     * Vytvori novou instanci se zadanou polohou a rozmery 
     * a implicitni barvou.
     *
     * @param x       x-ova souradnice pocatku, x>=0, x=0 ma levy okraj platna
     * @param y       y-ova souradnice pocatku, y>=0, y=0 ma horni okraj platna
     * @param prumer  Prumer vytvarene instance,  prumer > 0
     */
    public Kruh(int x, int y, int prumer)
    {
        super( x, y, prumer, prumer );
    }
    
    
    /***************************************************************************
     * Vytvori novou instanci se zadanou polohou a rozmery 
     * a implicitni barvou.
     *
     * @param pocatek   Pozice pocatku instance
     * @param rozmer    Rozmer instance
     */
    public Kruh(Pozice pocatek, Rozmer rozmer)
    {
        this( pocatek.x, pocatek.y, Math.min(rozmer.sirka, rozmer.vyska) );
    }


    /***************************************************************************
     * Vytvori novou instanci se zadanou polohou, rozmery a barvou.
     *
     * @param pocatek   Pozice pocatku instance
     * @param rozmer    Rozmer instance
     * @param barva     Barva instance
     */
    public Kruh(Pozice pocatek, Rozmer rozmer, Barva barva)
    {
        this( pocatek.x, pocatek.y, Math.min(rozmer.sirka, rozmer.vyska), barva );
    }


    /***************************************************************************
     * Vytvori novou instanci vyplnujici zadanou oblast 
     * a majici implicitni barvu.
     *
     * @param oblast   Oblast definujici pozici a rozmer instance
     */
    public Kruh(Oblast oblast)
    {
        this( oblast.x, oblast.y, Math.min(oblast.sirka, oblast.vyska) );
    }


    /***************************************************************************
     * Vytvori novou instanci vyplnujici zadanou oblast 
     * a majici zadanou barvu.
     *
     * @param oblast   Oblast definujici pozici a rozmer instance
     * @param barva    Barva instance
     */
    public Kruh(Oblast oblast, Barva barva)
    {
        this( oblast.x, oblast.y, Math.min(oblast.sirka, oblast.vyska), barva );
    }


    /***************************************************************************
     * Vytvori novou instanci se zadanymi rozmery, polohou a barvou.
     *
     * @param x       x-ova souradnice pocatku, x>=0, x=0 ma levy okraj platna
     * @param y       y-ova souradnice pocatku, y>=0, y=0 ma horni okraj platna
     * @param prumer  Prumer vytvarene instance,  prumer > 0
     * @param barva   Barva vytvareneho ctverce
     */
    public Kruh(int x, int y, int prumer, Barva barva)
    {
        super( x, y, prumer, prumer, barva );
    }
    
    
    
//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
    
    /***************************************************************************
     * Nastavi prumer kruhu jako mensi ze zadanych delek.
     * Prekryva prislusnou metodu rodickovske tridy tak,
     * aby upraveny obrazec "nevycnival" ze zadane oblasti.
     * 
     * @param sirka kandidat na prumer kruhu - sirka opsane elipsy
     * @param vyska kandidat na prumer kruhu - vyska opsane elipsy
     */    
    public void setRozmer(int sirka, int vyska)
    {
        int prumer = Math.min( sirka, vyska );
        super.setRozmer( prumer, prumer );
    }
    

    
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== OSTATNI PREKRYTE METODY RODICOVSKE TRIDY ==================================
//== OSTATNI METODY INSTANCI ===================================================
//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================
}//public class Kruh

