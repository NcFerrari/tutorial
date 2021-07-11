package jtable;

public class Osoba {

    private int id;
    private String jmeno;
    private String prijmeni;
    private int vek;
    private Bydliste bydliste;
    private static int posledni = 0;

    public Osoba(String jmeno, String prijmeni, int vek, Bydliste bydliste) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.bydliste = bydliste;
        id = posledni++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public int getVek() {
        return vek;
    }

    public void setVek(int vek) {
        this.vek = vek;
    }

    public Bydliste getBydliste() {
        return bydliste;
    }

    public void setBydliste(Bydliste bydliste) {
        this.bydliste = bydliste;
    }

}
