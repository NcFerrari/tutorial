package ukoly4lekce.stredniPriklad;

public class Lokace {

    private String nazev;
    private String popis;
    private Lokace sever;
    private Lokace vychod;
    private Lokace jih;
    private Lokace zapad;

    public Lokace(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
    }

    public Lokace getSever() {
        return sever;
    }

    public void setSever(Lokace sever) {
        this.sever = sever;
    }

    public Lokace getVychod() {
        return vychod;
    }

    public void setVychod(Lokace vychod) {
        this.vychod = vychod;
    }

    public Lokace getJih() {
        return jih;
    }

    public void setJih(Lokace jih) {
        this.jih = jih;
    }

    public Lokace getZapad() {
        return zapad;
    }

    public void setZapad(Lokace zapad) {
        this.zapad = zapad;
    }

    public String getNazev() {
        return nazev;
    }

    public String getPopis() {
        return popis;
    }

    public Lokace setSousedniLokace(Lokace severniLokace, Lokace vychodniLokace, Lokace jizniLokace, Lokace zapadniLokace) {
        setSever(severniLokace);
        setVychod(vychodniLokace);
        setJih(jizniLokace);
        setZapad(zapadniLokace);
        return this;
    }

    public String mozneCesty() {
        String cesty = "";
        cesty += getSever() != null ? "sever " : "";
        cesty += getVychod() != null ? "východ " : "";
        cesty += getJih() != null ? "jih " : "";
        cesty += getZapad() != null ? "západ " : "";
        return cesty;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s\n\nMůžeš jít na %s\n", getNazev(), getPopis(), mozneCesty());
    }
}
