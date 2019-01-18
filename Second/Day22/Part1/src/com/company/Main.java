package com.company;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) { //throws UnknownHostException {
        Scanner in = new Scanner(System.in);
        InetAddress ip = null;

        while (true) {
            try {
                System.out.print("Please Enter Host Name: ");
                String host = in.next();
                ip = InetAddress.getByName(host);
                System.out.println("Host Address: " + ip.getHostAddress());
                System.out.println("Host Name: " + ip.getHostName());
                System.out.println("------------------");
            } catch (UnknownHostException e) {
                System.out.println("IP does exist");
                break;
            }
        }
    }
}
