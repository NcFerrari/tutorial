/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pole;

/**
 *
 * @author NcFerrari
 */
public class VicerozmernaPole {

    public static void main(String[] args) {
        int[][] polePoli = new int[5][5];
        polePoli[2][2] = 1;
        for (int i = 1; i < 4; i++) {
            polePoli[3][i] = 1;
        }
        for (int i = 0; i < 5; i++) {
            polePoli[4][i] = 1;
            
        }
        for (int[] pole : polePoli) {
            for (int i : pole) {
                System.out.printf("[%d]", i);
            }
            System.out.println("");
        }
    }
}
