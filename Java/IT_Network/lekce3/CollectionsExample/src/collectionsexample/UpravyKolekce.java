package collectionsexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UpravyKolekce {

    public static void main(String[] args) {
        // copy(destinationCollection, sourceCollection) POZOR!! Přepíší se tímto prvky u cílové kolekce!!
        final List<Integer> src = Arrays.asList(12, 65, 87, 2, 38, 42, 73, 21);
        final List<Integer> dest = Arrays.asList(85, 3, 45, 24, 97, 26, 15, 38, 48, 56, 14);
        System.out.println("Obsah původní cílové kolekce: " + dest);
        Collections.copy(dest, src);
        System.out.println("Přepsaný obsah cílové kolekce: " + dest);

        // fill()
        final List<Integer> list = Arrays.asList(12, 35, 89, 48, 56);
        System.out.println("Obsah původní kolekce: " + list);
        Collections.fill(list, 5);
        System.out.println("Přepsaný obsah kolekce: " + list);

        // inicializace + fill()
        final List<String> stringList = Arrays.asList(new String[20]);
        Collections.fill(stringList, "Test");
        System.out.println(stringList);

        // replaceAll()
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 9, 2, 7, 6, 2);
        System.out.println("Obsah původní kolekce:\t" + numbers);
        final int oldValue = 2;
        final int newValue = 8;
        final boolean prvkyPrepsany = Collections.replaceAll(numbers, oldValue, newValue);
        System.out.println("Prvky byly přepsány: " + prvkyPrepsany);
        System.out.println("Novy obsah kolekce:\t" + numbers);

        // reverse()
        final List<Integer> numberValues = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Obsah původní kolekce: " + numberValues);
        Collections.reverse(numberValues);
        System.out.println("Nový obsah kolekce: " + numberValues);

        // rotate()
        final List<Integer> basicNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Obsah původní kolekce: " + basicNumbers);
        Collections.rotate(basicNumbers, 3);
        System.out.println("Nový obsah kolekce: " + basicNumbers);

        // shuffle() a sort() (promíchat a setřídit)
        final List<Integer> sortedNumbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Obsah původní kolekce: " + sortedNumbers);
        Collections.shuffle(sortedNumbers);
        System.out.println("Nový obsah kolekce: " + sortedNumbers);
        Collections.sort(sortedNumbers);
        System.out.println("Znovusetřízená kolekce: " + sortedNumbers);

        // swap() (prohodí INDEXY!!!! ne hodnoty!!!)
        final List<Integer> basicList = Arrays.asList(6, 2, 3, 5, 7, 9, 8, 4, 5);
        System.out.println("Obsah puvodni kolekce: " + basicList);
        final int srcIndex = 2;
        final int dstIndex = 6;
        Collections.swap(basicList, srcIndex, dstIndex);
        System.out.println("Obsah nove kolekce: " + basicList);
        
        
    }
}
