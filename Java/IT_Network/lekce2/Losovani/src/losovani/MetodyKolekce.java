package losovani;

import java.util.ArrayList;
import java.util.Arrays;

public class MetodyKolekce {

    public void konstruktory() {
        String[] poleStringu = {"První", "Druha", "Třetí"};
        ArrayList<String> l = new ArrayList<String>(Arrays.asList(poleStringu));
        System.out.println(l.get(2));
    }

//    size() - Funguje jako length na poli, vrací počet prvků v kolekci.
//    add(položka) - Metodu add() jsme si již vyzkoušeli, jako parametr bere položku, kterou vloží do listu.
//    addAll(kolekce) - Přidá do listu více položek, např. z pole.
//    clear() - Vymaže všechny položky v listu.
//    contains(položka) - Vrací true/false podle toho, zda ArrayList obsahuje předanou položku.
//    indexOf(položka) - Vrátí index prvního výskytu položky (jako u pole). Vrací -1 při neúspěchu.
//    lastIndexOf(po­ložka) - Vrací index posledního výskytu položky v Listu. Vrací -1 při neúspěchu.
//    remove(položka) - Vymaže první nalezenou položku.
//    removeAll(index, počet) - Vymaže daný počet prvků od zadaného indexu.
//    toArray() - Zkopíruje položky z ArrayListu do pole a to vrátí.
    public static void main(String[] args) {
        MetodyKolekce metodyKolekce = new MetodyKolekce();
        metodyKolekce.konstruktory();
    }

}
