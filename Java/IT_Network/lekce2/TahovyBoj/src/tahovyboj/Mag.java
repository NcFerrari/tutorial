package tahovyboj;

public class Mag extends Bojovnik {

    private final int maxMana;
    private int mana;
    private int magickyUtok;

    public Mag(String jmeno, int maxHp, int maxMana, int utok, int magickyUtok, int obrana, Kostka kostka) {
        super(jmeno, maxHp, utok, obrana, kostka);
        this.maxMana = this.mana = maxMana;
        this.magickyUtok = magickyUtok;
    }

    @Override
    public void utoc(Bojovnik bojovnik) {
        int uder = 0;
        if (mana < maxMana) {
            mana += 10;
            if (mana > maxMana) {
                mana = maxMana;
            }
            super.utoc(bojovnik);
        } else {
            uder = magickyUtok + getKostka().hod();
            nastavZpravu(String.format("%s použil magii za %s hp", getJmeno(), uder));
            bojovnik.branSe(uder);
            mana = 0;
        }
    }
    
    public String zobrazManu() {
        return grafickyUkazatel(mana, maxMana);
    }

}
