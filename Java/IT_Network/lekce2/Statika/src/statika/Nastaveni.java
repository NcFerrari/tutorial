package statika;

public class Nastaveni {

    private static String jazyk = "CZ";
    private static String barevneSchem = "cervene";
    private static boolean spustitPoStartu = true;

    private Nastaveni() {

    }

    public static String getJazyk() {
        return jazyk;
    }

    public static String getBarevneSchem() {
        return barevneSchem;
    }

    public static boolean isSpustitPoStartu() {
        return spustitPoStartu;
    }

}
