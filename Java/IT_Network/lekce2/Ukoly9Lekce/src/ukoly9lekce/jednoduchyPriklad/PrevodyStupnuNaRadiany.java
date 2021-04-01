package ukoly9lekce.jednoduchyPriklad;

public class PrevodyStupnuNaRadiany {

    public static void main(String[] args) {
        double radiany = 6.28;
        int stupne = 90;
        System.out.println(radiany + " radiánů na stupně: " + Prevodnik.radianyNaStupne(radiany));
        System.out.println(stupne + " stupňů na radiány: " + Prevodnik.stupneNaRadiany(stupne));
    }
}