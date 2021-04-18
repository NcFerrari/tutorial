package slovnik;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Slovnik {

    public static void main(String[] args) {
        Map<String, String> slovnik = new HashMap<>();
        slovnik.put("cat", "kočka");
        slovnik.put("mouse", "myš");
        slovnik.put("computer", "počítač");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadej slovo:");
        String slovo = scanner.nextLine();

        if (slovnik.containsKey(slovo)) {
            System.out.println("Překlad: " + slovnik.get(slovo));
        } else {
            System.out.println("Takové slovíčko ve slovníku není.");
        }

        System.out.println("Výpis slovníku:");
        for (String s : slovnik.keySet()) {
            System.out.println(s + " - " + slovnik.get(s));
        }

        System.out.println("\nVýpis slovníku:");
        for (Entry<String, String> entry : slovnik.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
