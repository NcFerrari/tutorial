package ukoly11lekce.pokrocilyPriklad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        final Random random = new Random();
        final List<Tvar> cihlicky = new ArrayList<>();
        final Kulicka kulicka = new Kulicka(7, 5, "O");
        Plocha plocha = new Plocha(17, 7, kulicka);
        for (int i = 0; i < 11; i++) {
            cihlicky.add(new Tvar(3 + i, 2, "#"));
        }
        plocha.pridejCihlicky(cihlicky);

        new Thread(() -> {
            try {
                while (!cihlicky.isEmpty()) {
                    Thread.sleep(250);

                    kulicka.setPozice(kulicka.getX() + kulicka.getSmerX(), kulicka.getY() + kulicka.getSmerY());
                    if (kulicka.getX() == plocha.getSirkaPlochy() - 2 || kulicka.getX() == 1) {
                        kulicka.zmenSmerX();
                    }
                    if (kulicka.getY() == 1) {
                        kulicka.zmenSmerY();
                    }
                    if (kulicka.getY() == plocha.getVyskaPlochy() - 2) {
                        kulicka.zmenSmerY();
                        if (random.nextBoolean()) {
                            kulicka.setX(random.nextInt(plocha.getSirkaPlochy() - 3) + 2);
                        }
                    }
                    plocha.prekresli();
                    for (Tvar cihla : cihlicky) {
                        if (kulicka.getX() == cihla.getX() && kulicka.getY() == cihla.getY()) {
                            cihlicky.remove(cihla);
                            kulicka.zmenSmerY();
                            break;
                        }
                    }
                }
                System.out.println("KONEC HRY");
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }
}
