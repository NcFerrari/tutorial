/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukoly7lekce;

import java.util.Scanner;

/**
 *
 * @author NcFerrari
 */
public class JednoduchyPriklad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        int[] field = new int[10];
        for (int i = 10; i > 0; i--) {
            field[10 - i] = i;
        }
        for (int i : field) {
            System.out.println(i);
        }
    }
}
