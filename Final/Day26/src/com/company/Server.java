package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private static ServerSocket server;
    private static Socket client;
    private static BufferedReader bf;
    private static PrintWriter pw;

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
                bf = new BufferedReader(new InputStreamReader(client.getInputStream()));
                pw = new PrintWriter(client.getOutputStream());
                long num = Long.parseLong(bf.readLine());
                long fact = 1;
                for (int i = 2; i <= num; i++) {
                    fact *= i;
                }
                pw.println(num + " != " + fact);
                pw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
