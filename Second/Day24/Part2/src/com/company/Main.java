package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream in = new FileInputStream("List.txt");
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader bf = new BufferedReader(isr);

        while (true) {
            String line = null;

            try {
                line = bf.readLine();
            } catch (IOException e) {
                System.err.println("ERROR");
            }
            if (line == null) break;
            ThreadClass threadClass = new ThreadClass(line);
            Thread th = new Thread(threadClass);
            th.start();
        }
    }
}
