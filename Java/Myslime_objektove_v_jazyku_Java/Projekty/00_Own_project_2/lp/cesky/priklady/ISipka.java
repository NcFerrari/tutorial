/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola k�dov�n�: P��li� �lu�ou�k� k�� �p�l ��belsk� �dy. */
package lp.cesky.priklady;

import lp.cesky.tvary.IHybaci;



/*******************************************************************************
 * Instance rozhran� {@code ISipka} p�edstavuj� ...
 *
 * @author    jm�no autora
 * @version   0.00.000
 */
public interface ISipka extends IHybaci
{
    //== VE�EJN� KONSTANTY =====================================================
    //== DEKLAROVAN� METODY ====================================================
    //== ZD�D�N� METODY ========================================================
    //== INTERN� DATOV� TYPY ===================================================
    
    public void vpred();
    
    public ISipka vlevoVbok();
    
    public ISipka vpravoVbok();
}
