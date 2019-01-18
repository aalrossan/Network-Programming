package com.company;

public class Main {

    public static void main(String[] args) {
        Server1 server1 = new Server1();
        Thread s1Th = new Thread(server1);
        s1Th.start();

        Server2 server2 = new Server2();
        Thread s2Th = new Thread(server2);
        s2Th.start();

        Client client = new Client("112940");
        Thread cTh = new Thread(client);
        cTh.run();
    }
}
