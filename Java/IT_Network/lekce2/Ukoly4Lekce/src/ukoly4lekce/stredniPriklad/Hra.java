package ukoly4lekce.stredniPriklad;

import java.util.Scanner;

public class Hra {

    private Lokace aktualniLokace;

    public Hra(Lokace lokace) {
        aktualniLokace = lokace;
    }

    public boolean jdiNa(String strana) {
        switch (strana) {
            case "jdi na východ":
                if (aktualniLokace.getVychod() != null) {
                    aktualniLokace = aktualniLokace.getVychod();
                } else {
                    nelzeJit();
                }
                break;
            case "jdi na jih":
                if (aktualniLokace.getJih() != null) {
                    aktualniLokace = aktualniLokace.getJih();
                } else {
                    nelzeJit();
                }
                break;
            case "jdi na západ":
                if (aktualniLokace.getZapad() != null) {
                    aktualniLokace = aktualniLokace.getZapad();
                } else {
                    nelzeJit();
                }
                break;
            case "jdi na sever":
                if (aktualniLokace.getSever() != null) {
                    aktualniLokace = aktualniLokace.getSever();
                } else {
                    nelzeJit();
                }
                break;
            case "konec":
                return konec();
            default:
                spatnyVstup();
        }
        return true;
    }

    public boolean konec() {
        return false;
    }

    public void nelzeJit() {
        System.out.println("Tímto směrem nelze jít.");
    }

    public void spatnyVstup() {
        System.out.println("Můj vstupní slovník neobsahuje tento příkaz.");
    }

    public Lokace getLokace() {
        return aktualniLokace;
    }
}
