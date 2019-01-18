package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FileOutputStream letter = null;
        FileOutputStream special = null;
        FileOutputStream digit = null;

        byte[] ASSCII = new byte[91];

        for (int i = 0; i < 91; i++) {
            ASSCII[i] = (byte)(i + 32);
            System.out.print((char)ASSCII[i]);
        }

        try {
            letter = new FileOutputStream("letter.txt");
            special = new FileOutputStream("special.txt");
            digit = new FileOutputStream("digit.txt");

            special.write(ASSCII, 0, 16);
            special.write('\r');
            special.write('\n');
            digit.write(ASSCII, 16, 10);
            digit.write('\r');
            digit.write('\n');
            special.write(ASSCII, 26, 7);
            special.write('\r');
            special.write('\n');
            letter.write(ASSCII, 33, 26);
            letter.write('\r');
            letter.write('\n');
            special.write(ASSCII, 59, 6);
            special.write('\r');
            special.write('\n');
            letter.write(ASSCII, 65, 26);
            letter.write('\r');
            letter.write('\n');
        } catch (FileNotFoundException e) {
            System.err.println("Error In The File");
        }
        letter.close();
        special.close();
        digit.close();
    }
}
