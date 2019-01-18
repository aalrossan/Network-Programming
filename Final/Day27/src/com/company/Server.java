package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private static ServerSocket server;
    private static Socket client;

    public Server() {
        try {
            System.out.println("Server Waiting...");
            server = new ServerSocket(9000);
        } catch (IOException e) {
            System.out.println("Error in server socket");
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                client = server.accept();
                FactThread factThread = new FactThread(client);
                Thread th = new Thread(factThread);
                th.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
