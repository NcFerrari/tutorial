package listexample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DiffList {

    private static Long time, arrayTime, linkedTime;

    public static void main(String[] args) {
        final List<Integer> array = new ArrayList<>();
        final LinkedList<Integer> linked = new LinkedList<>();

        createNewList(1000, array, linked);
        insertIntoList(array, linked, 50);
        insertIntoList(array, linked, 654);

        System.out.println();

        createNewList(1_0_000_000, array, linked);
        insertIntoList(array, linked, 50);
        insertIntoList(array, linked, 654);
        insertIntoList(array, linked, 7778516);
    }

    public static void createNewList(int countOfElements, List array, List linked) {
        array.clear();
        linked.clear();
        System.out.println(String.format("Porovnání vytváření obou kolekcí pro %d prvků", countOfElements));

        // array time
        time = System.currentTimeMillis();
        for (int i = 1; i <= countOfElements; i++) {
            array.add(i);
        }
        arrayTime = System.currentTimeMillis() - time;

        // linked time
        time = System.currentTimeMillis();
        for (int i = 1; i <= countOfElements; i++) {
            linked.add(i);
        }
        linkedTime = System.currentTimeMillis() - time;

        ouptut(arrayTime, linkedTime);
    }

    public static void insertIntoList(List array, List linked, int index) {
        System.out.println(String.format("Vložení prvku na index č.%d", index));
        // array time
        time = System.currentTimeMillis();
        array.add(index, 100);
        arrayTime = System.currentTimeMillis() - time;

        // linked time
        time = System.currentTimeMillis();
        linked.add(index, 100);
        linkedTime = System.currentTimeMillis() - time;

        ouptut(arrayTime, linkedTime);
    }

    private static void ouptut(Long arrayTime, Long linkedTime) {
        System.out.println(String.format("Array : Linked = %d ms : %d ms", arrayTime, linkedTime));
    }
}
