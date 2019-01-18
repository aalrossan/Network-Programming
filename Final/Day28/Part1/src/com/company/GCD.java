package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GCD implements Runnable {
    private Socket client;
    private BufferedReader bf;
    private PrintWriter pw;

    public GCD(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            bf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            pw = new PrintWriter(client.getOutputStream());
            long num1 = Long.parseLong(bf.readLine());
            long num2 = Long.parseLong(bf.readLine());
            long n1 = num1;
            long n2 = num2;
            long r;

            while (n2 != 0) {
                r = n1 % n2;
                n1 = n2;
                n2 = r;
            }
            pw.println("GCD ("+num1+", "+num2+") = " + n1);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
