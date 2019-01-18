package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client implements Runnable {
    private static Socket client;
    private static BufferedReader bf;
    private static PrintWriter pw;
    private static long num;

    public Client(long num) {
        this.num = num;
        try {
            client = new Socket(InetAddress.getLocalHost(), 9000);
            bf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            pw = new PrintWriter(client.getOutputStream());
        } catch (IOException e) {
            System.out.println("Error in client socket");
        }
    }

    @Override
    public void run() {
        try {
            pw.println(num);
            pw.flush();
            System.out.println(bf.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
