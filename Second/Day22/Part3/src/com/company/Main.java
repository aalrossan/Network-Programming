package com.company;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        InetAddress[] ips = null;

        while (true) {
            try {
                System.out.print("Please Enter Host: ");
                String host = in.next();
                ips = InetAddress.getAllByName(host);
                for (int i = 0; i < ips.length; i++) {
                    System.out.println("IP: " + ips[i]);
                }
                System.out.println("-------------------");
            } catch (UnknownHostException e) {
                System.out.println("IP does exist");
                break;
            }
        }
    }
}
