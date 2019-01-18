package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client implements Runnable {
    private Socket client1;
    private Socket client2;
    private BufferedReader bf1;
    private BufferedReader bf2;
    private PrintWriter pw1;
    private PrintWriter pw2;
    private String Id;

    public Client(String Id) {
        this.Id = Id;
        try {
            client1 = new Socket(InetAddress.getLocalHost(), 8000);
            client2 = new Socket(InetAddress.getLocalHost(), 9000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            bf1 = new BufferedReader(new InputStreamReader(client1.getInputStream()));
            bf2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));
            pw1 = new PrintWriter(client1.getOutputStream());
            pw2 = new PrintWriter(client2.getOutputStream());

            String IP = bf1.readLine();
            String  PC_Name = bf1.readLine();
            System.out.println(IP);
            System.out.println(PC_Name);

            pw2.println(Id);
            pw2.println(PC_Name);
            pw2.println(IP);
            pw2.flush();
            pw2.close();
            pw1.close();
            bf1.close();
            bf2.close();
            client1.close();
            client2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
