package tahovyboj;

public class Bojovnik {

    private final String jmeno;
    private final int maxHp;
    private int hp;
    private int utok;
    private int obrana;
    private Kostka kostka;
    private String zprava;

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

    public String zobrazZdravi() {
        String hpBar = "(";
        for (int i = 0; i < getMaxHp(); i += 10) {
            if (i < getHp()) {
                hpBar += "#";
            } else {
                hpBar += " ";
            }
        }
        hpBar += ") [" + getHp() + "/" + getMaxHp() + "]";
        return hpBar;
    }

    public void branSe(int uder) {
        int zraneni = uder - (getObrana() + getKostka().hod());
        if (zraneni > 0) {
            hp -= zraneni;
            zprava = String.format("%s utrpěl poškození %s hp", getJmeno(), zraneni);
            if (hp < 0) {
                hp = 0;
            }
        } else {
            zprava = String.format("%s odrazil útok", getJmeno());
        }
    }

    public void utoc(Bojovnik bojovnik) {
        int uder = getUtok() + getKostka().hod();
        nastavZpravu(String.format("%s útočí s úderem za %d hp", getJmeno(), uder));
        bojovnik.branSe(uder);
    }

    private void nastavZpravu(String zprava) {
        this.zprava = zprava;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s", getJmeno(), zobrazZdravi());
    }
}
