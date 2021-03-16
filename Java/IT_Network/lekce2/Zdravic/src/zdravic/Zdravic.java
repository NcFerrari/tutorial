/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zdravic;

/**
 * Třída reprezentuje zdravič, který slouží ke zdravení uživatelů
 *
 * @author NcFerrari
 */
public class Zdravic {

    /** 
    * Text pozdravu
     */
    private String volaciText;

    /**
     * Pozdraví uživatele textem pozdravu a jeho jménem
     *
     * @param jmeno jméno uživatele
     * @return Text s pozdravem
     */
    public String pozdrav(String jmeno) {
        return String.format("%s %s\n", volaciText, jmeno);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Zdravic zdravic = new Zdravic();
        zdravic.volaciText = "Ahoj uživateli";
        System.out.println(zdravic.pozdrav("Karel"));
        System.out.println(zdravic.pozdrav("Petr"));
        zdravic.volaciText = "Vítám tě tu programátore";
        System.out.println(zdravic.pozdrav("Richard"));
    }

}
