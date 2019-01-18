package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 implements Runnable {
    private ServerSocket server;
    private Socket client;

    public Server1() {
        try {
            server = new ServerSocket(8000);
        } catch (IOException e) {
            System.out.println("Error in server1");
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Server1 Waiting...");
                client = server.accept();

                GetInfo info = new GetInfo(client);
                Thread infoTh = new Thread(info);
                infoTh.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
