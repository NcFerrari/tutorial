package ukoly9lekce.stredniPriklad;

public class TovarnaNaCukrovi {

    public static Cukrovi getBanana() {
        return new Cukrovi("žlutá", "kulatý", 20);
    }

    public static Cukrovi getJahoda() {
        return new Cukrovi("červená", "kulatý", 15);
    }

    public static Cukrovi getCoko() {
        return new Cukrovi("hnědá", "hranatý", 25);
    }
}
