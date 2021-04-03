package poznamkovac;

import java.time.LocalDateTime;

public class Zaznam {

    private LocalDateTime datumCas;
    private String text;

    public Zaznam(LocalDateTime datumCas, String text) {
        this.datumCas = datumCas;
        this.text = text;
    }

    public LocalDateTime getDatumCas() {
        return datumCas;
    }

    public void setDatumCas(LocalDateTime datumCas) {
        this.datumCas = datumCas;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return Diar.FORMAT_DATA.format(datumCas) + " " + text;
    }
}
