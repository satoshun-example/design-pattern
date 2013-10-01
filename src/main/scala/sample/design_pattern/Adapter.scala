/*
 * Copyright 2013 SatoShun
 *
 * Adapter Pattern
 */

package sample.design_pattern;


trait IProduct {
    def getSize(): Double;
}


class Product(val width: Double, val height: Double) extends IProduct {
    def getSize(): Double = {
        width * height
    }
}


class NewProduct(val width: Double, val height: Double, val mass: Double) {
    def getMass(): Double = {
        width * height * mass
    }
}

class AdapterProduct(val product: NewProduct) extends IProduct {
    def getSize(): Double = {
        product.getMass()
    }
}


object Adapter {
    def main(args: Array[String]) = {
        val adapter: IProduct = new AdapterProduct(
            new NewProduct(10.0D, 20.0D, 10.0D));
        showProduct(adapter)
        showProduct(new Product(10.0D, 30.0D))
    }

    private def showProduct(product: IProduct) = {
        println(product.getSize())
    }
}
