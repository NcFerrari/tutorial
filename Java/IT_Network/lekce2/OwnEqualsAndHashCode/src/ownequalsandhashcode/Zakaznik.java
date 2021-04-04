package ownequalsandhashcode;

import java.time.LocalDate;
import java.util.Objects;

public class Zakaznik implements Cloneable {

    private String jmeno;
    private String prijmeni;
    private LocalDate datumNarozeni;

    public Zakaznik(String jmeno, String prijmeni, LocalDate datumNarozeni) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.datumNarozeni = datumNarozeni;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.jmeno);
        hash = 61 * hash + Objects.hashCode(this.prijmeni);
        hash = 61 * hash + Objects.hashCode(this.datumNarozeni);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zakaznik other = (Zakaznik) obj;
        if (!Objects.equals(this.jmeno, other.jmeno)) {
            return false;
        }
        if (!Objects.equals(this.prijmeni, other.prijmeni)) {
            return false;
        }
        if (!Objects.equals(this.datumNarozeni, other.datumNarozeni)) {
            return false;
        }
        return true;
    }

    public Object clone() throws CloneNotSupportedException {
        Zakaznik zakaznik = (Zakaznik) super.clone();
        return zakaznik;
    }

}
