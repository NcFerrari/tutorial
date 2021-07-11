package jtable;

public enum Bydliste {

    PRAHA("Praha"),
    BRNO("Brno"),
    OSTRAVA("Ostrava"),
    LIBEREC("Liberec");

    private String city;

    private Bydliste(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

}
