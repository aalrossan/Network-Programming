package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FileInputStream in = null;

        in = new FileInputStream("sample.txt");

        int size = in.available();
        System.out.println(size);

        byte[] arr = new byte[size];
        in.read(arr);

        for (int i = 0 ; i < arr.length; i++) {
            System.out.print((char)arr[i]);
        }
        System.out.println();

//        byte[] arr = new byte[in.available()];
//        in.read(arr, 0, 5);
//        for (int i = 0; i < 5; i++) {
//            System.out.println((char)arr[i]);
//        }


    }
}
