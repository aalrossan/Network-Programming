package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable {
    private Socket client;
    private BufferedReader bf;
    private PrintWriter pw;
    private String equipment;

    public Client(String equipment) {
        this.equipment = equipment;
    }

    @Override
    public void run() {
        try {
            client = new Socket(InetAddress.getLocalHost(), 9000);
            bf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            pw = new PrintWriter(client.getOutputStream());
            pw.println(equipment);
            pw.flush();
            String s = bf.readLine();
            System.out.println("Client result from server: " + s);
            pw.close();
            bf.close();
            client.close();
        } catch (UnknownHostException e) {
            System.out.println("invalid IP");
        } catch (IOException e) {
            System.out.println("invalid Port");
        }

    }
}
