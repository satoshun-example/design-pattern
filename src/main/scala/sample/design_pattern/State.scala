/*
 * Copyright 2013 SatoShun
 *
 * State Pattern
 */

package sample.design_pattern;

trait IWeather {
    def compute(): Unit;
}


class Morning extends IWeather {
    def compute() = println("Good Morning")
}


class Evening extends IWeather {
    def compute() = println("Good Evening")
}


class Night extends IWeather {
    def compute() = println("Good Night")
}


object State {
    def main(args: Array[String]) = {
        say(new Morning())
        say(new Evening())
        say(new Night())
    }

    private def say(weather: IWeather) = weather.compute()
}
