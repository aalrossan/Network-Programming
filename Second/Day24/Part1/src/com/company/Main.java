package com.company;

public class Main {

    public static void main(String[] args) {
        int[] numInts = {789654126, 15639874, 896521473, 998517266, 185485968};

        for (int i = 0; i < numInts.length; i++) {
            PrimeNumber primeNumber = new PrimeNumber(numInts[i]);
            Thread th = new Thread(primeNumber);
            th.start();
        }
    }
}
