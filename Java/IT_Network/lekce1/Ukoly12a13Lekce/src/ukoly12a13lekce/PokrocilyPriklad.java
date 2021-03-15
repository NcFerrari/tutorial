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
public class PokrocilyPriklad {

    public static void main(String[] args) {
        double[] sinHodnoty = new double[360];
        int index = 0;
        for (int i = 0; i < sinHodnoty.length; i += 1) {
            sinHodnoty[index++] = Math.sin(Math.toRadians(i));
        }

        String[][] buffer = new String[17][180];
        for (int i = 0; i < buffer.length; i++) {
            for (int j = 0; j < buffer[i].length; j++) {
                buffer[i][j] = "  ";
            }
        }

        index = 0;
        for (int i = 0; i < sinHodnoty.length; i += 12) {
            buffer[(int) (double) (sinHodnoty[i] * 8 + 8)][index++] = "█";
        }

        for (String[] buff : buffer) {
            for (String d : buff) {
                System.out.print(d);
            }
            System.out.println();
        }
    }
}
