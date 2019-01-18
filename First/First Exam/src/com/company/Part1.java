package com.company;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Part1 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        FileInputStream in1 = new FileInputStream("Test1.txt");
        BufferedInputStream bin1 = new BufferedInputStream(in1);

        FileInputStream in2 = new FileInputStream("Test2.txt");
        BufferedInputStream bin2 = new BufferedInputStream(in2);

        byte[] contentTest1 = bin1.readAllBytes();
        byte[] contentTest2 = bin2.readAllBytes();

        long sizeTest1 = bin1.available();
        long sizeTest2 = bin2.available();

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
            System.out.println("Check Contents without Filtering Classes: Not Identical");
        } else {
            System.out.println("Check Contents without Filtering Classes: Identical");
        }

        bin1.close();
        bin2.close();

        long end = System.currentTimeMillis();
        System.out.println("Done in: " + (end-start) + " millsecond");
    }
}
