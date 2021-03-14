/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retezce;

/**
 *
 * @author NcFerrari
 */
public class StringMetody {

    public static void main(String[] args) {
        // substring
        System.out.println("Kdo se směje naposled, ten je admin.".substring(13, 21));

        // compareTo
        System.out.println("akát".compareTo("blýskavice"));

        // speciální znaky a escapování
        System.out.println("První řádka\nDruhá řádka");
        System.out.println("Toto je zpětné lomítko: \\");
        System.out.println("Toto je uvozovka: \"");
    }
}
