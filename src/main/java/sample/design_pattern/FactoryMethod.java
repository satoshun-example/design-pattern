/*
 * Copyright 2013 SatoShun
 *
 * Factory Method Pattern
 */

package sample.design_pattern;


interface IProduct {
    void showName();
}


class PersonalComputer implements IProduct {
    public void showName() {
        System.out.println("personal computer");
    }
}


class Grocery implements IProduct {
    public  void showName() {
        System.out.println("grocery");
    }
}


abstract class Store {
    public void buy() {
        IProduct product = createProduct();
        System.out.println("***buy***");
        product.showName();
    }

    abstract protected IProduct createProduct();
}


class ComputerStore extends Store {
    protected IProduct createProduct() {
        return new PersonalComputer();
    }
}


class GroceryStore extends Store {
    protected IProduct createProduct() {
        return new Grocery();
    }
}


class FactoryMethod {
    public static void main(String[] args) {
        Store store = new ComputerStore();
        store.buy();

        store = new GroceryStore();
        store.buy();
    }
}
