package com.company;

import java.util.concurrent.Callable;

public class Factorial implements Callable<Integer> {
    private Integer num;
    private Integer fact;

    public Factorial(Integer num) {
        this.num = num;
        fact = 1;
    }

    public Integer calculationFactorial() {
        for (int i = 2; i < num; i++) {
            fact *= i;
        }
        return fact;
    }

    @Override
    public Integer call() throws Exception {
        return calculationFactorial();
    }
}
