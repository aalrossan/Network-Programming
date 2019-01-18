package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Calc implements Runnable {
    private Socket client;
    private BufferedReader bf;
    private PrintWriter pw;

    public Calc(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            bf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            pw = new PrintWriter(client.getOutputStream());
            String s = bf.readLine();
            int x = 0, y = 0, z = 0;
            if (s.contains("+")) {
                x = Integer.parseInt(s.substring(0, s.indexOf('+')));
                y = Integer.parseInt(s.substring(s.indexOf('+')+1));
                z = x + y;
            } else if (s.contains("-")) {
                x = Integer.parseInt(s.substring(0, s.indexOf('-')));
                y = Integer.parseInt(s.substring(s.indexOf('-')+1));
                z = x - y;
            } else if (s.contains("*")) {
                x = Integer.parseInt(s.substring(0, s.indexOf('*')));
                y = Integer.parseInt(s.substring(s.indexOf('*')+1));
                z = x * y;
            } else if (s.contains("/")) {
                x = Integer.parseInt(s.substring(0, s.indexOf('/')));
                y = Integer.parseInt(s.substring(s.indexOf('/')+1));
                z = x / y;
            } else {
                pw.println("invalid equation");
            }
            pw.println(s + " = " + z);
            pw.flush();
            pw.close();
            bf.close();
            client.close();
        } catch (IOException e) {
            pw.println("invalid equation");
        }
    }
}
