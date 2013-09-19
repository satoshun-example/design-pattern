/*
 * Copyright 2013 SatoShun
 *
 * Callback Pattern
 */

package sample.design_pattern.etc;


class ExecuteCallback {
    public void calculate(ICallback callback) {
        int total = 0;
        for (int i = 0; i < 10; i++) {
            total += i;
        }

        callback.execute(total);
    }
}


interface ICallback {
    void execute(int value);
}


class Callback {
    public static void main(String[] args) {
        ExecuteCallback exe = new ExecuteCallback();

        exe.calculate(new ICallback() {
            @Override
            public void execute(int value) {
                System.out.println("result : " + value);
            }
        });
    }
}
