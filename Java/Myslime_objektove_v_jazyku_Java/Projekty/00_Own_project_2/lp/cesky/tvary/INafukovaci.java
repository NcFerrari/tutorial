package lp.cesky.tvary;

/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Pøíliš luouèkı kùò úpìl ïábelské ódy. */




/*******************************************************************************
 * Instance rozhraní {@code INafukovaci} pøedstavují ...
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public interface INafukovaci
{
    //== VEØEJNÉ KONSTANTY =====================================================
    //== DEKLAROVANÉ METODY ====================================================
    int getSirka();
    
    int getVyska();
    
    void setRozmer(int sirka, int vyska);
    
    int getX();
    
    int getY();
    
    void setPozice(int x, int y);
    //== ZDÌDÌNÉ METODY ========================================================
    //== INTERNÍ DATOVÉ TYPY ===================================================
}
