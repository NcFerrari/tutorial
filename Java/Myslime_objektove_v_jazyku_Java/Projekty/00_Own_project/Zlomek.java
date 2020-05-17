

public class Zlomek {
    
    private int citatel;
    private int jmenovatel;
    
    public Zlomek(int citatel, int jmenovatel) {
        int a = citatel;
        int b = jmenovatel;
        while(b > 0) {
            int zbytek = a % b;
            a = b;
            b = zbytek;
        }
        this.citatel = citatel / a;
        this.jmenovatel = jmenovatel / a;
    }
    
    public int getCitatel() {
        return citatel;
    }
    
    public int getJmenovatel() {
        return jmenovatel;
    }
    
    public Zlomek pricti(int druhyCitatel, int druhyJmenovatel) {
        int novyCitatel = druhyJmenovatel * getCitatel() + getJmenovatel() * druhyCitatel;
        int novyJmenovatel = getJmenovatel() * druhyJmenovatel;
        return new Zlomek(novyCitatel, novyJmenovatel);
    }
    
    public Zlomek pricti(int cislo) {
        return pricti(cislo, 1);
    }
    
    public Zlomek odecti(int druhyCitatel, int druhyJmenovatel) {
        return pricti(-druhyCitatel, druhyJmenovatel);
    }
    
    public Zlomek odecti(int cislo) {
        return odecti(cislo, 1);
    }
    
    public Zlomek vynasob(int druhyCitatel, int druhyJmenovatel) {
        int novyCitatel = getCitatel() * druhyCitatel;
        int novyJmenovatel = getJmenovatel() * druhyJmenovatel;
        return new Zlomek(novyCitatel, novyJmenovatel);
    }
    
    public Zlomek vynasob(int cislo) {
        return vynasob(cislo, 1);
    }
    
    public Zlomek vydel(int druhyCitatel, int druhyJmenovatel) {
        return vynasob(druhyJmenovatel, druhyCitatel);
    }
    
    public Zlomek vydel(int cislo) {
        return vydel(cislo, 1);
    }
}
