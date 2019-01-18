package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client implements Runnable {
    private Socket client;
    private BufferedReader bf;
    private PrintWriter pw;
    private long num1;
    private long num2;

    public Client(long num1, long num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        try {
            client = new Socket(InetAddress.getLocalHost(), 9000);
            bf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            pw = new PrintWriter(client.getOutputStream());
            pw.println(num1);
            pw.println(num2);
            pw.flush();
            System.out.println(bf.readLine());
        } catch (IOException e) {
            System.out.println("Error in client socket");
        }
    }
}
