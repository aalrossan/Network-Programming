package com.company;

import java.io.*;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash implements Runnable {
    private String file_name;

    public Hash(String file_name) {
        this.file_name = file_name;
    }

    public void calculationHash() throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        FileInputStream in = new FileInputStream("Test/" + file_name);
        BufferedInputStream bin = new BufferedInputStream(in);
        DigestInputStream din = new DigestInputStream(bin, md);

        FileOutputStream out = new FileOutputStream("Hash/" + file_name + ".txt");
        din.readAllBytes();

        byte[] hash = din.getMessageDigest().digest();
        out.write(hash);
        // System.out.print(file_name + ": ");
        // for (int i = 0; i < hash.length; i++) {
            // System.out.print(hash[i] + " ");
        // }
        // System.out.println();

        din.close();
        out.close();
    }

    @Override
    public void run() {
        try {
            calculationHash();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
