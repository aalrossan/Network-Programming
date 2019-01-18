package com.company;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        long start = System.currentTimeMillis();

        MessageDigest md = MessageDigest.getInstance("MD5");
        FileInputStream in = new FileInputStream("Sample.pptx");
        BufferedInputStream bin = new BufferedInputStream(in);
        DigestInputStream din = new DigestInputStream(bin, md);

        din.readAllBytes();

        byte[] hash = din.getMessageDigest().digest();

        for (int i = 0; i < hash.length; i++) {
            System.out.print(hash[i] + " ");
        }
        System.out.println();

        din.close();

        long end = System.currentTimeMillis();
        System.out.println("Time is: " + (end-start));
    }
}
