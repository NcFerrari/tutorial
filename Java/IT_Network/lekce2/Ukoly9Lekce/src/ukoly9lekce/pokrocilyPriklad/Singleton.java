package ukoly9lekce.pokrocilyPriklad;

public class Singleton {

    public static void main(String[] args) {
        Databaze databaze = Databaze.getInstance();
        System.out.println(databaze.getDatabaze());
    }
}
