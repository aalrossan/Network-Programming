package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private static BufferedReader bf;
    private static Socket client;

    public static void main(String[] args) {
        try {
            client = new Socket(InetAddress.getLocalHost(), 9000);
            bf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println(bf.readLine());
        } catch (IOException e) {
            System.out.println("Error in client socket");
        }
    }
}
