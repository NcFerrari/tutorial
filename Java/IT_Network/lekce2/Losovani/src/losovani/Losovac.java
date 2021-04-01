package losovani;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Losovac {

    private final List<Integer> cisla = new ArrayList<>();
    private final Random random = new Random();

    public int losuj() {
        int generatedNumber = random.nextInt(100) + 1;
        cisla.add(generatedNumber);
        return generatedNumber;
    }

    public String vypis() {
        Collections.sort(cisla);
        String result = "";
        for (int number : cisla) {
            result += number + " ";
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        Losovac losovac = new Losovac();
        int volba = 0;

        System.out.println("Vítejte v programu losování.");
        while (volba != 3) {
            System.out.println("1 - Losovat další číslo");
            System.out.println("2 - Vypsat čísla");
            System.out.println("3 - Konec");
            volba = Integer.parseInt(scanner.nextLine());
            switch (volba) {
                case 1:
                    System.out.printf("Padlo číslo: %s\n", losovac.losuj());
                    break;
                case 2:
                    System.out.printf("Padla čísla: %s\n", losovac.vypis());
                    break;
                case 3:
                    System.out.println("Děkuji za použití programu");
                    break;
                default:
                    System.out.println("Zvolte 1 (losuj), 2 (vypiš) nebo 3 (konec)");
            }
        }
    }
}
