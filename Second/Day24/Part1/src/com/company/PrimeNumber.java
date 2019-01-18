package com.company;

public class PrimeNumber implements Runnable {
    private int num;

    public PrimeNumber(int num) {
        this.num = num;
    }

    public void calculatePrimeNumber() {
        for (int i = 2; i < num; i++) {
            int z = num % i;
            if (z != 0) continue;
            System.out.println("Divisors (" + num + ") = " + i + ", ");
        }
    }

    @Override
    public void run() {
        long s = System.currentTimeMillis();
        calculatePrimeNumber();
        long e = System.currentTimeMillis();
        System.out.println("Time " + num + " is: " + (e-s));
    }
}
