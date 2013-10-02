/*
 * Copyright 2013 SatoShun
 *
 * Facade Pattern
 */

package sample.design_pattern;


import scala.collection.mutable.Map

class Basket {
    var productList: List[String] = List()

    def add(product: String) = productList = productList :+ product

    def clear() = productList = List.empty[String]

    def getAll(): List[String] = productList
}


class Customer {
    var basket: Basket = new Basket()

    def add(product: String) = basket.add(product)

    def getAll(): Map[String, Integer] = {
        val basketContents = basket.getAll()
        val result = Map.empty[String, Integer]

        basketContents.foreach({key =>
            key match {
                case key if result.contains(key) => result(key) += 1
                case _ => result(key) = 1
            }
        })
        return result;
    }
}


class Buying {
    def process() = {
        val customer = new Customer()

        customer.add("meat");
        customer.add("wine");
        customer.add("meat");
        customer.add("meat");

        println(customer.getAll())
    }
}

object Facade {
    def main(args: Array[String]) = {
        val buying = new Buying()
        buying.process()
    }
}
