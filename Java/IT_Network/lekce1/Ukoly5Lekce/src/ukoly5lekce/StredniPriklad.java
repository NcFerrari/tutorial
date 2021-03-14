/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukoly5lekce;

import java.util.Scanner;

/**
 *
 * @author NcFerrari
 */
public class StredniPriklad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        System.out.println("Zadej smajlíka:");
        String smile = scanner.nextLine();
        switch (smile.toLowerCase().replace("-", "")) {
            case ":)":
                System.out.println("Tvůj smajlík je veselý");
                break;
            case ":(":
                System.out.println("Tvůj smajlík je smutný");
                break;
            case ":*":
                System.out.println("Tvůj smajlík je zamilovaný");
                break;
            case ":p":
                System.out.println("Tvůj smajlík je s vyplazeným jazykem");
                break;
            default:
                System.out.println("Tvůj smajlík je neznámý");
        }
    }
}
