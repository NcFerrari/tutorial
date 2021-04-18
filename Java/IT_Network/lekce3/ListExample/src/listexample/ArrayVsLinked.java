package listexample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayVsLinked {

    private List<Integer> arrayList = new ArrayList<>();
    private LinkedList<Integer> linkedList = new LinkedList<>();

    public ArrayVsLinked() {
        arrayList.add(5);
        arrayList.add(10);
        System.out.println(arrayList.get(0));

        linkedList.add(5);
        linkedList.addFirst(6);
        linkedList.addLast(10);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());

        linkedList.clear();

        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);

        linkedList.add(3, 32);
        linkedList.add(3, 31);
        linkedList.remove(2);

        for (int i : linkedList) {
            System.out.print(i + ", ");
        }
    }

    public static void main(String[] args) {
        new ArrayVsLinked();
    }
}
