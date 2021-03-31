package tahovyboj;

public class Bojovnik {

    protected final String jmeno;
    protected final int maxHp;
    protected int hp;
    protected int utok;
    protected int obrana;
    protected Kostka kostka;
    protected String zprava;

    public Bojovnik(String jmeno, int maxHp, int utok, int obrana, Kostka kostka) {
        this.jmeno = jmeno;
        this.maxHp = this.hp = maxHp;
        this.utok = utok;
        this.obrana = obrana;
        this.kostka = kostka;
    }

    public String getJmeno() {
        return jmeno;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public int getUtok() {
        return utok;
    }

    public int getObrana() {
        return obrana;
    }

    public Kostka getKostka() {
        return kostka;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isNaZivu() {
        return getHp() > 0;
    }

    public String getZprava() {
        return zprava;
    }

    public String grafickyUkazatel(int aktualni, int maximalni) {
        String result = "";
        int celkem = 20;
        double pocet = Math.round(((double) aktualni / maximalni) * celkem);
        if ((pocet == 0) && (isNaZivu())) {
            pocet = 1;
        }
        for (int i = 0; i < pocet; i++) {
            result += "█";
        }
        for (int i = 0; i < celkem - pocet; i++) {
            result += " ";
        }
        return result;
    }

    public String zobrazZdravi() {
        return grafickyUkazatel(hp, maxHp);
    }

    public void branSe(int uder) {
        int zraneni = uder - (getObrana() + getKostka().hod());
        if (zraneni > 0) {
            hp -= zraneni;
            zprava = String.format("%s utrpěl poškození %s hp", getJmeno(), zraneni);
            if (hp < 0) {
                hp = 0;
                zprava += " a zemřel";
            }
        } else {
            zprava = String.format("%s odrazil útok", getJmeno());
        }
        nastavZpravu(zprava);
    }

    public void utoc(Bojovnik bojovnik) {
        int uder = getUtok() + getKostka().hod();
        nastavZpravu(String.format("%s útočí s úderem za %d hp", getJmeno(), uder));
        bojovnik.branSe(uder);
    }

    protected void nastavZpravu(String zprava) {
        this.zprava = zprava;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s", getJmeno(), zobrazZdravi());
    }
}
