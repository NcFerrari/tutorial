package ukoly11lekce.stredniPriklad;

public class Main {

    public static void main(String[] args) {
        Autobazar bbb = new Autobazar("B-B-B (3 betonové sloupy)", 5_000_000);

        Auto srot = new Auto("Škoda 120", "123ABC", 10_000);
        Auto kusPlechu = new Auto("Škoda Fabia", "456DEF", 100_000);
        Auto ferrari = new Auto("Ferrari FF", "789GHI", 3_000_000);
        Auto krava = new NakladniAuto("Tatra 811", "534NGS", 20, 50_000);
        Auto brzda = new NakladniAuto("Renault Midliner", "489GSR", 30, 100_000);

        bbb.koupitVozidlo(srot);
        bbb.koupitVozidlo(kusPlechu);
        bbb.koupitVozidlo(ferrari);
        bbb.koupitVozidlo(krava);
        bbb.koupitVozidlo(brzda);

        System.out.printf("V bazaru je %s automobilů\n", bbb.getPocetAutomobilu());
        System.out.printf("Na pokladně je %d Kč\n", bbb.getHotovostniPenize());
        System.out.printf("Celková cena automobilů je %d Kč\n", bbb.getCenaVsechVozidel());
    }
}
