package com.company;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter IP Address: ");
        String host_name = input.nextLine();
        try {
            InetAddress ip = InetAddress.getByName(host_name);
            if (ip.getHostAddress().equals(InetAddress.getLocalHost().getHostAddress())) {
                NetworkInterface nic = NetworkInterface.getByIndex(4);
                System.out.println("Local Host NIC is: " + nic.getDisplayName());
            } else {
                System.out.print("enter timeout value in millisecond: ");
                int time = input.nextInt();
                if (ip.isReachable(time)) {
                    System.out.println(ip + " Reached in " + time + " millisecond");
                } else {
                    System.out.println(ip + " not Reached in " + time + " millisecond");
                }
            }

        } catch (UnknownHostException e) {

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}