/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukoly2lekce;

/**
 *
 * @author NcFerrari
 */
public class StredniPriklad {

    private final int maxCargo = 3000;
    private int cargo = 0; //(kg)

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    /**
     * increase cargo value by kilograme
     *
     * @param cargo
     */
    public int loadCargoKg(int cargo) {
        if (getCargo() + cargo <= maxCargo) {
            setCargo(getCargo() + cargo);
        }
        return getCargo();
    }

    /**
     * increase cargo value by tonne
     *
     * @param cargo
     */
    public int loadCargoT(int cargo) {
        return loadCargoKg(cargo * 1000);
    }

    /**
     * decrease cargo value by kilograme
     *
     * @param cargo
     */
    public int interpretCargoKg(int cargo) {
        if (cargo <= getCargo()) {
            setCargo(getCargo() - cargo);
        }
        return getCargo();
    }

    /**
     * decrease cargo value by tonne
     *
     * @param cargo
     */
    public int interpretCargoT(int cargo) {
        return interpretCargoKg(cargo * 1000);
    }

    public static void main(String[] args) {
        StredniPriklad lorry = new StredniPriklad();
        lorry.loadCargoT(10);
        lorry.loadCargoKg(500);
        lorry.interpretCargoKg(300);
        lorry.interpretCargoT(1);
        System.out.println("V nákladním autě je naloženo " + lorry.getCargo() + " kg");
    }
}
