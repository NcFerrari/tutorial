package poznamkovac;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Diar {

    public static final DateTimeFormatter FORMAT_DATA = DateTimeFormatter.ofPattern("d.M.y HH:mm");
    public static final DateTimeFormatter FORMAT_DATA_BEZ_CASU = DateTimeFormatter.ofPattern("d.M.y");

    private final Scanner scanner = new Scanner(System.in, "Windows-1250");

    private Databaze db;

    public Diar(Databaze db) {
        this.db = db;
    }

    public void vypisUvodniObrazovky() {
        LocalDateTime dnes = LocalDateTime.now();
        System.out.println("Vítejte v diáři!\nDnes je: " + FORMAT_DATA.format(dnes) + "\n\nDnes:\n-----");
        vypisZaznamy(dnes);
        System.out.println("\nZítra:\n-----");
        LocalDateTime zitra = dnes.plusDays(1);
        vypisZaznamy(zitra);
        System.out.println();
    }

    public void pridejZaznam() {
        LocalDateTime datumCas = zjistiDatumCas();
        System.out.println("Zadejte text záznamu:");
        db.pridejZaznam(datumCas, scanner.nextLine());
    }

    public void vypisZaznamy(LocalDateTime den) {
        for (Zaznam zaznam : db.najdiZaznamy(den, false)) {
            System.out.println(zaznam);
        }
    }

    public void vyhledejZaznamy() {
        LocalDateTime datumCas = zjistiDatum();
        List<Zaznam> zaznamy = db.najdiZaznamy(datumCas, false);
        if (zaznamy.isEmpty()) {
            System.out.println("Nebyly nalezeny žádné záznamy!");
        } else {
            System.out.println("Nalezeny tyto záznamy:");
            for (Zaznam zaznam : zaznamy) {
                System.out.println(zaznam);
            }
        }
    }

    public void vymazZaznamy() {
        System.out.println("Budou vymazány záznamy v daný den a hodinu");
        LocalDateTime datumCas = zjistiDatumCas();
        db.vymazZaznamy(datumCas);
    }

    private LocalDateTime zjistiDatumCas() {
        System.out.println("Zadejte datum a čas ve tvaru: 1.1.2021 20:00");
        while (true) {
            try {
                return LocalDateTime.parse(scanner.nextLine(), FORMAT_DATA);
            } catch (Exception exp) {
                System.out.println("Nesprváně zadáno, zadejte prosím znovu");
            }
        }
    }

    private LocalDateTime zjistiDatum() {
        System.out.println("Zadejte datum ve tvaru: 1.1.2021");
        while (true) {
            try {
                return LocalDate.parse(scanner.nextLine(), FORMAT_DATA_BEZ_CASU).atStartOfDay();
            } catch (Exception exp) {
                System.out.println("Nesprávně zadáno, zadejte prosím znovu");
            }
        }
    }

}
