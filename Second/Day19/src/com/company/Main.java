package com.company;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService ex = Executors.newFixedThreadPool(10);
        for (int i = 5; i < 20; i++) {
            Factorial factorial = new Factorial(i);
            Future<Integer> f = ex.submit(factorial);
            System.out.println("num: " + i + ", fact: " + f.get());
        }
    }
}
