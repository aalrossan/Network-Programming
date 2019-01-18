package com.company;

public class Main {

    public static void main(String[] args) {
        String[] eq={"2*8","6-9","5+3","49/7"};

        Server server = new Server();
        Thread sth = new Thread(server);
        sth.start();


        for (int i = 0; i < eq.length; i++) {
            Client client = new Client(eq[i]);
            Thread cth = new Thread(client);
            cth.start();
        }
    }
}
