package rup.cesky.tvary;

/*******************************************************************************
 * Rozhrani INafukovaci definuje povinou sadu metod, jez musi byt poskytovany 
 * objekty, ktere ma byt instance tridy Kompresor schopna "nafouknout".
 *
 * @author     Rudolf Pecinovsky
 * @version    1.00, 3.2.2003
 */
public interface INafukovaci 
{
//== VEREJNE KONSTANTY =========================================================
//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
//== OSTATNI METODY K IMPLEMENTACI =============================================

    /***************************************************************************
     * Vrati aktualni sirku nafukovaciho objektu - 
     * vetsinou sirku opsaneho obdelniku.     
     *
     * @return Sirka objektu.
     */
    public int getSirka();


    /***************************************************************************
     * Vrati aktualni vysku nafukovaciho objektu - 
     * vetsinou sirku opsaneho obdelniku.     
     *
     * @return Vyska objektu.
     */
    public int getVyska();


    /***************************************************************************
     * Nastavi novou velikost nafukovaciho objektu;
     * pozice objektu by se pritom nemela zmenit.
     *
     * @param vyska  Nova sirka objektu
     * @param sirka  Nova vyska objektu
     */
    public void setRozmer(int sirka, int vyska);


//== VNORENE TRIDY =============================================================
}

