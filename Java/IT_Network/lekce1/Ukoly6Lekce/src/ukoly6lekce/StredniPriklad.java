/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukoly6lekce;

import java.util.Scanner;

/**
 *
 * @author NcFerrari
 */
public class StredniPriklad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        String green = " zelených láhví";
        for (int i = 10; i > 0; i--) {
            System.out.println(i + green + " stojí na stole a jedna láhev spadne");
            if (i < 3) {
                green = " zelená láhev";
            } else if (i < 6) {
                green = " zelené láhve";
            }
        }
    }
}
