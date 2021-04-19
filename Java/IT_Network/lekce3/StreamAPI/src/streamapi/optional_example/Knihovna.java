package streamapi.optional_example;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Knihovna implements IKnihovna {

    private final Map<String, Kniha> db = new HashMap<>();

    @Override
    public void pridej(Kniha kniha) {
        db.put(kniha.getNazev(), kniha);
    }

    @Override
    public void odstran(Kniha kniha) {
        db.remove(kniha);
    }

    @Override
    public Kniha najdiKnihu(String nazev) {
        return db.get(nazev);
    }

    @Override
    public Optional<Kniha> najdiKnihuBezpecne(String nazev) {
        return Optional.ofNullable(db.get(nazev));
    }

}
