package ukoly4lekce.stredniPriklad;

import java.util.Scanner;

public class Prochazeni {

    private final Scanner scanner = new Scanner(System.in, "Windows-1250");
    private final Lokace hrad;
    private final Lokace les1;
    private final Lokace lesniRozcesti;
    private final Lokace les2;
    private final Lokace rybnik;
    private final Lokace les3;
    private final Lokace dum;

    public Prochazeni() {
        hrad = new Lokace("Hrad", "Stojíš před okovanou branou gotického hradu, která je zřejmě jediným vchodem do pevnosti.\nKlíčová dírka je pokryta pavučinami, což vzbuzuje dojem, že je budova opuštěná.");
        les1 = new Lokace("Les", "Jsi na lesní cestě, která se klikatí až za obzor, kde mizí v siluetě zapadajícího\nslunce. Ticho podvečerního lesa občas přeruší zpěv posledních ptáků.");
        lesniRozcesti = new Lokace("Lesní rozcestí", "Nacházíš se na lesním rozcestí.");
        les2 = new Lokace(les1.getNazev(), les1.getPopis());
        rybnik = new Lokace("Rybník", "Došel jsi ke břehu malého rybníka. Hladina je v bezvětří jako zrcadlo. Kousek\nod tebe je dřevěná plošina se stavidlem.");
        les3 = new Lokace(les1.getNazev(), les1.getPopis());
        dum = new Lokace("Dům", "Stojíš před svým rodným domem, cítíš vůni čerstvě nasekaného dřeva, která se line\nz hromady vedle vstupních dveří.");
        hrad.setSousedniLokace(null, les1, null, null);
        les1.setSousedniLokace(null, lesniRozcesti, null, hrad);
        lesniRozcesti.setSousedniLokace(null, les2, les3, les1);
        les2.setSousedniLokace(null, rybnik, null, lesniRozcesti);
        rybnik.setSousedniLokace(null, null, null, les2);
        les3.setSousedniLokace(lesniRozcesti, dum, null, null);
        dum.setSousedniLokace(null, null, null, les3);
        hra();
    }

    public void hra() {
        Hra hra = new Hra(dum);
        boolean pokracovat = true;
        while (pokracovat) {
            System.out.println(hra.getLokace());
            System.out.println("Zadej příkaz:");
            pokracovat = hra.jdiNa(scanner.nextLine());
        }
    }

    public static void main(String[] args) {
        new Prochazeni();
    }
}
