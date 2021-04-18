package mnozina;

import java.util.HashSet;
import java.util.Set;

public class Mnozina {

    public static void main(String[] args) {
        Cestujici karel = new Cestujici("Karel", "Novák");
        Cestujici josef = new Cestujici("Josef", "Nový");
        Cestujici tomas = new Cestujici("Tomáš", "marný");

        Set<Cestujici> cestujici = new HashSet<>();
        cestujici.add(karel);
        cestujici.add(josef);
        cestujici.add(tomas);
        cestujici.add(tomas);
        cestujici.add(karel);

        for (Cestujici c : cestujici) {
            System.out.println(c);
        }
    }
}
