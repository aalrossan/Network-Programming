package com.company;

public class Main implements Runnable {
    private long num;

    public Main(long num) {
        this.num = num;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 5; i < 20; i++) {
            Main m = new Main(i);
            Thread th = new Thread(m);
            if(i%2 == 1)
                th.setPriority(10);
            else
                th.setPriority(1);
            th.start();
            //  Thread.sleep(1);
        }
    }

    @Override
    public void run() {
        long fact = 1;
        for (int i = 2; i < num; i++) {
            fact *= i;
        }
        System.out.println("Num: " + num + ", Fact: " + fact);
    }
}
