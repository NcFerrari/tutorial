/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukoly3lekce;

/**
 *
 * @author NcFerrari
 */
public class PokrocilyPriklad {

    public PokrocilyPriklad() {
        Garage garage = new Garage();
        Car car = new Car("123ABC");
        car.park(garage);
        System.out.println(garage);
    }

    private class Car {

        private String sPZ;
        private String color;

        public Car(String sPZ) {
            this.sPZ = sPZ;
        }

        public void park(Garage garage) {
            garage.addCar(this);
        }

        @Override
        public String toString() {
            return sPZ;
        }
    }

    private class Garage {

        private Car car;

        public void addCar(Car car) {
            this.car = car;
        }

        @Override
        public String toString() {
            return "V garáži je auto: " + car;
        }
    }

    public static void main(String[] args) {
        new PokrocilyPriklad();
    }
}
