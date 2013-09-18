/*
 * Copyright 2013 SatoShun
 *
 * Prototype Pattern
 */

package sample.design_pattern;


class Car {
    private int weight;
    private int mileage;
    private double speed;

    public Car(int weight, int mileage) {
        this.weight = weight;
        this.mileage = mileage;
        speed = 0;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Car clone() {
        Car car = new Car(weight, mileage);
        car.setSpeed(speed);
        return car;
    }

    public String toString() {
        return weight + "," + mileage + "," + speed;
    }
}


class Prototype {
    public static void main(String[] args) {
        Car car = new Car(100, 200);
        car.setSpeed(20.5);
        System.out.println(car);

        Car cloneCar = car.clone();
        System.out.println(cloneCar);
    }
}
