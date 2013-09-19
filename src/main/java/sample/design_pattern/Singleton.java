/*
 * Copyright 2013 SatoShun
 *
 * Singleton Pattern
 */

package sample.design_pattern;


class SingletonClass {
    private static SingletonClass instance;

    private SingletonClass(){}

    public static SingletonClass getInstance() {
        if (instance == null) {
            instance = new SingletonClass();
        }

        return instance;
    }
}


class NoSingletonClass {
    private NoSingletonClass(){}

    public static NoSingletonClass getInstance() {
        return new NoSingletonClass();
    }
}


class Singleton {
    public static void main(String[] args) {
        System.out.println(SingletonClass.getInstance() == SingletonClass.getInstance());
        System.out.println(NoSingletonClass.getInstance() == NoSingletonClass.getInstance());
    }
}
