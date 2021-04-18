package collectionsexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PraceSKolekci {

    public static void main(String[] args) {
        // disjoint(Collection, Collection)
        final List<String> c1 = Arrays.asList("karel", "pepa", "michal");
        final Collection<String> c2 = Arrays.asList("ondra", "kamil", "petr");
        final boolean disjoint = Collections.disjoint(c1, c2);
        System.out.println("Kolekce neobsahují stejné prvky: " + disjoint);

        // frequency(Collection, object)
        final Collection<String> c = Arrays.asList("karel", "michal", "petr", "karel", "ondra");
        final int frekvence = Collections.frequency(c, "karel");
        System.out.println("Kolekce obsahuje: " + frekvence + "x jméno karel.");

        // indexOfSubList(Collection, SubCollection)
        // lastIndexOfSubList(Collection, SubCollection)
        final List<Integer> numbers = Arrays.asList(1, 5, 9, 3, 5, 7, 4, 2, 3, 5, 7, 6);
        final List<Integer> subList = Arrays.asList(3, 5, 7);
        final int indexOfSubList = Collections.indexOfSubList(numbers, subList);
        final int lastIndexOfSubList = Collections.lastIndexOfSubList(numbers, subList);
        System.out.println("První nalezený index kolekce: " + subList + " je: " + indexOfSubList + " a poslední index této subkolekce je: " + lastIndexOfSubList);

        // max()
        // min()
        final Collection<Integer> numberValues = Arrays.asList(8, 7, 7, 6, 0, 5, -3, 1, 1, 3);
        final int max = Collections.max(numberValues);
        final int min = Collections.min(numberValues);
        System.out.printf("Maximální prvek v kolekci %s je: %d a minimální prvek v této kolekci je %d\n", numberValues, max, min);

        // binarySearch()
        final List<Integer> list = Arrays.asList(9, 6, 5, 4, 2, 3, 1, 7, 8, 0);
        Collections.sort(list); // Zkuste si zakomentovat řazení, algoritmus přestane fungovat
        final int key = 2;
        final int index = Collections.binarySearch(list, key);
        System.out.println("Prvek: " + key + " se nachází na pozici: " + index);

        // inicializace 1 - prázdná kolekce
        List<Integer> array = Arrays.asList(new Integer[10]);
        System.out.println(array);

        // inicializace 2 (nastavení možnosti velkého počtu prvků)
        // při větším počtu dat je dobré u ArrayListu nastavit v závorce počet počátečního pole (initialCapacity).
        // jde o to, jak funguje ArrayList. ArrayList vnitřně vždy vytváří pole o velikosti 12 prvků. Pokud tuto velikost přesáhne, tak
        // toto pole přepíše opět dalším pole zvětšeným o 12 prvků atd. pořád dokola.
        // Pokud víme, že budeme pracovat s velkým objemem dat, je dobré toto pole rovnou definovat
        // Velikost pole sice takhle určíme, ale na venek se stále bude kolekce tvářit, že žádné pole neexistuje a skutečný počet prvků si
        // uchovává ve své vlastní proměnné.
        final List<String> stringList = new ArrayList<>(1_000_000_000);
        for (int i = 0; i < 1_000_000_000; i++) {
            stringList.add("test");
        }
        System.out.println(stringList.size());
    }
}
