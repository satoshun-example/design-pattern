/*
 * Copyright 2013 SatoShun
 *
 * Adapter Pattern
 */

package sample.design_pattern;


interface IProduct {
    double getSize();
}


class Product implements IProduct {
    private double width;
    private double height;

    public Product(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getSize() {
        return width * height;
    }
}


class NewProduct {
    private double width;
    private double height;
    private double mass;

    public NewProduct(double width, double height, double mass) {
        this.width = width;
        this.height = height;
        this.mass = mass;
    }

    public double getMass() {
        return width * height * mass;
    }
}


class AdapterProduct implements IProduct {
    private NewProduct product;

    public AdapterProduct(NewProduct product) {
        this.product = product;
    }

    public double getSize() {
        return product.getMass();
    }
}


class Adapter {
    public static void main(String[] args) {
        IProduct product = new Product(10, 20);
        showProduct(product);

        product = new AdapterProduct(new NewProduct(10, 20, 5));
        showProduct(product);
    }

    private static void showProduct(IProduct product) {
        System.out.println(product.getSize());
    }
}
