package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class GetInfo implements Runnable {
    private Socket client;
    private PrintWriter pw;

    public GetInfo(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            pw = new PrintWriter(client.getOutputStream());
            pw.println(InetAddress.getLocalHost().getHostName());
            pw.println(InetAddress.getLocalHost().getHostAddress());

            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
