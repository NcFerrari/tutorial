package ukoly17az19lekce.stredniPriklad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bedna {

    private int maximalniVaha;
    private int aktualniVaha = 0;
    private final List<Nastroj> nastroje = new ArrayList<>();

    public Bedna(int maximalniVaha) {
        this.maximalniVaha = maximalniVaha;
    }

    public int getMaximalniVaha() {
        return maximalniVaha;
    }

    public void vlozitNastroj(Nastroj nastroj) {
        if (nastroj.getVaha() + aktualniVaha <= maximalniVaha) {
            aktualniVaha += nastroj.getVaha();
            nastroje.add(nastroj);
        }
    }

    public void vyndejNastroj(Nastroj nastroj) {
        if (nastroje.contains(nastroj)) {
            aktualniVaha -= nastroj.getVaha();
            nastroje.remove(nastroj);
        }
    }

    public int zjistiVahuObourcnichKladiv() {
        int sum = 0;
        for (Nastroj nastroj : nastroje) {
            if (nastroj instanceof Kladivo && ((Kladivo) nastroj).isObourucni()) {
                sum += nastroj.getVaha();
            }
        }
        return sum;
    }

    public List<Nastroj> getNastroje() {
        return Collections.unmodifiableList(nastroje);
    }

    public void vypisZBedny() {
        if (nastroje.isEmpty()) {
            System.out.println("Bedna je prázdná.");
        } else {
            String prefix = "";
            System.out.print("V bedně je: ");
            for (Nastroj nastroj : getNastroje()) {
                System.out.print(prefix + nastroj.getNazev());
                prefix = ", ";
            }
            System.out.println();
        }
    }
}
