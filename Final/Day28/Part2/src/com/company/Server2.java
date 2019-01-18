package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 implements Runnable {
    private ServerSocket server;
    private Socket client;

    public Server2() {
        try {
            server = new ServerSocket(9000);
        } catch (IOException e) {
            System.out.println("Error in server2");
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Server2 Waiting...");
                client = server.accept();

                Printer printer = new Printer(client);
                Thread printerTh = new Thread(printer);
                printerTh.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
