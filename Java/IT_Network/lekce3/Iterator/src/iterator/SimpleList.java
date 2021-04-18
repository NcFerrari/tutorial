package iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class SimpleList<T> implements Iterable<T> {

    private T[] arrayList;
    private int currentSize;

    public SimpleList(T[] newArray) {
        arrayList = newArray;
        currentSize = arrayList.length;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize && arrayList[currentIndex] != null;
            }

            @Override
            public T next() {
                return arrayList[currentIndex++];
            }

        };
        return iterator;
    }

}
