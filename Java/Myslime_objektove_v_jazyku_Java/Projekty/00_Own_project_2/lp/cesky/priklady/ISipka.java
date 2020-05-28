/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Pøíliš luouèkı kùò úpìl ïábelské ódy. */
package lp.cesky.priklady;

import lp.cesky.tvary.IHybaci;



/*******************************************************************************
 * Instance rozhraní {@code ISipka} pøedstavují ...
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public interface ISipka extends IHybaci
{
    //== VEØEJNÉ KONSTANTY =====================================================
    //== DEKLAROVANÉ METODY ====================================================
    //== ZDÌDÌNÉ METODY ========================================================
    //== INTERNÍ DATOVÉ TYPY ===================================================
    
    public void vpred();
    
    public ISipka vlevoVbok();
    
    public ISipka vpravoVbok();
}
