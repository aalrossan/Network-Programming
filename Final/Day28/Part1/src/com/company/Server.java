package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private ServerSocket server;
    private Socket client;

    public Server() {
        try {
            server = new ServerSocket(9000);
        } catch (IOException e) {
            System.out.println("Error in server socket");
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                client = server.accept();
                GCD gcd = new GCD(client);
                Thread th = new Thread(gcd);
                th.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
