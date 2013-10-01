/*
 * Copyright 2013 SatoShun
 *
 * Abstract Factory Pattern
 */

package sample.design_pattern;


trait IShapeFactory {
    def create(width: Double, height: Double): IShape;
}


trait IShape {
    def getSize(): Double;
}


class RectangleFactory extends IShapeFactory {
    def create(width: Double, height: Double): IShape = {
        new Rectangle(width, height)
    }
}


class Rectangle(val width: Double, val height: Double) extends IShape {
    def getSize(): Double = {
        width * height
    }
}


object AbstractFactory {
    def main(args: Array[String]) = {
        val factory: IShapeFactory = new RectangleFactory();
        val shape: IShape = factory.create(2.0D, 3.2D)
        println(shape.getSize())
    }
}
