package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FileOutputStream out = null;

        byte[] name = { 'A', 'H', 'M', 'A', 'D' };
        String name2 = "ahmad";
        byte[] arr = name2.getBytes();

        try {
            out = new FileOutputStream("ahmad.txt");
            out.write(name);
            out.write('\n');
            out.write(name, 0, 3);
            out.write('\n');
            out.write(arr);
            out.write('\n');
            out.write(arr, 0, 3);
            out.write('\n');
        } catch (FileNotFoundException e) {
            System.err.println("Error In The File");
        }
        out.close();
    }
}
