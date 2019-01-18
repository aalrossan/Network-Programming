package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
    private static ServerSocket server;
    private static Socket client;
    private static PrintWriter pw;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(9000);
            while (true) {
                System.out.println("Server Waiting...");
                client = server.accept();
                pw = new PrintWriter(client.getOutputStream());
                System.out.println("Client: " + client.getInetAddress().getHostAddress());
                pw.println("Hello " + client.getInetAddress().getHostAddress());
                pw.println((new Date()).toString());
                pw.flush();
            }
        } catch (IOException e) {
            System.out.println("Error in server socket");
        }
    }

}
