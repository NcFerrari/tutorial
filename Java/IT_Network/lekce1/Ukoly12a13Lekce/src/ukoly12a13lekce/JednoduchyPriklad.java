/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukoly12a13lekce;

/**
 *
 * @author NcFerrari
 */
public class JednoduchyPriklad {

    public static void main(String[] args) {
        String tmavePole = "██";
        String svetlePole = "  ";
        boolean barvaPole = true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (barvaPole) {
                    System.out.print(tmavePole);
                } else {
                    System.out.print(svetlePole);
                }
                barvaPole ^= true;
            }
            System.out.println();
            barvaPole ^= true;
        }
    }
}
