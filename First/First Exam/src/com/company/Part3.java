package com.company;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Part3 {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("Sample.txt");
        BufferedInputStream bin = new BufferedInputStream(in);

        FileOutputStream out = new FileOutputStream("sample.zip");
        BufferedOutputStream bout = new BufferedOutputStream(out);
        ZipOutputStream zout = new ZipOutputStream(bout);
        ZipEntry z = new ZipEntry("sample.txt");
        zout.putNextEntry(z);

        while (true) {
            int b = bin.read();
            if (b == -1) break;
            zout.write(b);
        }

        zout.closeEntry();
        zout.close();
        System.out.println("Size before: " + z.getSize());
        System.out.println("Size after: " + z.getCompressedSize());
    }
}
