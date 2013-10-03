/*
 * Copyright 2013 SatoShun
 *
 * Singleton Pattern
 */

package sample.design_pattern;


object SingletonClass {
    val value = 100

    def getSize() = {
        value * value
    }
}


object Singleton {
    def main(args: Array[String]) = {
        println(SingletonClass.value)
        println(SingletonClass.getSize())
    }
}
