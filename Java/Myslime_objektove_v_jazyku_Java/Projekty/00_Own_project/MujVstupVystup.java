public class MujVstupVystup {
    
    public static String jmeno() {
        String krestni = P.zadej("Zadejte sv� k�estn� jm�no", "Pepa");
        String prijmeni = P.zadej("Zadejte sv� p��jmen�", "");
        String jmeno = krestni + " " + prijmeni;
        P.zprava("Jmenuje� se:\n\n" + jmeno);
        return jmeno;
    }
    
    public static int celociselneDeleni() {
        int delenec = P.zadej("Zadejte d�lence:", 10);
        int delitel = P.zadej("Zadejte delitele", 2);
        int podil = delenec / delitel;
        int zbytek = delenec % delitel;
        P.zprava("Pod�l obou ��sel je: " + podil + "(" + zbytek + ")");
        return podil;
    }
    
    public static double realneDeleni() {
        double delenec = P.zadej("Zadejte d�lence:", 10.0);
        double delitel = P.zadej("Zadejte delitele", 2.0);
        double podil = delenec / delitel;
        P.zprava("Pod�l obou ��sel je: " + podil);
        return podil;
    }
    
    private MujVstupVystup(){}
}