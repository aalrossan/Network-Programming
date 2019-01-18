package com.company;

import java.io.IOException;
import java.net.InetAddress;

public class Main {

    public static void main(String[] args) throws IOException {
        InetAddress ip = InetAddress.getLocalHost();
        byte[] ipadd = ip.getAddress();

        System.out.println("Host Address: " + ip.getHostAddress());
        System.out.println("Host Name: " + ip.getHostName());
        System.out.println("--------------------");
        for (int i = 0; i < 10; i++) {
            int nextHost = (ipadd[3] < 0 ? (ipadd[3] + 26) : (ipadd[3] + 1));
            ipadd[3] = (byte)nextHost;
            InetAddress nextIP = InetAddress.getByAddress(ipadd);
            System.out.println("Host Address: " + nextIP.getHostAddress());
            System.out.println("Host Name: " + nextIP.getHostName());
            if (nextIP.isReachable(1000)) {
                System.out.println("is Running");
            } else {
                System.out.println("NOT Running");
            }
            System.out.println("--------------------");
        }
    }
}
