package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class FactThread implements Runnable {
    private static Socket client;
    private static BufferedReader bf;
    private static PrintWriter pw;

    public FactThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
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
