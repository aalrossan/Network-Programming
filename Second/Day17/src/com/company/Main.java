package com.company;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        long start = System.currentTimeMillis();

        String[] files = { "Sample1.pptx", "Sample2.txt", "Sample3.pptx", "Sample4.txt", "Sample5.pptx", "Sample6.txt", "Sample7.pptx", "Sample8.txt", "Sample9.pptx", "Sample10.txt", "Sample11.pptx", "Sample12.txt", "Sample13.pptx", "Sample14.txt", "Sample15.pptx", "Sample16.txt", "Sample17.pptx", "Sample18.txt", "Sample19.pptx", "Sample20.txt", "Sample21.pptx", "Sample22.txt", "Sample23.pptx", "Sample24.txt" };

        for (int i = 0; i < files.length; i++) {
            Hash h = new Hash(files[i]);
            // With Thread
            Thread th = new Thread(h);
            th.start();

            // Without Thread
            // h.calculationHash();
        }

        long end = System.currentTimeMillis();
        System.out.println("Total Time: " + (end-start));
    }
}
