package com.company;

public class Main {

    public static void main(String[] args) {
        Server server = new Server();
        Thread sth = new Thread(server);
        sth.start();

        for (int i = 5; i < 20; i++) {
            Client client = new Client(i);
            Thread cth = new Thread(client);
            cth.run();
        }
    }
}
