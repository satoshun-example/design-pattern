/*
 * Copyright 2013 SatoShun
 *
 * Memento Pattern
 */

package sample.design_pattern;


class Factorial {
    private int currentValue;
    private int currentTotal;

    public Factorial() {
        currentValue = 0;
        currentTotal = 1;
    }

    public int nextValue() {
        return (currentTotal = currentTotal * ++currentValue);
    }

    public FactorialMemento createMemento() {
        FactorialMemento memento = new FactorialMemento(currentValue, currentTotal);
        return memento;
    }

    public void setMemento(FactorialMemento memento) {
        currentValue = memento.getCurrentValue();
        currentTotal = memento.getCurrentTotal();
    }
}


class FactorialMemento {
    private int currentValue;
    private int currentTotal;

    public FactorialMemento(int currentValue, int currentTotal) {
        this.currentValue = currentValue;
        this.currentTotal = currentTotal;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public int getCurrentTotal() {
        return currentTotal;
    }
}


class Memento {
    public static void main(String[] args) {
        Factorial factorial = new Factorial();

        for (int i = 0; i < 10; i++) {
            System.out.println(factorial.nextValue());
        }

        FactorialMemento memento = factorial.createMemento();

        Factorial factorial2 = new Factorial();
        factorial2.setMemento(memento);

        // start from the middle
        System.out.println(factorial2.nextValue());
    }
}
