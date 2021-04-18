package fronta;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Zakaznik {

    private static final Random RANDOM = new Random();
    private static final String[] JMENA = {"David", "Adam", "Richard", "Martin", "Sam", "Drahomír",
        "Vlastimil", "Michael", "Štěpán", "Petr"};

    private final String jmeno;

    public Zakaznik() {
        this.jmeno = JMENA[RANDOM.nextInt(JMENA.length)];
    }

    @Override
    public String toString() {
        return jmeno;
    }

    /**
     * FIFO
     *
     * @param args
     */
    public static void main(String[] args) {
        Queue<Zakaznik> zakaznici = new LinkedList<>();
        System.out.println("Přidáme zákazníky do fronty\n=====================");
        for (int i = 0; i < 10; i++) {
            Zakaznik zakaznik = new Zakaznik();
            zakaznici.offer(zakaznik);
            System.out.println("Zákazník " + zakaznik + " se zařadil do fronty");
        }

        System.out.println("Obsluhuji zákazníky\n=====================");
        while (zakaznici.peek() != null) {
            if (RANDOM.nextInt(5) == 0) {
                Zakaznik z = new Zakaznik();
                zakaznici.offer(z);
                System.out.println("===>Zákazník " + z + " se zařadil do fronty");
            }
            Zakaznik zakaznik = zakaznici.poll();
            System.out.println("Zakazník " + zakaznik + " byl obsloužen");
        }
    }
}
