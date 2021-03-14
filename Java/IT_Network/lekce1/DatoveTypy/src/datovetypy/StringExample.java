/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datovetypy;

import java.util.Scanner;

/**
 *
 * @author NcFerrari
 */
public class StringExample {

    public static void main(String[] args) {
        //startsWith
        //endsWith
        //contains
        String slovo = "Krokonosohroch";
        System.out.println(slovo.startsWith("krok"));
        System.out.println(slovo.endsWith("hroch"));
        System.out.println(slovo.contains("nos"));
        System.out.println(slovo.contains("roh"));

        //isEmpty
        String s1 = " ";
        String s2 = "";
        String s3 = "slovo";
        System.out.println(s1.isEmpty());
        System.out.println(s2.isEmpty());
        System.out.println(s3.isEmpty());

        //toLowerCase
        //toUpperCase
        String config = "FullScreen shaDows autosave";
        config = config.toLowerCase();
        System.out.println("Poběží hra ve fullscreenu? " + config.contains("fullscreen"));
        System.out.println("Budou zapnuté stíny? " + config.contains("shadows"));
        System.out.println("Přeje si hráč vypnout zvuk? " + config.contains("nosound"));
        System.out.println("Přeje si hráč hru automaticky ukládat? " + config.contains("autosave"));

        //trim
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        System.out.println("Zadejte číslo:");
        String s = scanner.nextLine();
        System.out.println("Zadal jste text: " + s);
        System.out.println("Text po funkci trim: " + s.trim());
        int a = Integer.parseInt(s.trim());
        System.out.println("Převedl jsem zadaný text na číslo parsováním, zadal jste: " + a);

        //replace
        String word = "C# je nejlepší!";
        word = word.replace("C#", "Java");
        System.out.println(word);

        //format
        // %d (int, short, long, byte)
        // %s (String + všechny typy)
        // %f (float, double) %.2f = dvě desetinná místa
        // %b (boolean + všechny typy)
        // %a (double)
        // %e (double)
        int x = 10;
        int y = 20;
        int z = x + y;
        String result = String.format("Když sečteme %d a %d, dostaneme %d", x, y, z);
        System.out.println(result);

        //length
        System.out.println("Zadejte vaše jméno:");
        String name = scanner.nextLine();
        System.out.printf("Délka vašeho jména je: %d\n", name.length());
    }
}
