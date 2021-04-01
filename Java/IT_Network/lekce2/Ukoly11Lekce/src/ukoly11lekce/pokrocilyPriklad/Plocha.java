package ukoly11lekce.pokrocilyPriklad;

import java.util.ArrayList;
import java.util.List;

public class Plocha {

    private final int vyskaPlochy;
    private final int sirkaPlochy;
    private final Kulicka kulicka;
    private final List<List<String>> plocha = new ArrayList<>();
    private final String przdnePole = " ";
    private int xPoziceKulicky = 1;
    private int yPoziceKulicky = 1;

    public Plocha(int sirkaPlochy, int vyskaPlochy, Kulicka kulicka) {
        this.sirkaPlochy = sirkaPlochy;
        this.vyskaPlochy = vyskaPlochy;
        this.kulicka = kulicka;
        for (int i = 0; i < vyskaPlochy; i++) {
            List<String> radek = new ArrayList<>();
            for (int j = 0; j < sirkaPlochy; j++) {
                if (i == 0 || i == vyskaPlochy - 1) {
                    if (j == 0 || j == sirkaPlochy - 1) {
                        radek.add("+");
                    } else {
                        radek.add("-");
                    }
                } else {
                    if (j == 0 || j == sirkaPlochy - 1) {
                        radek.add("|");
                    } else {
                        radek.add(przdnePole);
                    }
                }
            }
            plocha.add(radek);
        }
        prekresli();
    }

    public int getVyskaPlochy() {
        return vyskaPlochy;
    }

    public int getSirkaPlochy() {
        return sirkaPlochy;
    }

    public void prekresli() {
        plocha.get(yPoziceKulicky).set(xPoziceKulicky, przdnePole);
        if (kulicka.getY() > 0 && kulicka.getY() < plocha.size() - 1) {
            List<String> radek = plocha.get(kulicka.getY());
            if (kulicka.getX() > 0 && kulicka.getX() < radek.size() - 1) {
                radek.set(kulicka.getX(), kulicka.getSymbol());
                vykresli();
                xPoziceKulicky = kulicka.getX();
                yPoziceKulicky = kulicka.getY();
            } else {
                System.out.println("CHYBA! souřadnice x je mimo herní plochu!");
            }
        } else {
            System.out.println("CHYBA! souřadnice y je mimo herní plochu!");
        }
    }

    private void vykresli() {
        for (int i = 0; i < vyskaPlochy; i++) {
            System.out.println();
        }
        plocha.forEach(radek -> {
            radek.forEach(pole -> System.out.print(pole));
            System.out.println();
        });
    }

    public void pridejCihlicky(List<Tvar> cihlicky) {
        cihlicky.forEach(cihla -> {
            plocha.get(cihla.getY()).set(cihla.getX(), cihla.getSymbol());
        });
        prekresli();
    }
}
