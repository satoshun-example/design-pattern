/*
 * Copyright 2013 SatoShun
 *
 * Singleton Pattern
 */

package sample.design_pattern;


object SingletonClass {
    val value = 100
}


object Singleton {
    def main(args: Array[String]) = {
        println(SingletonClass.value)
    }
}
