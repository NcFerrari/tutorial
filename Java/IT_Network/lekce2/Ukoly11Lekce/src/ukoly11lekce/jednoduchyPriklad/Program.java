package ukoly11lekce.jednoduchyPriklad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    private final List<String> words = new ArrayList<>();

    public void addWord(String word) {
        if (!words.contains(word)) {
            words.add(word);
        }
    }

    public String output() {
        String output = "";
        String suffix = ", ";
        for (int i = 0; i < words.size(); i++) {
            if (i == words.size() - 1) {
                suffix = "";
            }
            output += words.get(i) + suffix;
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        Program program = new Program();
        String output = "";
        boolean end = false;
        while (!end) {
            System.out.print("Zadej slovo: ");
            output = scanner.nextLine().toLowerCase().trim();
            if (!output.toLowerCase().trim().equals("konec")) {
                program.addWord(output);
            } else {
                end = true;
            }
        }
        System.out.println("Zadal jsi tato slova: " + program.output());
    }
}
