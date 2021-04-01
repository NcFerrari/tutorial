package ukoly9lekce.jednoduchyPriklad;

public class Prevodnik {

    public static double radianyNaStupne(double radiany) {
        return (180 / Math.PI) * radiany;
    }

    public static double stupneNaRadiany(double stupne) {
        return (Math.PI / 180) * stupne;
    }
}
