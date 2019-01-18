package com.company;

import java.io.*;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Reserver {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        FileInputStream in = new FileInputStream("ahmad.pptx");
        BufferedInputStream bin = new BufferedInputStream(in);
        DigestInputStream din = new DigestInputStream(bin, md);

        while (din.read() != -1);

        FileInputStream ha = new FileInputStream("hash.txt");
        byte[] hash = new byte[ha.available()];
        ha.read(hash);

        byte[] h = din.getMessageDigest().digest();

        boolean flag = true;

        for (int i = 0; i < h.length; i++) {
            if (h[i] != hash[i]) {
                flag = false;
                break;
            }
        }

        if (!flag) {
            System.out.println("The File has been altered");
        } else {
            System.out.println("The File is OK");
        }
    }
}
