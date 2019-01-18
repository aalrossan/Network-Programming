package com.company;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        FileInputStream in = new FileInputStream("Sample.pptx");
        BufferedInputStream bin = new BufferedInputStream(in);

        FileOutputStream out = new FileOutputStream("sample.zip");
        BufferedOutputStream bout = new BufferedOutputStream(out);
        ZipOutputStream zout = new ZipOutputStream(bout);
        ZipEntry z = new ZipEntry("Sample.pptx");
        zout.putNextEntry(z);

        while (true) {
            int b = bin.read();
            if (b == -1) break;
            zout.write(b);
        }

        bin.close();
        zout.closeEntry();
        System.out.println(z.getCompressedSize()); // new Size for zip entry.
        System.out.println(z.getSize()); //orginal size the zip entry file.
        zout.close();
        long end = System.currentTimeMillis();
        System.err.println(end - start);
    }
}
