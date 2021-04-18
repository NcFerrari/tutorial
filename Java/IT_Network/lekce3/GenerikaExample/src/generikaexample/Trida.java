package generikaexample;

import java.util.ArrayList;

public class Trida<T> {

    private T promenna;

    public Trida(T promenna) {
        this.promenna = promenna;
        System.out.println(promenna);
    }
    
    public <T> boolean porovnej(T a) {
        return promenna.equals(a);
    }

    public static void main(String[] args) {
        Trida<Integer> trida = new Trida<>(10);
        System.out.println(trida.porovnej(10));
        System.out.println(trida.porovnej("10"));
        ArrayList<Object> list;
    }
}
