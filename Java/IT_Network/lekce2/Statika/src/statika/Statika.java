package statika;

public class Statika {

    public static void main(String[] args) {
        Uzivatel u = new Uzivatel("Tomáš Marný", "heslojeveslo");
        System.out.printf("ID prvního uživatele: %s\n", u.getId());
        Uzivatel v = new Uzivatel("Olí Znusinudle", "csfd1fg");
        System.out.printf("ID druhého uživatele: %s\n", v.getId());
        System.out.printf("Minimální délka hesla uživatele je: %s\n", Uzivatel.getMinimalniDelkaHesla());
        System.out.printf("Validnost hesla \"heslo\" je: %s", Uzivatel.zvalidujHeslo("heslo"));
    }
}
