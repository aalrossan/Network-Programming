package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        FileOutputStream out = null;

        try {
            // Fail
            // out = new FileOutputStream("G:\\ahmad.txt");

            // Success
            out = new FileOutputStream("ahmad.txt");

            try {
                out.write('A');
                out.write('H');
                out.write('M');
                out.write('A');
                out.write('D');
                out.write('\r');
                out.write('\n');
                // Error
                // out.close();
                out.write('A');
                out.write('L');
                out.write('R');
                out.write('O');
                out.write('S');
                out.write('A');
                out.write('N');
            } catch (IOException e) {
                System.err.println("Error in Writing");
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error in Output File");
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
