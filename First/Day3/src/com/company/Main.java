package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("sample.txt");
            out = new FileOutputStream("ahmad.txt");
            // out.write(in.readAllBytes());
            while (true) {
                int b = in.read();
                if (b == -1) break;
                System.out.print((char)b);
                out.write(b);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e);
        }
        in.close();
        out.close();
    }
}
