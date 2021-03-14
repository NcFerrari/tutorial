/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukoly9lekce;

import java.util.Scanner;

/**
 *
 * @author NcFerrari
 */
public class StredniPriklad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        final String znaky = "abcdefghijklmnopqrstuvwxyz";
        final char[] abeceda = znaky.toCharArray();
        final String[] morseovaAbeceda = {".-", "-...", "-.-.", "-..", ".",
            "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
            "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--",
            "-..-", "-.--", "--.."};

        System.out.println("Zadejte zprávu k zakódování:");
        String slovo = scanner.nextLine();
        String morseovoSlovo = "";
        String[] splittedWord = slovo.toLowerCase().trim().split("");
        for (String letter : splittedWord) {
            for (int i = 0; i < abeceda.length; i++) {
                if (letter.charAt(0) == abeceda[i]) {
                    morseovoSlovo += morseovaAbeceda[i] + " ";
                    break;
                }
            }
        }
        System.out.println("Zakódovaná zpráva: " + morseovoSlovo);
    }
}
// - . -. - --- .--. .-. --- --. .-. .- -- .--- ... . -- ...- -.-- - ...- --- .-. .. .-.. ... .- -- .--. --- -.. .. ...- . .--- - . -.-. --- -.. --- ...- . -.. .
// - . -. - --- .--. .-. --- --. .-. .- -- .--- ... . -- ...- -.-- - ...- --- .-. .. .-.. ... .- -- .--. --- -.. .. ...- . .--- - . -.-. --- -.. --- ...- . -.. .