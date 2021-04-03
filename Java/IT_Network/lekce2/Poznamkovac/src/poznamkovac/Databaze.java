package poznamkovac;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Databaze {

    private final List<Zaznam> zaznamy = new ArrayList<>();

    public void pridejZaznam(LocalDateTime datumCas, String text) {
        zaznamy.add(new Zaznam(datumCas, text));
    }

    public List<Zaznam> najdiZaznamy(LocalDateTime datum, boolean dleCasu) {
        List<Zaznam> result = new ArrayList<>();
        for (Zaznam zaznam : zaznamy) {
            if ((dleCasu && zaznam.getDatumCas().equals(datum)) || (!dleCasu && zaznam.getDatumCas().toLocalDate().equals(datum.toLocalDate()))) {
                result.add(zaznam);
            }
        }
        return result;
    }

    public List<Zaznam> getVsechnyZaznamy() {
        return zaznamy;
    }

    public void vymazZaznamy(LocalDateTime datum) {
        for (Zaznam zaznam : najdiZaznamy(datum, true)) {
            zaznamy.remove(zaznam);
        }
    }
}
