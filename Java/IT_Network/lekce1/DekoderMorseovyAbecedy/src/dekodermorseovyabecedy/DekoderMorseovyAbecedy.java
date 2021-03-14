/*
 * To change this license header"," choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dekodermorseovyabecedy;

/**
 *
 * @author NcFerrari
 */
public class DekoderMorseovyAbecedy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String znaky = new String("abcdefghijklmnopqrstuvwxyz ");
        final char[] abeceda = znaky.toCharArray();
        final String[] morseovaAbeceda = {".-", "-...", "-.-.", "-..", ".",
            "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
            "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--",
            "-..-", "-.--", "--..", ""};

        String morseovoSlovo = ".--- ---  -- .- --. -.. .-  .--- .  -- .- --. -.. .-  -- .- --. -.. ..-  -- .- -- .  ...- ... .. -.-. .... -. ..  .-. .- -.. ..";
        System.out.println("Původní zpráva: " + morseovoSlovo);
        String slovo = "";

        String[] splittedMorseWord = morseovoSlovo.split(" ");
        for (String letter : splittedMorseWord) {
            for (int i = 0; i < morseovaAbeceda.length; i++) {
                if (letter.equals(morseovaAbeceda[i])) {
                    slovo += abeceda[i];
                    break;
                }
            }
        }
        System.out.println(slovo);
        
        slovo = "Jo magda je magda Magdu mame vsichni radi";
        morseovoSlovo = "";
        String[] splittedWord = slovo.toLowerCase().trim().split("");
        for (String letter : splittedWord) {
            String l = "? ";
            for (int i = 0; i < abeceda.length; i++) {
                if (letter.charAt(0) == abeceda[i]) {
                    l = morseovaAbeceda[i] + " ";
                    break;
                }
            }
            morseovoSlovo += l;
        }
        System.out.println(morseovoSlovo);
    }

}
