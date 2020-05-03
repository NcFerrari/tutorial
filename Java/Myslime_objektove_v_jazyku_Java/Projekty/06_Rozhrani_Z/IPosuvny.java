/*******************************************************************************
 * Rozhrani IPosuvny definuje povinou sadu metod, jez musi byt poskytovany 
 * objekty, ktere maji byt schopny posunu po animovanem platne.
 *
 * @author     Rudolf Pecinovsky
 * @version    1.01, 28.1.2003
 */
public interface IPosuvny 
{
//== VEREJNE KONSTANTY =========================================================
//== PRISTUPOVE METODY VLASTNOSTI INSTANCI =====================================
//== OSTATNI METODY K IMPLEMENTACI =============================================

    /***************************************************************************
     * Vrati x-ovou souradnici posuvneho objektu,
     * vetsinou x-ovou souradnici leveho horniho rohu opsaneho obdelniku.
     *
     * @return x-ova souradnice leveho horniho rohu opsaneho obdelniku.
     */
     public int getX();


    /***************************************************************************
     * Vrati y-ovou souradnici posuvneho objektu,
     * vetsinou y-ovou souradnici leveho horniho rohu opsaneho obdelniku.
     *
     * @return y-ova souradnice leveho horniho rohu opsaneho obdelniku.
     */
     public int getY();


    /***************************************************************************
     * Presune posuvny objekt do nove pozice.
     *
     * @param x  Nova x-ova pozice.
     * @param y  Nova y-ova pozice.
     */
    public void setPozice(int x, int y);


//== VNORENE TRIDY =============================================================
}

