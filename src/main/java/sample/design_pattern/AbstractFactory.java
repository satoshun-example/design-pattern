/*
 * Copyright 2013 SatoShun
 *
 * Abstract Factory Pattern
 */

package sample.design_pattern;


interface IShapeFactory {
    IShape create(int width, int height);
}

interface IShape {
    double getSize();
}

// Rectangle
class RectangleFactory implements IShapeFactory {
    public IShape create(int width, int height) {
        return new Rectangle(width, height);
    }
}

class Rectangle implements IShape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getSize() {
        return width * height;
    }
}

// Triangle
class TriangleFactory implements IShapeFactory {
    public IShape create(int width, int height) {
        return new Triangle(width, height);
    }
}

class Triangle implements IShape {
    private double width;
    private double height;

    public Triangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getSize() {
        return width * height / 2;
    }
}


class AbstractFactory {
    public static void main(String[] args) {
        showShape(new RectangleFactory());
        showShape(new TriangleFactory());
    }

    private static void showShape(IShapeFactory factory) {
        IShape shape = factory.create(100, 200);
        System.out.println(shape.getSize());
    }
}
