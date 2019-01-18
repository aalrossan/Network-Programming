package com.company;

import java.io.*;
import java.security.DigestInputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        long start = System.currentTimeMillis();

        MessageDigest md = MessageDigest.getInstance("MD5");
        FileInputStream in = new FileInputStream("Test.txt");
        BufferedInputStream bin = new BufferedInputStream(in);
        DigestInputStream din = new DigestInputStream(bin, md);

        FileOutputStream out = new FileOutputStream("Ahmad.txt");
        BufferedOutputStream bout = new BufferedOutputStream(out);
        DigestOutputStream dout = new DigestOutputStream(bout, md);

        while (true) {
            int b = din.read();
            if (b == -1) break;
            dout.write(Character.toUpperCase(b));
        }

        byte[] hash1 = din.getMessageDigest().digest();
        byte[] hash2 = dout.getMessageDigest().digest();

        boolean flag = false;
        if (hash1.equals(hash2)) {
            System.out.println("The Two Files is Same");
        } else {
            System.out.println("The Two Files is Not Same");
        }

        din.close();
        dout.close();

        long end = System.currentTimeMillis();

        System.out.println("Time is: " + (end-start));
    }

    // Used Not Buffered => Time is : 21868
    // Used Buffered => Time is : 136
}
