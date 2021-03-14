/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukoly8lekce;

/**
 *
 * @author NcFerrari
 */
public class JednoduchyPriklad {

    public static void main(String[] args) {
        System.out.println("ASCII tabulka\n=============\n");
        for (int i = 33; i < 256; i++) {
            System.out.println(i + ":" + (char) i);
        }
    }
}
