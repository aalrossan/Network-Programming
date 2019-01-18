package com.company;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        FileInputStream in = new FileInputStream("Sample.txt");
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader bfr = new BufferedReader(isr);

        FileOutputStream out = new FileOutputStream("test.txt");
        PrintWriter pw = new PrintWriter(out);

        ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("testzip.zip"));
        ZipEntry z = new ZipEntry("Sample.txt");
        zout.putNextEntry(z);

        String line = bfr.readLine();
        while (line != null) {
            zout.write(line.getBytes());
            zout.write('\n');
            pw.println(line);
            line = bfr.readLine();
        }


        pw.flush();
        bfr.close();
        pw.close();
        zout.closeEntry();
        zout.close();


        long end = System.currentTimeMillis();
        System.out.println("time is: " + (end-start));
    }
}
