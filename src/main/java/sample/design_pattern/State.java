/*
 * Copyright 2013 SatoShun
 *
 * State Pattern
 */

package sample.design_pattern;


interface IWeather {
    void compute();
}


class Morning implements IWeather {
    public void compute() {
        System.out.println("Good Morning");
    }
}


class Evening implements IWeather {
    public void compute() {
        System.out.println("Good Evening");
    }
}


class Night implements IWeather {
    public void compute() {
        System.out.println("Good Night");
    }
}


class State {
    public static void main(String[] args) {
        say(new Morning());
        say(new Night());
        say(new Evening());
    }

    private static void say(IWeather weather) {
        weather.compute();
    }
}
