package com.company;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part2 {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        long start = System.currentTimeMillis();

        MessageDigest md = MessageDigest.getInstance("MD5");

        FileInputStream in1 = new FileInputStream("Test1.txt");
        BufferedInputStream bin1 = new BufferedInputStream(in1);
        DigestInputStream din1 = new DigestInputStream(bin1, md);

        FileInputStream in2 = new FileInputStream("Test2.txt");
        BufferedInputStream bin2 = new BufferedInputStream(in2);
        DigestInputStream din2 = new DigestInputStream(bin2, md);

        din1.readAllBytes();
        din2.readAllBytes();

        byte[] contentTest1 = din1.getMessageDigest().digest();
        byte[] contentTest2 = din2.getMessageDigest().digest();

        long sizeTest1 = din1.available();
        long sizeTest2 = din2.available();

        boolean flag = true;

        for (int i = 0; i < contentTest1.length; i++) {
            if (contentTest1[i] != contentTest2[i]) {
                flag = false;
                break;
            }
        }

        if (sizeTest1 == sizeTest2) {
            System.out.println("Check Size: Files are Equal in Size");
        } else {
            System.out.println("Check Size: Files are Not Equal in Size");
        }

        if (!flag) {
            System.out.println("Check Contents with Filtering Classes: Not Identical");
        } else {
            System.out.println("Check Contents with Filtering Classes: Identical");
        }

        din1.close();
        din2.close();

        long end = System.currentTimeMillis();
        System.out.println("Done in: " + (end-start) + " millsecond");
    }
}
