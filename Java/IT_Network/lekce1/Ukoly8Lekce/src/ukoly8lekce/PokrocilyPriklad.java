/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukoly8lekce;

import java.util.Scanner;

/**
 *
 * @author NcFerrari
 */
public class PokrocilyPriklad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        System.out.println("Zadejte text k zašifrování:");
        String word = scanner.nextLine();
        System.out.println("Zadejte heslo:");
        String password = scanner.nextLine();

        char[] passwordField = password.toCharArray();
        char[] wordField = word.toLowerCase().trim().toCharArray();
        int moveIndex = 0;
        String newWord = "";
        for (char c : wordField) {
            if (c == ' ') {
                newWord += ' ';
            } else if ((int) c + (int) passwordField[moveIndex] - 96 > 122) {
                newWord += (char) (((int) c + (int) passwordField[moveIndex] - 96) - 26);
            } else {
                newWord += (char) ((int) c + (int) passwordField[moveIndex] - 96);
            }
            moveIndex++;
            if (moveIndex == passwordField.length) {
                moveIndex = 0;
            }
        }
        System.out.println(newWord);
    }
}
