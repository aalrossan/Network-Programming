package com.company;

import java.net.NetworkInterface;
import java.net.SocketException;

public class Main {

    public static void main(String[] args) throws SocketException {
        NetworkInterface nic = NetworkInterface.getByIndex(4);
        System.out.println("getDisplayName: " + nic.getDisplayName());
        System.out.println("getHardwareAddress: " + nic.getHardwareAddress());
    }
}
