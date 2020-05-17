public class MujVstupVystup {
    
    public static String jmeno() {
        String krestni = P.zadej("Zadejte své køestní jméno", "Pepa");
        String prijmeni = P.zadej("Zadejte své pøíjmení", "");
        String jmeno = krestni + " " + prijmeni;
        P.zprava("Jmenuješ se:\n\n" + jmeno);
        return jmeno;
    }
    
    public static int celociselneDeleni() {
        int delenec = P.zadej("Zadejte dìlence:", 10);
        int delitel = P.zadej("Zadejte delitele", 2);
        int podil = delenec / delitel;
        int zbytek = delenec % delitel;
        P.zprava("Podíl obou èísel je: " + podil + "(" + zbytek + ")");
        return podil;
    }
    
    public static double realneDeleni() {
        double delenec = P.zadej("Zadejte dìlence:", 10.0);
        double delitel = P.zadej("Zadejte delitele", 2.0);
        double podil = delenec / delitel;
        P.zprava("Podíl obou èísel je: " + podil);
        return podil;
    }
    
    private MujVstupVystup(){}
}