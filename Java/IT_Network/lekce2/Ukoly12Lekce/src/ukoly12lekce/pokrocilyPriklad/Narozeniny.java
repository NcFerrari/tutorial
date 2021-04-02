package ukoly12lekce.pokrocilyPriklad;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Narozeniny {

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in, "Windows-1250");
//        System.out.println("Zadej datum narození:");
//        LocalDate date = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("d.M.y"));
//        Osoba osoba = new Osoba(date);
//        date = date.withYear(LocalDate.now().getYear());
//        if (date.isBefore(LocalDate.now())) {
//            date = date.withYear(date.getYear() + 1);
//        }
//        System.out.printf("Je ti %s let a narozeniny máš za %s dní.\n", osoba.getVek(), Duration.between(LocalDate.now().atStartOfDay(), date.atStartOfDay()).toDays());
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");

        System.out.println("Zadej datum narození: ");
        String vstup = sc.nextLine().trim();

        LocalDate datum = LocalDate.parse(vstup, DateTimeFormatter.ofPattern("d.M.yyyy"));
        LocalDate dnes = LocalDate.now();

        Period stari = datum.until(dnes);

        System.out.printf("Je ti %d let a narozeniny máš za %d dní.\n", stari.getYears(), dnes.getDayOfYear());
    }
}
