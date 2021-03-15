/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package podminky;

/**
 *
 * @author NcFerrari
 */
public class SwitchOrSyntaxe {

    public static void main(String[] args) {
        int mesic = 6;
        switch (mesic) {
            case 1:
            case 2:
            case 3:
                System.out.println("Je první čtvrtletí.");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("Je druhé čtvrtletí.");
                break;
            case 7:
            case 8:
            case 9:
                System.out.println("Je třetí čtvrtletí.");
                break;
            case 10:
            case 11:
            case 12:
                System.out.println("Je čtvrté čtvrtletí.");
        }
    }
}
