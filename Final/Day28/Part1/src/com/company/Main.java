package com.company;

public class Main {

    public static void main(String[] args) {
        Server server = new Server();
        Thread sth = new Thread(server);
        sth.start();

        long[] numbers = { 24, 18, 2048, 96, 79632, 39, 1048576, 710 };

        for (int i = 0; i < numbers.length; i += 2) {
            Client client = new Client(numbers[i], numbers[i+1]);
            Thread cth = new Thread(client);
            cth.run();
        }
    }
}
