package streamapi;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SileneStreamy {

    private Random random = new Random();

    public SileneStreamy() {

        randomStream();
        mapStream();
        mapToIntStream();
        flatMapStream();
        findFirst();
        groupingBy();
        joining();
    }

    public static void main(String[] args) {
        new SileneStreamy();
    }

    private void randomStream() {
        random
                .ints(0, 20)
                .limit(10)
                .peek(cislo -> System.out.print(cislo + ", "))
                .sorted()
                .forEach(System.out::println);
        System.out.println("**************************************\n");
    }

    private void mapStream() {
        Stream.of("Petr", "Michal", "Karel", "Vojta", "David", "Ondra")
                .map(Uzivatel::new)
                .forEach(System.out::println);
        System.out.println("**************************************\n");
    }

    private void mapToIntStream() {
        Stream
                .of("Petr", "Michal", "Karel", "Vojta", "David")
                .peek(jmeno -> System.out.print(jmeno + ": "))
                .mapToInt(String::length)
                .peek(System.out::println)
                .max()
                .ifPresent(delka -> System.out.println("Nejdelší jméno je dlouhé: " + delka + " znaků."));
        System.out.println("**************************************\n");
    }

    private void flatMapStream() {
        List<Uzivatel> uzivatele = Arrays.asList(
                new Uzivatel("Karel", 14, 45, 1, 69, 18, 15, 83, 22, 54),
                new Uzivatel("Michal", 65, 80, 78, 42, 8, 19, 11, 71, 51),
                new Uzivatel("Josef", 57, 31, 53, 25, 45, 70, 91, 3, 67),
                new Uzivatel("Kamil", 66, 79, 72, 46, 26, 80, 12, 82, 83));

        // Úkol: chceme zjistit, zda-li má nějaký uživatel jako oblíbené číslo 3
        final int hledaneCislo = 3;
        uzivatele
                .stream()
                // Získáme z uživatele jeho oblíbená čísla
                .map(Uzivatel::getOblibenaCisla)
                // Metodou flatMap() převedeme tuto kolekci na stream
                .flatMap(java.util.Collection::stream)
                // Vyfiltrujeme oblíbené číslo
                .filter(oblibeneCislo -> oblibeneCislo == hledaneCislo)
                // Najdeme první výskyt
                .findAny()
                // Pokud má nějaký uživatel hledané číslo v oblíbených, vypíšeme hlášku
                .ifPresent(integer -> System.out.printf("Číslo %d je opravdu něčí oblíbené číslo.\n", hledaneCislo));
        System.out.println("**************************************\n");
    }

    private void findFirst() {
        Stream
                .of("pepa", "karel", "honza", "michal", "petr")
                .filter(jmeno -> jmeno.length() > 4)
                .findFirst()
                .ifPresent(System.out::println);
        System.out.println("**************************************\n");
    }

    private void groupingBy() {
        Stream
                .of("pepa", "michal", "vojta", "david", "petr")
                .collect(Collectors.groupingBy(String::length))
                .forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println("**************************************\n");

        Stream
                .of("pepa", "michal", "vojta", "david", "petr")
                .collect(Collectors.groupingBy((name) -> {
                    return name.toUpperCase().charAt(0);
                }))
                .forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println("**************************************\n");
    }

    private void joining() {
        List<String> list = Arrays.asList("pepa", "michal", "vojta", "david", "petr");
        String finalString = "";

        finalString = list.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.joining(" | ", "{", "}"));

        System.out.println(finalString);
    }

    private class Uzivatel {

        private String jmeno;
        private int vek;
        private final List<Integer> oblibenaCisla = new ArrayList<>();

        Uzivatel(String jmeno, Integer... oblibenaCisla) {
            this.jmeno = jmeno;
            this.vek = random.nextInt(10) + 20;
            this.oblibenaCisla.addAll(Arrays.asList(oblibenaCisla));
        }

        @Override
        public String toString() {
            return String.format("%s(%d)", jmeno, vek);
        }

        public List<Integer> getOblibenaCisla() {
            return oblibenaCisla;
        }
    }
}
