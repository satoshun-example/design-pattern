/*
 * Copyright 2013 SatoShun
 *
 * Vistor Pattern
 */

package sample.design_pattern;

/*
 * Vistor class
 */
class Driver {
    private int acceleration;

    public Driver(int acceleration) {
        this.acceleration = acceleration;
    }

    public void handle(Car car) {
        System.out.println("Car");
        System.out.println("accelerate " + acceleration);
    }

    public void handle(Bus bus) {
        System.out.println("Bus");
        System.out.println("accelerate " + acceleration);
    }
}

interface IVehicle {
    void accelerate(Driver driver);
}

class Car implements IVehicle {
    public void accelerate(Driver driver) {
        driver.handle(this);
    }
}

class Bus implements IVehicle {
    public void accelerate(Driver driver) {
        driver.handle(this);
    }
}

class Visitor {
    public static void main(String[] args) {
        Driver driver = new Driver(100);
        (new Bus()).accelerate(driver);
        (new Car()).accelerate(driver);
    }
}
