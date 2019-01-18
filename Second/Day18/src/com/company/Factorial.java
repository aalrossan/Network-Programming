package com.company;

public class Factorial implements Runnable {
    private long num;
    private long fact;

    public Factorial(long num) {
        this.num = num;
        this.fact = 1;
    }

    public void calculationFactorial() {
        for (int i = 2; i < num; i++) {
            fact *= i;
        }
    }

    @Override
    public void run() {
        calculationFactorial();
        System.out.println("num: " + num + ", fact: " + getFact());
    }

    public long getFact()
    {
        return fact;
    }
}
