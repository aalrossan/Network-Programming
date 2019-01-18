package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        FileInputStream in = new FileInputStream("Sample.pptx");
        BufferedInputStream bin = new BufferedInputStream(in);

        FileOutputStream out = new FileOutputStream("ahmad.pptx");
        BufferedOutputStream bout = new BufferedOutputStream(out);

        System.out.println(bin.available());

        while (true) {
            int b = bin.read();
            if (b == -1) break;
            bout.write(b);
        }
        bin.close();
        bout.close();

        long end = System.currentTimeMillis();
        System.out.println("Time is: " + (end-start));
    }
}
