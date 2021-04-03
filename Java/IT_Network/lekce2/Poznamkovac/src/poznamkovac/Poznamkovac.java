package poznamkovac;

import java.util.Scanner;

public class Poznamkovac {

    private final Scanner scanner = new Scanner(System.in, "Windows-1250");
    private Databaze db;
    private Diar diar;

    public Poznamkovac() {
        db = new Databaze();
        diar = new Diar(db);
        run();
    }

    public static void main(String[] args) {
        new Poznamkovac();
    }

    private void run() {
        String volba = "";
        diar.vypisUvodniObrazovky();
        while (!volba.equals("4")) {
            System.out.println("\nVyberte si akci:\n1 - Přidat záznam\n2 - Vyhledat záznam\n3 - Vymazat záznam\n4 - Konec");
            volba = scanner.nextLine();
            System.out.println();
            switch (volba) {
                case "1":
                    diar.pridejZaznam();
                    break;
                case "2":
                    diar.vyhledejZaznamy();
                    break;
                case "3":
                    diar.vymazZaznamy();
                    break;
                case "4":
                    System.out.println("Libovolnou klávesou ukončíte program...");
                    break;
                default:
                    System.out.println("Neplatná volba, stiskni libovolnou klávesu a opakuj volbu.");
            }
        }
    }
}
