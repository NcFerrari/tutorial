package ukoly4lekce.jednoduchyPriklad;

public class App {

    public static void main(String[] args) {
        Pes azor = new Pes("Azor", 1);

        Osoba lubor = new Osoba("Lubor");
        Osoba magda = new Osoba("Magda");

        lubor.pridejPsa(azor);
        magda.pridejPsa(azor);

        System.out.println(azor);

        lubor.getPes().zestarni();
        magda.getPes().zestarni();

        System.out.println(azor);
    }
}
