package com.company;

public class Main {

    public static void main(String[] args) {
        for (int i = 5; i < 20; i++) {
            Factorial factorial = new Factorial(i);

            // With Thread
            Thread th = new Thread(factorial);
            th.start();

            // Without Thread
            // factorial.calculationFactorial();
        }
    }
}
