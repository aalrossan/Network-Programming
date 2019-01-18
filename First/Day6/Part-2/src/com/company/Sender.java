package com.company;

import java.io.*;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sender {
    public static  byte[] hash;
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        FileOutputStream h = new FileOutputStream("hash.txt");

        MessageDigest md = MessageDigest.getInstance("MD5");
        FileInputStream in = new FileInputStream("Sample.pptx");
        BufferedInputStream bin = new BufferedInputStream(in);

        FileOutputStream out = new FileOutputStream("ahmad.pptx");
        BufferedOutputStream bout = new BufferedOutputStream(out);
        DigestOutputStream dout = new DigestOutputStream(bout, md);

        while (true) {
            int b = bin.read();
            if (b == -1) break;
            dout.write(b);
        }

        hash = dout.getMessageDigest().digest();
        h.write(hash);

        bin.close();
        dout.close();
        h.close();
    }
}
